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
public class RepublicDAO extends Database {
    public RepublicDAO() {
        super();
        if (!this.tableExists("Republic")) {
            String query = "CREATE TABLE Republic("
                    + "id SERIAL NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "user_id INT NOT NULL,"
                    + "FOREIGN KEY (user_id) REFERENCES Users(id),"
                    + "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                    + "updated_at TIMESTAMP NULL"
                    + ");";
            this.createTable(query);
        }
    }
}
