/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.RepublicController;
import Models.FeedbackModel;
import Models.RepublicModel;
import Models.TaskModel;
import Models.UserModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gabri
 */
public class RepublicView extends javax.swing.JFrame {
    private RepublicController republicController;
    private UserModel userModel;
    private RepublicModel republicModel;
    private ArrayList<TaskModel> tasksModel;
    private ArrayList<FeedbackModel> feedbacks;
    private ArrayList<UserModel> usersModel;
    
    public void setScore(double score) {
        this.scoreLabel.setText("Score: " + String.valueOf(score));
    }
    
    public void setFeedbacks(ArrayList<FeedbackModel> feedbacks) {
        ArrayList<FeedbackModel> feedback = feedbacks;
    }
    
    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }
    
    public void setRepublic(RepublicModel republicModel) {
        this.republicModel = republicModel;
    }
    
    public void setTasks(ArrayList<TaskModel> tasksModel) {
        this.tasksModel = tasksModel;
    }
    
    public void setUsers(ArrayList<UserModel> usersModel) {
        this.usersModel = usersModel;
    }

    public void load() {
        DefaultTableModel taskTableModel = (DefaultTableModel) this.tasksTable.getModel();
        for (TaskModel taskModel : this.tasksModel) {
            Object[] row = {
                taskModel.getTitle(), taskModel.getUserUuid(), taskModel.getIsDone(), taskModel.getExpiresAt(), taskModel.getUuid().toString(),
            };
            taskTableModel.addRow(row);
        }
        
        DefaultTableModel userTableModel = (DefaultTableModel) this.usersTable.getModel();
        for (UserModel userModel : this.usersModel) {
            String cargo = "Usuário";
            
            if (userModel.getUuid().equals(this.republicModel.getUserUuid())) {
                cargo = "Administrador";
            }
            
            Object[] row = {
                userModel.getName(), cargo, userModel.getUuid().toString(),
            };
            userTableModel.addRow(row);
        }
    }
    
    public void setNotAdministrator() {
        this.addTaskButton.setVisible(false);
        this.editTaskButton.setVisible(false);
        this.deleteTaskButton.setVisible(false);
        this.removeUserButton.setVisible(false);
        this.deleteRepButton.setVisible(false);
        this.updateRepButton.setVisible(false);
    }
    
    public void setIsLoggedInLabel(String name) {
        this.isLoggedInLabel.setText(name);
    }

    /**
     * Creates new form RepublicView
     */
    public RepublicView(RepublicController republicController) {
        this.republicController = republicController;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        tasksPanel = new javax.swing.JPanel();
        scrollPanel = new javax.swing.JScrollPane();
        tasksTable = new javax.swing.JTable();
        openTaskButton = new javax.swing.JButton();
        searchTaskField = new javax.swing.JTextField();
        searchTaskButton = new javax.swing.JButton();
        editTaskButton = new javax.swing.JButton();
        deleteTaskButton = new javax.swing.JButton();
        addTaskButton = new javax.swing.JButton();
        usersPanel = new javax.swing.JPanel();
        scrollPanel2 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        openUserButton = new javax.swing.JButton();
        searchUserField = new javax.swing.JTextField();
        searchUserButton = new javax.swing.JButton();
        removeUserButton = new javax.swing.JButton();
        updateRepButton = new javax.swing.JButton();
        deleteRepButton = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        myTasksButton = new javax.swing.JButton();
        myProfileButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        isLoggedInLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        tasksDoneLabel = new javax.swing.JLabel();
        republicButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("República"));

        tasksPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tarefas"));

        tasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarefa", "Usuário", "Estado", "Expiração", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tasksTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPanel.setViewportView(tasksTable);
        if (tasksTable.getColumnModel().getColumnCount() > 0) {
            tasksTable.getColumnModel().getColumn(4).setMinWidth(0);
            tasksTable.getColumnModel().getColumn(4).setPreferredWidth(0);
            tasksTable.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        openTaskButton.setBackground(new java.awt.Color(76, 80, 182));
        openTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        openTaskButton.setText("Abrir Tarefa");
        openTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTaskButtonActionPerformed(evt);
            }
        });

        searchTaskField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTaskFieldActionPerformed(evt);
            }
        });

        searchTaskButton.setText("Pesquisar");

        editTaskButton.setBackground(new java.awt.Color(176, 180, 82));
        editTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        editTaskButton.setText("Editar Tarefa");

        deleteTaskButton.setBackground(new java.awt.Color(176, 80, 82));
        deleteTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteTaskButton.setText("Deletar Tarefa");

        addTaskButton.setBackground(new java.awt.Color(76, 180, 82));
        addTaskButton.setForeground(new java.awt.Color(255, 255, 255));
        addTaskButton.setText("Adicionar Tarefa");
        addTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTaskButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tasksPanelLayout = new javax.swing.GroupLayout(tasksPanel);
        tasksPanel.setLayout(tasksPanelLayout);
        tasksPanelLayout.setHorizontalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel)
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addComponent(openTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addTaskButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTaskButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTaskButton))
                    .addGroup(tasksPanelLayout.createSequentialGroup()
                        .addComponent(searchTaskField, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTaskButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tasksPanelLayout.setVerticalGroup(
            tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tasksPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTaskField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTaskButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openTaskButton)
                    .addComponent(editTaskButton)
                    .addComponent(deleteTaskButton)
                    .addComponent(addTaskButton))
                .addContainerGap())
        );

        usersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Usuários"));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Cargo", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPanel2.setViewportView(usersTable);
        if (usersTable.getColumnModel().getColumnCount() > 0) {
            usersTable.getColumnModel().getColumn(2).setMinWidth(0);
            usersTable.getColumnModel().getColumn(2).setPreferredWidth(0);
            usersTable.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        openUserButton.setBackground(new java.awt.Color(76, 80, 182));
        openUserButton.setForeground(new java.awt.Color(255, 255, 255));
        openUserButton.setText("Abrir Usuário");
        openUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openUserButtonActionPerformed(evt);
            }
        });

        searchUserButton.setText("Pesquisar");

        removeUserButton.setBackground(new java.awt.Color(176, 80, 82));
        removeUserButton.setForeground(new java.awt.Color(255, 255, 255));
        removeUserButton.setText("Remover Usuário");

        javax.swing.GroupLayout usersPanelLayout = new javax.swing.GroupLayout(usersPanel);
        usersPanel.setLayout(usersPanelLayout);
        usersPanelLayout.setHorizontalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel2)
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addComponent(searchUserField, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                    .addGroup(usersPanelLayout.createSequentialGroup()
                        .addComponent(openUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeUserButton)))
                .addContainerGap())
        );
        usersPanelLayout.setVerticalGroup(
            usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usersPanelLayout.createSequentialGroup()
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchUserField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(usersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeUserButton))
                .addContainerGap())
        );

        updateRepButton.setBackground(new java.awt.Color(176, 180, 82));
        updateRepButton.setForeground(new java.awt.Color(255, 255, 255));
        updateRepButton.setText("Alterar República");

        deleteRepButton.setBackground(new java.awt.Color(176, 80, 82));
        deleteRepButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteRepButton.setText("Deletar República");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tasksPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usersPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(updateRepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRepButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateRepButton)
                    .addComponent(deleteRepButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tasksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        logoLabel.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("REPTASKS");

        myTasksButton.setText("Minhas Tarefas");

        myProfileButton.setText("Meu Perfil");

        logoutButton.setText("Sair");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        isLoggedInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isLoggedInLabel.setText("Usuário");

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("Score: x.xx");

        tasksDoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tasksDoneLabel.setText("Tarefas: [x / x]");

        republicButton.setText("República");
        republicButton.setEnabled(false);
        republicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                republicButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isLoggedInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(myTasksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tasksDoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(republicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(isLoggedInLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tasksDoneLabel)
                .addGap(24, 24, 24)
                .addComponent(myProfileButton)
                .addGap(18, 18, 18)
                .addComponent(republicButton)
                .addGap(18, 18, 18)
                .addComponent(myTasksButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTaskFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTaskFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTaskFieldActionPerformed

    private void openTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTaskButtonActionPerformed
        int selectedRow = this.tasksTable.getSelectedRow();
        if(selectedRow >= 0) {
            try {
                String uuidTask = (String) this.tasksTable.getValueAt(selectedRow, 4);
                this.republicController.openTaskView(uuidTask);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao selecionar a tarefa!", "Tarefa", JOptionPane.ERROR_MESSAGE);
            }
        }
        //this.republicController.openTask();
    }//GEN-LAST:event_openTaskButtonActionPerformed

    private void openUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openUserButtonActionPerformed
        int selectedRow = this.usersTable.getSelectedRow();
        if(selectedRow >= 0) {
            try {
                String uuidUser = (String) this.usersTable.getValueAt(selectedRow, 2);
                this.republicController.openUserView(uuidUser);
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Houve um erro ao selecionar o usuário!", "Usuário", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_openUserButtonActionPerformed

    private void republicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_republicButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_republicButtonActionPerformed

    private void addTaskButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTaskButtonActionPerformed
        this.republicController.openAddTaskView();
    }//GEN-LAST:event_addTaskButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        this.republicController.logout();
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTaskButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteRepButton;
    private javax.swing.JButton deleteTaskButton;
    private javax.swing.JButton editTaskButton;
    private javax.swing.JLabel isLoggedInLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton myProfileButton;
    private javax.swing.JButton myTasksButton;
    private javax.swing.JButton openTaskButton;
    private javax.swing.JButton openUserButton;
    private javax.swing.JButton removeUserButton;
    private javax.swing.JButton republicButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JScrollPane scrollPanel2;
    private javax.swing.JButton searchTaskButton;
    private javax.swing.JTextField searchTaskField;
    private javax.swing.JButton searchUserButton;
    private javax.swing.JTextField searchUserField;
    private javax.swing.JLabel tasksDoneLabel;
    private javax.swing.JPanel tasksPanel;
    private javax.swing.JTable tasksTable;
    private javax.swing.JButton updateRepButton;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
