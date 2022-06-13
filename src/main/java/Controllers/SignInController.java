/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.UserDAO;
import Models.UserModel;
import Views.SignInView;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class SignInController {
    private SignInView signInView;
    private SignUpController signUpController;
    private RepublicController republicController;
    private UserModel userModel;
    private UserDAO userDAO;
    
    public SignInController() {
        this.userModel = new UserModel();
        this.signInView = new SignInView(this);
        this.signUpController = new SignUpController(this);
        this.republicController = new RepublicController(this);
    }
    
    public void view() {
        this.signInView.setVisible(true);
    }
    
    public void close() {
        this.signInView.setVisible(false);
    }
    
    public void toSignUp() {
        this.close();
        this.signUpController.view();
    }
    
    public void toRepublic() {
        this.close();
        this.republicController.view();
    }
    
    public boolean login(String username, String password) {
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        
        
        
        return true;
    }
}
