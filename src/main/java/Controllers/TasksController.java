/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.Partials.TasksRepublicPanel;
import Views.RepublicView;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class TasksController {
    private RepublicView republicView;
    private TasksRepublicPanel tasksRepublicPanel;
    
    public TasksController(RepublicView republicView) {
        this.republicView = republicView;
        this.tasksRepublicPanel = new TasksRepublicPanel(this);
        this.tasksRepublicPanel.setVisible(false);
    }
    
    public TasksRepublicPanel getPanel() {
        return this.tasksRepublicPanel;
    }
}
