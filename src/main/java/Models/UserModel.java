/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class UserModel {
    private UUID uuid;
    private String username;
    private String password;
    private UUID republicUuid;
    private RepublicModel republic;
    private ArrayList<TaskModel> tasks;
    private Date createdAt;
    private Date updatedAt;
    
    public UserModel() { }
    
    public void setUuid(String uuid) {
        try {
            this.uuid = UUID.fromString(uuid);
        } catch (Exception error) {
            this.uuid = null;
        }
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRepublicUuid(String republicUuid) {
        try {
            this.republicUuid = UUID.fromString(republicUuid);
        } catch (Exception error) {
            this.republicUuid = null;
        }
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
    
    public UUID getUuid() {
        return this.uuid;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public UUID getRepublicUuid() {
        return this.republicUuid;
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
