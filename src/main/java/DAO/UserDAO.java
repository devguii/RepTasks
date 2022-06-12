/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import gabriel.raptasks.Models.UserModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utils.Database;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class UserDAO extends Database {
    public UserDAO() {
        super();
        if (!this.tableExists("Users")) {
            String query = "CREATE TABLE users("
                    + "id SERIAL NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "username VARCHAR(255) NOT NULL UNIQUE,"
                    + "password VARCHAR(255) NOT NULL,"
                    + "republic_id INT NULL);";
            this.createTable(query);
        }
    }
    
    public UserModel findById(int id) {
        UserModel userModel = new UserModel();
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Users WHERE id = ?");
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            
            if (this.resultSet.next()) {
                userModel.setId(this.resultSet.getInt("id"));
                userModel.setUsername(this.resultSet.getString("username"));
                userModel.setPasswordHash(this.resultSet.getString("password"));
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o usuário", "Banco de dados", JOptionPane.ERROR_MESSAGE);
        } finally {
            return userModel;
        }
    }
    
    public UserModel findByUsername(String username) {
        UserModel userModel = new UserModel();
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            this.preparedStatement.setString(1, username);
            this.resultSet = this.preparedStatement.executeQuery();
            
            if (this.resultSet.next()) {
                userModel.setId(this.resultSet.getInt("id"));
                userModel.setUsername(this.resultSet.getString("username"));
                userModel.setPasswordHash(this.resultSet.getString("password"));
            }
        } catch (SQLException error) {
            
        } finally {
            return userModel;
        }
    }
}
