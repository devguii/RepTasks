/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.Partials.AdministrationPanel;
import Views.RepublicView;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class ManagementController {
    private RepublicView republicView;
    private AdministrationPanel adminPanel;
    
    public ManagementController(RepublicView republicView) {
        this.republicView = republicView;
        this.adminPanel = new AdministrationPanel(this);
        this.adminPanel.setVisible(false);
    }
    
    public AdministrationPanel getPanel() {
        return this.adminPanel;
    }
}
