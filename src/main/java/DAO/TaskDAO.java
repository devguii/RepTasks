/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TaskModel;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.postgresql.util.PGobject;
import utils.Database;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class TaskDAO extends Database {
    public TaskDAO() {
        super();
    }

    public ArrayList<TaskModel> findAllTasksByRepublicUuid(String uuid) {
        ArrayList<TaskModel> tasks = new ArrayList<>();
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Tasks WHERE republic_uuid = ?");
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(uuid);
            this.preparedStatement.setObject(1, uuidObject);
            this.resultSet = this.preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                TaskModel task = new TaskModel();
                task.setUuid(this.resultSet.getString("uuid"));
                task.setTitle(this.resultSet.getString("title"));
                task.setDescription(this.resultSet.getString("description"));
                task.setCreatedAt(this.resultSet.getTimestamp("created_at").toLocalDateTime());
                task.setUpdatedAt(this.resultSet.getTimestamp("updated_at").toLocalDateTime());
                task.setIsDone(this.resultSet.getBoolean("is_done"));
                task.setRepublicUuid(this.resultSet.getString("republic_uuid"));
                task.setUserUuid(this.resultSet.getString("user_uuid"));
                tasks.add(task);
            }
        } catch (SQLException error) {
            this.connection.rollback();
        } finally {
            return tasks;
        }
    }

    public TaskModel findByUuid(String uuid) {
        TaskModel taskModel = null;
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT * FROM Tasks WHERE uuid = ?");
            PGobject uuidObject = new PGobject();
            uuidObject.setType("uuid");
            uuidObject.setValue(uuid);
            this.preparedStatement.setObject(1, uuidObject);
            this.resultSet = this.preparedStatement.executeQuery();

            if (this.resultSet.next()) {
                taskModel = new TaskModel();
                taskModel.setUuid(this.resultSet.getString("uuid"));
                taskModel.setTitle(this.resultSet.getString("title"));
                taskModel.setDescription(this.resultSet.getString("description"));
                taskModel.setCreatedAt(this.resultSet.getTimestamp("created_at").toLocalDateTime());
                taskModel.setUpdatedAt(this.resultSet.getTimestamp("updated_at").toLocalDateTime());
                taskModel.setIsDone(this.resultSet.getBoolean("is_done"));
                taskModel.setRepublicUuid(this.resultSet.getString("republic_uuid"));
                taskModel.setUserUuid(this.resultSet.getString("user_uuid"));
            }
        } catch (SQLException error) {
            this.connection.rollback();
        } finally {
            return taskModel;
        }
    }

    public boolean create(TaskModel taskModel) {
        try {
            this.preparedStatement = this.connection.prepareStatement("INSERT INTO Tasks (title, description, republic_uuid, user_uuid, expires_at) VALUES (?, ?, ?, ?, ?)");

            PGobject republicUuidObject = new PGobject();
            republicUuidObject.setType("uuid");
            republicUuidObject.setValue(taskModel.getRepublicUuid().toString());

            PGobject userUuidObject = new PGobject();
            userUuidObject.setType("uuid");
            userUuidObject.setValue(taskModel.getUserUuid().toString());

            this.preparedStatement.setString(1, taskModel.getTitle());
            this.preparedStatement.setString(2, taskModel.getDescription());
            this.preparedStatement.setObject(3, republicUuidObject);
            this.preparedStatement.setObject(4, userUuidObject);
            this.preparedStatement.setTimestamp(5, Timestamp.valueOf(taskModel.getExpiresAt()));
            this.preparedStatement.executeUpdate();
            this.connection.commit();
        } catch (SQLException error) {
            System.out.println(error.getMessage());
            this.connection.rollback();
            return false;
        } finally {
            return true;
        }
    }

}
