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
public class TaskDAO extends Database {
    public TaskDAO() {
        super();
        if (!this.tableExists("Tasks")) {
            String query = "CREATE TABLE Tasks("
                    + "id SERIAL NOT NULL PRIMARY KEY,"
                    + "title VARCHAR(255) NOT NULL,"
                    + "description VARCHAR(255) NOT NULL,"
                    + "republic_id INT NOT NULL,"
                    + "user_id INT NOT NULL,"
                    + "is_done TINYINT NOT NULL,"
                    + "FOREIGN KEY (republic_id) REFERENCES Republic(id),"
                    + "FOREIGN KEY (user_id) REFERENCES Users(id),"
                    + "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
                    + "updated_at TIMESTAMP NULL,"
                    + "expires_at TIMESTAMP NOT NULL"
                    + ");";
            this.createTable(query);
        }
    }
}
