/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

/**
 *
 * @author Usuário
 */
public class PrincipalView extends javax.swing.JFrame {

  

    public JMenuItem getBtncadastrar() {
        return btncadastrar;
    }

    public JLabel getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(JLabel labelStatus) {
        this.labelStatus = labelStatus;
    }

    public void setBtncadastrar(JMenuItem btncadastrar) {
        this.btncadastrar = btncadastrar;
    }

    public JMenuItem getBtnlistar() {
        return btnlistar;
    }

    public JMenuItem getBtnconfiglog() {
        return btnconfiglog;
    }

    public void setBtnlistar(JMenuItem btnlistar) {
        this.btnlistar = btnlistar;
    }

    public JDesktopPane getDesktop() {
        return desktop;
    }

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
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

        labelStatus = new javax.swing.JLabel();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenu = new javax.swing.JMenu();
        btncadastrar = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnlistar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnconfiglog = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(0, 0, 153));
        labelStatus.setText("Total de Funcionarios Cadastrados:");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 734, Short.MAX_VALUE)
        );

        JMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        JMenu.setText("Inclusão");

        btncadastrar.setText("Novo");
        JMenu.add(btncadastrar);

        jMenuBar1.add(JMenu);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizar.png"))); // NOI18N
        jMenu1.setText("Gerenciar Funcionario ");

        btnlistar.setText("Listar Funcionarios");
        jMenu1.add(btnlistar);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tools.png"))); // NOI18N
        jMenu2.setText("Configuração do Sistema");

        btnconfiglog.setText("Configurar Log");
        jMenu2.add(btnconfiglog);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1008, Short.MAX_VALUE)
                .addComponent(labelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStatus)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenu;
    private javax.swing.JMenuItem btncadastrar;
    private javax.swing.JMenuItem btnconfiglog;
    private javax.swing.JMenuItem btnlistar;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelStatus;
    // End of variables declaration//GEN-END:variables
}
