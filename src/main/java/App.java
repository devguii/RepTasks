/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Controllers.SignInController;
import utils.Migration;


/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class App {
    public static void main(String[] args) {
        Migration migration = new Migration();
        migration.run();
        
        SignInController republic = new SignInController();
        republic.view();
    }
}
