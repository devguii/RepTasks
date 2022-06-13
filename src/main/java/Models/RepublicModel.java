/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class RepublicModel {
    private int id;
    private String name;
    private UserModel userOwner;
    private ArrayList<TaskModel> tasks;
    private ArrayList<UserModel> users;
    private Date createdAt;
    private Date updatedAt;
    
    public RepublicModel() { }
    
    public void setId(int id) {
        this.id = id;
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
    
    public int getId() {
        return this.id;
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
