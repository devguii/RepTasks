/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gabriel.raptasks.Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class UserModel {
    private int id;
    private String username;
    private String password;
    private String passwordHash;
    private int republicId;
    private RepublicModel republic;
    private ArrayList<TaskModel> tasks;
    private Date createdAt;
    private Date updatedAt;
    
    public UserModel() { }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    public void setRepublicId(int republicId) {
        this.republicId = republicId;
    }
    
    public void setRepublic(RepublicModel republic) {
        this.republic = republic;
    }
    
    public void setTasks(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getPasswordHash() {
        return this.passwordHash;
    }
    
    public int getRepublicId() {
        return this.republicId;
    }
    
    public RepublicModel getRepublic() {
        return this.republic;
    }
    
    public ArrayList<TaskModel> getTasks() {
        return this.tasks;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}
