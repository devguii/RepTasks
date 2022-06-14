/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.FeedbackModel;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PGobject;
import utils.Database;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class FeedbackDAO extends Database {
    public FeedbackDAO() {
        super();
    }
    
    public boolean create(FeedbackModel feedback) {
        boolean isCreated = false;
        try {
            this.preparedStatement = this.connection.prepareStatement("INSERT INTO Feedbacks(user_uuid, task_uuid, comment) VALUES (?, ?, ?)");
            PGobject userUuidObject = new PGobject();
            userUuidObject.setType("uuid");
            userUuidObject.setValue(feedback.getUserUuid().toString());

            PGobject taskUuidObject = new PGobject();
            taskUuidObject.setType("uuid");
            taskUuidObject.setValue(feedback.getTaskUuid().toString());
            
            this.preparedStatement.setObject(1, userUuidObject);
            this.preparedStatement.setObject(2, taskUuidObject);
            this.preparedStatement.setString(3, feedback.getComment());
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

    public ArrayList<FeedbackModel> findByTaskUuid(String taskUuid) {
        ArrayList<FeedbackModel> feedbacks = new ArrayList<>();
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Feedbacks WHERE task_uuid = ?");
            PGobject taskUuidObject = new PGobject();
            taskUuidObject.setType("uuid");
            taskUuidObject.setValue(taskUuid);
            this.preparedStatement.setObject(1, taskUuidObject);
            this.resultSet = this.preparedStatement.executeQuery();
            
            while (this.resultSet.next()) {
                FeedbackModel feedback = new FeedbackModel();
                feedback.setUuid(this.resultSet.getString("uuid"));
                feedback.setUserUuid(this.resultSet.getString("user_uuid"));
                feedback.setTaskUuid(this.resultSet.getString("task_uuid"));
                feedback.setComment(this.resultSet.getString("comment"));
                feedback.setCreatedAt(this.resultSet.getTimestamp("created_at").toLocalDateTime());
                feedback.setUpdatedAt(this.resultSet.getTimestamp("updated_at").toLocalDateTime());
                feedbacks.add(feedback);
            }
        } catch (SQLException error) {
            this.connection.rollback();
        } finally {
            return feedbacks;
        }
    }

    public FeedbackModel findByTaskUuidAndUserUuid(String taskUuid, String userUuid) {
        FeedbackModel feedback = null;
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Feedbacks WHERE task_uuid = ? AND user_uuid = ?");
            PGobject taskUuidObject = new PGobject();
            taskUuidObject.setType("uuid");
            taskUuidObject.setValue(taskUuid);

            PGobject userUuidObject = new PGobject();
            userUuidObject.setType("uuid");
            userUuidObject.setValue(userUuid);
            this.preparedStatement.setObject(1, taskUuidObject);
            this.preparedStatement.setObject(2, userUuidObject);
            this.resultSet = this.preparedStatement.executeQuery();
            
            if (this.resultSet.next()) {
                feedback = new FeedbackModel();
                feedback.setUuid(this.resultSet.getString("uuid"));
                feedback.setUserUuid(this.resultSet.getString("user_uuid"));
                feedback.setTaskUuid(this.resultSet.getString("task_uuid"));
                feedback.setComment(this.resultSet.getString("comment"));
                feedback.setCreatedAt(this.resultSet.getTimestamp("created_at").toLocalDateTime());
                feedback.setUpdatedAt(this.resultSet.getTimestamp("updated_at").toLocalDateTime());
            }
        } catch (SQLException error) {
            this.connection.rollback();
        } finally {
            return feedback;
        }
        
    }
}
