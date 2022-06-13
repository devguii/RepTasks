/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class FeedbackModel {
    private String comment;
    private double score;
    private UUID userUuid;
    private UUID taskUuid;
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
    
    public void setUserUuid(String userUuid) {
        try {
            this.userUuid = UUID.fromString(userUuid);
        } catch (Exception error) {
            this.userUuid = null;
        }
    }
    
    public void setTaskUuid(String taskUuid) {
        try {
            this.taskUuid = UUID.fromString(taskUuid);
        } catch (Exception error) {
            this.taskUuid = null;
        }
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
    
    public UUID getUserId() {
        return this.userUuid;
    }
    
    public UUID getTaskUuid() {
        return this.taskUuid;
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
