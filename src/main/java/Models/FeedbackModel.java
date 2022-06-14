/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class FeedbackModel {
    private UUID uuid;
    private String comment;
    private double score;
    private UUID userUuid;
    private UUID taskUuid;
    private UserModel user;
    private TaskModel task;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public FeedbackModel() { }
    
    public void setUuid(String uuid) {
        try {
            this.uuid = UUID.fromString(uuid);
        } catch (Exception error) {
            this.uuid = null;
        }
    }
    
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
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    public UUID getUuid() {
        return this.uuid;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public double getScore() {
        return this.score;
    }
    
    public UUID getUserUuid() {
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
    
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
}
