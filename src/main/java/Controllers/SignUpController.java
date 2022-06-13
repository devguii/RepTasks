/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import DAO.UserDAO;
import Models.UserModel;
import Views.SignUpView;
import com.password4j.Hash;
import com.password4j.Password;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class SignUpController {
    private SignInController signInController;
    private SignUpView signUpView;
    private UserDAO userDAO;
    
    public SignUpController(SignInController signInController) {
        this.signInController = signInController;
        this.userDAO = new UserDAO();
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

    public void register(String username, String password, String confirmPassword) {
        UserModel user = this.userDAO.findByUsername(username);
        
        if (confirmPassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Confirmar senha não coincide com a senha", "Cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (user != null) {
            JOptionPane.showMessageDialog(null, "Usuário existente!", "Cadastro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Hash passwordHash = Password.hash(password).addRandomSalt().withArgon2();
        user = new UserModel();
        user.setUsername(username);
        user.setPassword(passwordHash.getResult());
        
        if (this.userDAO.create(user)) {
            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!", "Cadastro", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível criar a conta!", "Cadastro", JOptionPane.ERROR_MESSAGE);
        }
        
        return;
    }   
}
