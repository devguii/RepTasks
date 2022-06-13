/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.UserModel;
import Views.Partials.ChooserEnterCreate;
import Views.RepublicView;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class RepublicController {
    private RepublicView republicView;
    private SignInController signInController;
    private UserModel user;
    
    public RepublicController(SignInController signInController) {
        this.signInController = signInController;
        this.republicView = new RepublicView(this);
    }
    
    public void view() {
        this.republicView.viewContentPanel();
        this.republicView.setVisible(true);
    }
    
    public void close() {
        this.republicView.setVisible(false);
    }
    
    public void setUser(UserModel user) {
        this.user = user;
        this.republicView.setUser(user);
    }
    
    public UserModel getUser() {
        return this.user;
    }
}
