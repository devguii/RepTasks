/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class Migration extends Database {
    private String[] migration;
    
    public Migration() {
        String[] migration = {
            "CREATE TABLE IF NOT EXISTS public.Users("
                + "id SERIAL NOT NULL PRIMARY KEY, "
                + "username VARCHAR(255) NOT NULL UNIQUE, "
                + "password VARCHAR(255) NOT NULL, "
                + "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                + "updated_at TIMESTAMP NULL"
                + ");",
            "CREATE TABLE IF NOT EXISTS public.Republic("
                + "id SERIAL NOT NULL PRIMARY KEY, "
                + "name VARCHAR(255) NOT NULL, "
                + "user_id INT NOT NULL, "
                + "FOREIGN KEY (user_id) REFERENCES Users(id), "
                + "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                + "updated_at TIMESTAMP NULL"
                + ");",
            "ALTER TABLE public.Users "
                + "ADD COLUMN republic_id INT NULL DEFAULT NULL, "
                + "ADD FOREIGN KEY (republic_id) REFERENCES Republic(id);",
            "CREATE TABLE IF NOT EXISTS public.Tasks("
                + "id SERIAL NOT NULL PRIMARY KEY, "
                + "title VARCHAR(255) NOT NULL, "
                + "description VARCHAR(255) NOT NULL, "
                + "republic_id INT NOT NULL, "
                + "user_id INT NOT NULL, "
                + "is_done SMALLINT NOT NULL DEFAULT 0, "
                + "FOREIGN KEY (republic_id) REFERENCES Republic(id), "
                + "FOREIGN KEY (user_id) REFERENCES Users(id), "
                + "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                + "updated_at TIMESTAMP NULL,"
                + "expires_at TIMESTAMP NOT NULL"
                + ");",
            "CREATE TABLE IF NOT EXISTS public.Feedbacks("
                + "id SERIAL NOT NULL PRIMARY KEY, "
                + "comment TEXT NULL, "
                + "score DECIMAL NOT NULL, "
                + "user_id INT NOT NULL, "
                + "task_id INT NOT NULL, "
                + "FOREIGN KEY (user_id) REFERENCES Users(id), "
                + "FOREIGN KEY (task_id) REFERENCES Tasks(id), "
                + "created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, "
                + "updated_at TIMESTAMP NULL"
                + ");"
        };
        
        
        this.migration = migration;
    }
    
    public void run() {
        boolean hasError = false;
        for (String migrate : this.migration) {
            try {
                this.connection.createStatement().execute(migrate);
                this.connection.commit();
            } catch (SQLException error) {
                hasError = true;
                //System.out.println(error.getMessage());
            }
        }
        if (!hasError) {
            JOptionPane.showMessageDialog(null, "Migração efetuada com sucesso!", "Migração", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
