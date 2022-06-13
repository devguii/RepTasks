/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.Partials.AdministrationPanel;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class ManagementController {
    private RepublicController republicController;
    private AdministrationPanel adminPanel;
    
    public ManagementController(RepublicController republicController) {
        this.republicController = republicController;
        this.adminPanel = new AdministrationPanel(this);
    }
}
