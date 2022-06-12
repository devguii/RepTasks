/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gabriel.raptasks.Controllers;

import gabriel.raptasks.Views.SignUpView;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class SignUpController {
    private SignInController signInController;
    private SignUpView signUpView;
    
    public SignUpController(SignInController signInController) {
        this.signInController = signInController;
        this.signUpView = new SignUpView(this);
    }
    
    public void view() {
        this.signUpView.setVisible(true);
    }
    
    public void close() {
        this.signUpView.setVisible(false);
    }
    
    public void toSignIn() {
        this.close();
        this.signInController.view();
    }
    
}
