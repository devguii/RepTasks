/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.UserModel;
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
    }
    
    public boolean create(UserModel user) {
        boolean isCreated = false;
        try {
            this.preparedStatement = this.connection.prepareStatement("INSERT INTO Users(id, username, password) VALUES (NULL, ?, ?)");
            this.preparedStatement.setString(1, user.getUsername());
            this.preparedStatement.setString(2, user.getPassword());
            int response = this.preparedStatement.executeUpdate();
            
            if (response == 1) {
                isCreated = true;
                this.connection.commit();
            } else {
                isCreated = false;
                this.connection.rollback();
            }
        } catch (SQLException error) {
            this.connection.rollback();
        } finally {
            return isCreated;
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
                userModel.setPassword(this.resultSet.getString("password"));
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar o usuário", "Banco de dados", JOptionPane.ERROR_MESSAGE);
        } finally {
            return userModel;
        }
    }
    
    public UserModel findByUsername(String username) {
        UserModel userModel = null;
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            this.preparedStatement.setString(1, username);
            this.resultSet = this.preparedStatement.executeQuery();
            
            if (this.resultSet.next()) {
                userModel = new UserModel();
                userModel.setId(this.resultSet.getInt("id"));
                userModel.setUsername(this.resultSet.getString("username"));
                userModel.setPassword(this.resultSet.getString("password"));
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário!", "Banco de dados", JOptionPane.ERROR_MESSAGE);
        } finally {
            return userModel;
        }
    }
}
