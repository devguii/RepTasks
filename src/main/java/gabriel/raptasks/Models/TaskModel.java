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
public class TaskModel {
    private int id;
    private String title;
    private String description;
    private int republicId;
    private int userId;
    private RepublicModel republic;
    private UserModel user;
    private boolean isDone;
    private Date createdAt;
    private Date updatedAt;
    private Date expiresAt;
    
    public TaskModel() { }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
        
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setRepublic(RepublicModel republic) {
        this.republic = republic;
    }
    
    public void setUser(UserModel user) {
        this.user = user;
    }
    
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public RepublicModel getRepublic() {
        return this.republic;
    }
    
    public UserModel getUser() {
        return this.user;
    }
    
    public boolean getIsDone() {
        return this.isDone;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public Date getExpiresAt() {
        return this.expiresAt;
    }
}
