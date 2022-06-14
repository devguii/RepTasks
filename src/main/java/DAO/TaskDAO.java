/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.TaskModel;
import java.sql.SQLException;
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
}
