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
public class RepublicModel {
    private UUID uuid;
    private String name;
    private UserModel userOwner;
    private ArrayList<TaskModel> tasks;
    private ArrayList<UserModel> users;
    private Date createdAt;
    private Date updatedAt;
    
    public RepublicModel() { }
    
    public void setUuid(String uuid) {
        try {
            this.uuid = UUID.fromString(uuid);
        } catch (Exception error) {
            this.uuid = null;
        }
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setUserOwner(UserModel userOwner) {
        this.userOwner = userOwner;
    }
    
    public void setTasks(ArrayList<TaskModel> tasks) {
        this.tasks = tasks;
    }
    
    public void setUsers(ArrayList<UserModel> users) {
        this.users = users;
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
    
    public String getName() {
        return this.name;
    }
    
    public UserModel getUserOwner() {
        return this.userOwner;
    }
    
    public ArrayList<TaskModel> getTasks() {
        return this.tasks;
    }
    
    public ArrayList<UserModel> getUsers() {
        return this.users;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}
