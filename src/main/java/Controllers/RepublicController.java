/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.FeedbackDAO;
import DAO.RepublicDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import Models.FeedbackModel;
import Models.RepublicModel;
import Models.TaskModel;
import Models.UserModel;
import Views.AddTaskView;
import Views.RepublicView;
import Views.TaskView;
import Views.UserView;
import com.password4j.Hash;
import com.password4j.Password;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class RepublicController {
    private String userUuid;
    private RepublicDAO republicDAO;
    private UserDAO userDAO;
    private TaskDAO taskDAO;
    private RepublicView republicView;
    private SignInController signInController;
    private UserModel user;
    private RepublicModel republic;
    private ArrayList<TaskModel> tasks;
    private ArrayList<UserModel> users;
    private MyProfileController myProfileController;
    private MyTasksController myTasksController;
    private TaskView taskView;
    private UserView userView;
    private FeedbackDAO feedbackDAO;
    private AddTaskView addTaskView;
    
    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }
    
    public String getUserUuid() {
        return this.userUuid;
    }
    
    public RepublicController(SignInController signInController) {
        this.signInController = signInController;
        this.republicView = new RepublicView(this);
        this.republicDAO = new RepublicDAO();
        this.userDAO = new UserDAO();
        this.taskDAO = new TaskDAO();
        this.myProfileController = new MyProfileController(this);
        this.myTasksController = new MyTasksController(this);
        this.taskView = new TaskView(this);
        this.userView = new UserView(this);
        this.feedbackDAO = new FeedbackDAO();
        this.addTaskView = new AddTaskView(this);
    }
    
    public void view() {
        this.republicView.setVisible(true);
    }
    
    public void close() {
        this.republicView.setVisible(false);
    }
    
    public void load() {
        this.user = this.userDAO.findByUuid(this.userUuid);
        
        if (this.user != null) {
            this.republicView.setIsLoggedInLabel(this.user.getName());
            
            this.republicView.setUser(user);
            this.republic = this.republicDAO.findByUuid(this.user.getRepublicUuid().toString());
            
            if (this.republic == null) {
                System.out.println("Republic is null - load()");
                return;
            }
            
            this.republicView.setRepublic(republic);
            
            this.tasks = this.taskDAO.findAllTasksByRepublicUuid(this.republic.getUuid().toString());
            this.users = this.userDAO.findAllByRepublicUuid(this.republic.getUuid().toString());
            
            this.republicView.setTasks(tasks);
            this.republicView.setUsers(users);
            
            double score = 0.0;
            double i = 0;
            
            for (FeedbackModel feedback : this.feedbackDAO.findAllByUserUuid(this.user.getUuid().toString())) {
                score += feedback.getScore();
                i++;
            }
            
            if (i != 0) {
                score /= i;
            }
            
            this.republicView.setScore(score);
            
            if (!this.user.getUuid().equals(this.republic.getUserUuid())) {
                this.republicView.setNotAdministrator();
            }
            
            this.republicView.load();
        } else {
            this.signInController.view();
            this.close();
        }
    }
    
    public void create(String name, String password) {
        RepublicModel republic = this.republicDAO.findByName(name);
        
        if (republic != null) {
            JOptionPane.showMessageDialog(null, "República existente!", "República", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (password.length() < 6) {
            JOptionPane.showMessageDialog(null, "Senha da república requer no mínimo 6 caracteres!", "República", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        republic = new RepublicModel();
        republic.setName(name);
        Hash passwordHashed = Password.hash(password).addRandomSalt().withArgon2();
        republic.setPassword(passwordHashed.getResult());
        republic.setUserUuid(this.user.getUuid().toString());
        
        if (this.republicDAO.create(republic)) {
            republic = null;
            republic = this.republicDAO.findByName(name);

            this.user.setRepublicUuid(republic.getUuid().toString());
            this.user = this.userDAO.update(this.user);
            this.load();

            JOptionPane.showMessageDialog(null, "República criada com sucesso!", "República", JOptionPane.INFORMATION_MESSAGE);
            //this.republicView.viewTasksView();
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Não foi possível criar a república!", "República", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    public void openUserView(String uuidUser) {
        
    }
    
    public void openTaskView(String uuidTask) {
        TaskModel task = this.taskDAO.findByUuid(uuidTask);
        FeedbackModel feedback = this.feedbackDAO.findByTaskUuidAndUserUuid(uuidTask, this.userUuid);
        
        if (task == null) {
            JOptionPane.showMessageDialog(null, "Tarefa inexistente!", "República", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.taskView.setTaskModel(task);
        this.taskView.setUserModel(this.user);
        this.taskView.setFeedbackModel(feedback);
        this.taskView.load();
        this.taskView.setVisible(true);
    }
    
    public void addTask(String title, String description, String userUuid, LocalDateTime expiresAt) {
        TaskModel task = new TaskModel();
        
        task.setTitle(title);
        task.setDescription(description);
        task.setUserUuid(userUuid);
        task.setRepublicUuid(this.republic.getUuid().toString());
        task.setExpiresAt(expiresAt);
        
        if (!expiresAt.isAfter(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Data de expiração inválida!", "Tarefas", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!this.taskDAO.create(task)) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar a tarefa!", "Tarefas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        this.load();
        JOptionPane.showMessageDialog(null, "Tarefa criada com sucesso!", "Tarefas", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
    
    public void openAddTaskView() {
        if (this.republic.getUserUuid().equals(this.user.getUuid())) {
            this.addTaskView.setUsers(this.users);
            this.addTaskView.setVisible(true);
        }
    }
    
    public UserModel findUserByUuid(String uuid) {
        return this.userDAO.findByUuid(uuid);
    }
    
    public void logout() {
        this.close();
        this.signInController.viewDeleteSession();
    }
}
