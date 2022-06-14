/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

/**
 *
 * @author gabri
 */
public class ChooserView extends javax.swing.JFrame {

    /**
     * Creates new form ChooserView
     */
    public ChooserView() {
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
        createRepublicPanel = new javax.swing.JPanel();
        createNameRepublicField = new javax.swing.JTextField();
        createRepublicPasswordField = new javax.swing.JPasswordField();
        createNewRepublicPasswordField = new javax.swing.JPasswordField();
        createRepublicButton = new javax.swing.JButton();
        enterRepublicPanel = new javax.swing.JPanel();
        enterNameRepublicField = new javax.swing.JTextField();
        enterPasswordRepublicField = new javax.swing.JPasswordField();
        enterREpublicButton = new javax.swing.JButton();
        menuPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        myProfileButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        isLoggedInLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        tasksDoneLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        contentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Seja bem vindo ao RepTasks"));

        createRepublicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Criar República"));

        createNameRepublicField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome da República"));

        createRepublicPasswordField.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha"));

        createNewRepublicPasswordField.setBorder(javax.swing.BorderFactory.createTitledBorder("Confirmar Senha"));

        createRepublicButton.setBackground(new java.awt.Color(76, 180, 82));
        createRepublicButton.setForeground(new java.awt.Color(255, 255, 255));
        createRepublicButton.setText("Criar República");

        javax.swing.GroupLayout createRepublicPanelLayout = new javax.swing.GroupLayout(createRepublicPanel);
        createRepublicPanel.setLayout(createRepublicPanelLayout);
        createRepublicPanelLayout.setHorizontalGroup(
            createRepublicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createRepublicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createRepublicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createNameRepublicField)
                    .addComponent(createRepublicPasswordField)
                    .addComponent(createNewRepublicPasswordField)
                    .addGroup(createRepublicPanelLayout.createSequentialGroup()
                        .addComponent(createRepublicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 355, Short.MAX_VALUE)))
                .addContainerGap())
        );
        createRepublicPanelLayout.setVerticalGroup(
            createRepublicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createRepublicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createNameRepublicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createRepublicPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createNewRepublicPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createRepublicButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        enterRepublicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Entrar em República"));

        enterNameRepublicField.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome da República"));

        enterPasswordRepublicField.setBorder(javax.swing.BorderFactory.createTitledBorder("Senha da República"));

        enterREpublicButton.setBackground(new java.awt.Color(76, 180, 82));
        enterREpublicButton.setForeground(new java.awt.Color(255, 255, 255));
        enterREpublicButton.setText("Entrar na República");

        javax.swing.GroupLayout enterRepublicPanelLayout = new javax.swing.GroupLayout(enterRepublicPanel);
        enterRepublicPanel.setLayout(enterRepublicPanelLayout);
        enterRepublicPanelLayout.setHorizontalGroup(
            enterRepublicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterRepublicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enterRepublicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterNameRepublicField)
                    .addComponent(enterPasswordRepublicField)
                    .addGroup(enterRepublicPanelLayout.createSequentialGroup()
                        .addComponent(enterREpublicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        enterRepublicPanelLayout.setVerticalGroup(
            enterRepublicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterRepublicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterNameRepublicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enterPasswordRepublicField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(enterREpublicButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(enterRepublicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createRepublicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createRepublicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enterRepublicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        menuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        logoLabel.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setText("REPTASKS");

        myProfileButton.setText("Meu Perfil");

        logoutButton.setText("Sair");

        isLoggedInLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        isLoggedInLabel.setText("Usuário");

        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("Score: x.xx");

        tasksDoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tasksDoneLabel.setText("Tarefas: [x / x]");

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isLoggedInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(myProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tasksDoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextField createNameRepublicField;
    private javax.swing.JPasswordField createNewRepublicPasswordField;
    private javax.swing.JButton createRepublicButton;
    private javax.swing.JPanel createRepublicPanel;
    private javax.swing.JPasswordField createRepublicPasswordField;
    private javax.swing.JTextField enterNameRepublicField;
    private javax.swing.JPasswordField enterPasswordRepublicField;
    private javax.swing.JButton enterREpublicButton;
    private javax.swing.JPanel enterRepublicPanel;
    private javax.swing.JLabel isLoggedInLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton myProfileButton;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel tasksDoneLabel;
    // End of variables declaration//GEN-END:variables
}
