/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import util.Conexao;

/**
 *
 * @author Gustavo
 */
public class SistemaBandas extends javax.swing.JFrame {

    private FormBanda formBanda;
    private static Connection conexao;

    /**
     * Creates new form SistemaBandas
     */
    public SistemaBandas() {
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        Cadastros = new javax.swing.JMenu();
        mnBanda = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        exitMenuItem = new javax.swing.JMenuItem();
        mnAjuda = new javax.swing.JMenu();
        mnSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Cadastros.setText("Cadastros");

        mnBanda.setText("Banda");
        mnBanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBandaActionPerformed(evt);
            }
        });
        Cadastros.add(mnBanda);
        Cadastros.add(jSeparator2);
        Cadastros.add(jSeparator1);

        exitMenuItem.setText("Sair");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        Cadastros.add(exitMenuItem);

        menuBar.add(Cadastros);

        mnAjuda.setText("Ajuda");
        mnAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAjudaActionPerformed(evt);
            }
        });

        mnSobre.setText("Sobre");
        mnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSobreActionPerformed(evt);
            }
        });
        mnAjuda.add(mnSobre);

        menuBar.add(mnAjuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void mnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSobreActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Trabalho Marketing Digital", "Protótipo Cadastros Swing", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_mnSobreActionPerformed

    private void mnAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAjudaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnAjudaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


        try {
            SistemaBandas.conexao = Conexao.get();
            FormLogin dialog = new FormLogin(this, true);
            dialog.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(this.desktopPane, String.format("Erro ao conectar ao SGBD: %s", ex.getMessage()), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SistemaBandas.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showInternalMessageDialog(this.desktopPane, "Erro ao carregar o Drive do SGBD", "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SistemaBandas.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(2);
        }



    }//GEN-LAST:event_formWindowOpened

    private void mnBandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBandaActionPerformed

        if (this.formBanda == null) {
            this.formBanda = new FormBanda(this);
            this.desktopPane.add(this.formBanda);
        }
        this.openJanela(this.formBanda);


    }//GEN-LAST:event_mnBandaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaBandas().setVisible(true);
            }
        });
    }

    public static Connection getConexao() {
        return conexao;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Cadastros;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenuItem mnBanda;
    private javax.swing.JMenuItem mnSobre;
    // End of variables declaration//GEN-END:variables

    private void openJanela(JComponent obj) {
        if (!obj.isVisible()) {
            if (!obj.isValid()) {
                desktopPane.add(obj);
            }

            obj.setVisible(true);
        }
    }
}