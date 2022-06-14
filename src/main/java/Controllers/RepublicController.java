/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.RepublicDAO;
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
    private RepublicView republicView;
    private SignInController signInController;
    private UserModel user;
    private RepublicModel republic;
    private ArrayList<TaskModel> tasks;
    
    public RepublicController(SignInController signInController) {
        this.signInController = signInController;
        this.republicView = new RepublicView(this);
        this.republicDAO = new RepublicDAO();
        this.userDAO = new UserDAO();
    }
    
    public void view() {
        this.republicView.setVisible(true);
    }
    
    public void close() {
        this.republicView.setVisible(false);
    }
    
    public void setFeedbacks() {
        
    }
    
    public void setRepublic() {
        String republicUuid = this.user.getRepublicUuid().toString();
        this.republic = this.republicDAO.findByUuid(republicUuid);
        //this.republicView.setRepublic(this.republic);
    }
    
    public void setUser(UserModel user) {
        this.user = user;
        if (this.user.getRepublicUuid() != null) {
            this.setRepublic();
        }
        this.republicView.setUser(user);
    }
    
    public UserModel getUser() {
        return this.user;
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
            this.setUser(this.user);

            JOptionPane.showMessageDialog(null, "República criada com sucesso!", "República", JOptionPane.INFORMATION_MESSAGE);
            //this.republicView.viewTasksView();
            return;
        }
        
        JOptionPane.showMessageDialog(null, "Não foi possível criar a república!", "República", JOptionPane.ERROR_MESSAGE);
        return;
    }
}
