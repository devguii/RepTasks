/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.MyTasksView;

/**
 *
 * @author gabri
 */
public class MyTasksController {
    private RepublicController republicController;
    private MyTasksView tasksView;
    
    public MyTasksController(RepublicController republicController) {
        this.republicController = republicController;
        this.tasksView = new MyTasksView(this);
    }
    
    public void view() {
        this.load();
        this.tasksView.setVisible(true);
    }
    
    public void load() {
        
    }
    
    public void close() {
        this.tasksView.setVisible(false);
    }
    
    public void republicView() {
        this.close();
        this.republicController.view();
    }
    
    public void openProfile() {
        //this.close();
        this.republicController.openProfile();
    }
}
