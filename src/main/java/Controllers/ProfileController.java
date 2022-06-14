/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Views.Partials.MyProfilePanel;
import Views.RepublicView;

/**
 *
 * @author Gabriel Barbosa Silva 2211114
 */
public class ProfileController {
    private RepublicView republicView;
    private MyProfilePanel myProfilePanel;
    
    public ProfileController(RepublicView republicView) {
        this.republicView = republicView;
        this.myProfilePanel = new MyProfilePanel(this);
        this.myProfilePanel.setVisible(false);
    }
    
    public MyProfilePanel getPanel() {
        return this.myProfilePanel;
    }
}
