/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.RepublicDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import Models.RepublicModel;
import Models.TaskModel;
import Models.UserModel;
import Views.RepublicView;
import com.password4j.Hash;
import com.password4j.Password;
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
            this.republicView.setUser(user);
            this.republic = this.republicDAO.findByUuid(this.user.getRepublicUuid().toString());
            
            if (this.republic == null) {
                return;
            }
            
            this.republicView.setRepublic(republic);
            
            this.tasks = this.taskDAO.findAllTasksByRepublicUuid(this.republic.getUuid().toString());
            this.users = this.userDAO.findAllByRepublicUuid(this.user.getRepublicUuid().toString());
            
            this.republicView.setTasks(tasks);
            this.republicView.setUsers(users);
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
}
