/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Usuario;
import dao.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jdelgado
 */
public final class AcompanhamentoUsuarioView extends javax.swing.JFrame {

    /**
     * Creates new form ViewJTable
     * @throws java.lang.Exception
     */
    public AcompanhamentoUsuarioView() throws Exception {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
        jTUsuarios.setRowSorter(new TableRowSorter(modelo));

        readJTable();

    }

    public void readJTable() throws Exception {
        
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
        modelo.setNumRows(0);
      UsuarioDAO udao = new UsuarioDAO();

        for (Usuario u : udao.listarUsuarios()) {

            modelo.addRow(new Object[]{
                u.getId(),
                u.getNome(),
                u.getNivelAcesso(),
            });

        }

    }
    public void readJTableForNome(String nome) throws Exception {
        
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
        modelo.setNumRows(0);
      UsuarioDAO udao = new UsuarioDAO();

        for (Usuario u : udao.readForNome(nome)) {

            modelo.addRow(new Object[]{
                u.getId(),
                u.getNome(),
                u.getNivelAcesso(),
            });

        }

    }

    
        public void readJTableForNA(String nivel_acesso) throws Exception {
        
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
        modelo.setNumRows(0);
      UsuarioDAO udao = new UsuarioDAO();

        for (Usuario u : udao.readForNA(nivel_acesso)) {

            modelo.addRow(new Object[]{
                u.getId(),
                u.getNome(),
                u.getNivelAcesso(),
            });

        }

    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTUsuarios = new javax.swing.JTable();
        LabelTitutlo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "NivelAcesso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUsuariosMouseClicked(evt);
            }
        });
        jTUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTUsuariosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTUsuarios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 148, 650, 490));

        LabelTitutlo.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        LabelTitutlo.setText("Acompanhamento de Usuários");
        getContentPane().add(LabelTitutlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 630, 10));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 360, -1));

        ButtonBuscar.setText("Buscar");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsuariosMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTUsuariosMouseClicked

    private void jTUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTUsuariosKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jTUsuariosKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        try {
            // TODO add your handling code here:

            readJTableForNome(txtBuscar.getText());
            readJTableForNA(txtBuscar.getText());
        } catch (Exception ex) {
            Logger.getLogger(CadastroFuncionarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                // TODO add your handling code here:
    }//GEN-LAST:event_ButtonBuscarActionPerformed




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new AcompanhamentoUsuarioView().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(AcompanhamentoUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JLabel LabelTitutlo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTUsuarios;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
