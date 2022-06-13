/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class FeedbackModel {
    private String comment;
    private double score;
    private int userId;
    private int taskId;
    private UserModel user;
    private TaskModel task;
    private Date createdAt;
    private Date updatedAt;
    
    public FeedbackModel() { }
    
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public void setScore(double score) {
        this.score = score;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    
    public void setUser(UserModel user) {
        this.user = user;
    }
    
    public void setTask(TaskModel task) {
        this.task = task;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public double getScore() {
        return this.score;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public int getTaskId() {
        return this.taskId;
    }
    
    public UserModel getUser() {
        return this.user;
    }
    
    public TaskModel getTask() {
        return this.task;
    }
    
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
}
