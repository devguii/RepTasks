/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import utils.Database;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class FeedbackDAO extends Database {
    public FeedbackDAO() {
        super();
        if (!this.tableExists("Feedbacks")) {
            String query = "CREATE TABLE Feedbacks("
                    + ");";
        }
    }
}
