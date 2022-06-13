/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DAO.FeedbackDAO;
import DAO.RepublicDAO;
import DAO.TaskDAO;
import DAO.UserDAO;
import Controllers.SignInController;


/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class App {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        TaskDAO taskDAO = new TaskDAO();
        RepublicDAO republicDAO = new RepublicDAO();
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        
        SignInController republic = new SignInController();
        republic.view();
    }
}
