/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.UserModel;
import java.sql.SQLException;
import java.util.UUID;
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
            this.preparedStatement = this.connection.prepareStatement("INSERT INTO Users(username, password) VALUES (?, ?)");
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
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Users WHERE uuid = ?");
            this.preparedStatement.setInt(1, id);
            this.resultSet = this.preparedStatement.executeQuery();
            
            if (this.resultSet.next()) {
                userModel.setUuid(this.resultSet.getString("uuid"));
                userModel.setUsername(this.resultSet.getString("username"));
                userModel.setPassword(this.resultSet.getString("password"));
                userModel.setRepublicUuid(this.resultSet.getString("republic_uuid"));
                userModel.setCreatedAt(this.resultSet.getTimestamp("created_at"));
                userModel.setUpdatedAt(this.resultSet.getTimestamp("updated_at"));
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
                userModel.setUuid(this.resultSet.getString("uuid"));
                userModel.setUsername(this.resultSet.getString("username"));
                userModel.setPassword(this.resultSet.getString("password"));
                userModel.setRepublicUuid(this.resultSet.getString("republic_uuid"));
                userModel.setCreatedAt(this.resultSet.getTimestamp("created_at"));
                userModel.setUpdatedAt(this.resultSet.getTimestamp("updated_at"));
            }
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário!", "Banco de dados", JOptionPane.ERROR_MESSAGE);
        } finally {
            return userModel;
        }
    }
}
