/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Produto;
import dao.ProdutoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jdelgado
 */
public final class CadastroProdutoView extends javax.swing.JFrame {

    /**
     * Creates new form ViewJTable
     * @throws java.lang.Exception
     */
    public CadastroProdutoView() throws Exception {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        jTProdutos.setRowSorter(new TableRowSorter(modelo));

        readJTable();

    }

    public void readJTable() throws Exception {
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto p : pdao.read()) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getDesc(),
                p.getQtd(),
                p.getPreco()
            });

        }

    }
    public void readJTableForDesc(String desc) throws Exception {
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto p : pdao.readForDesc(desc)) {

            modelo.addRow(new Object[]{
                p.getId(),
                p.getNome(),
                p.getDesc(),
                p.getQtd(),
                p.getPreco()
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
        jTProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtQtd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtpnome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        txtBuscaDesc = new javax.swing.JTextField();
        ButtonBuscar = new javax.swing.JButton();
        ButtonCadastrar = new javax.swing.JButton();
        ButtonExcluir = new javax.swing.JButton();
        ButtonATualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "DESCRIÇÃO", "QTD", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jTProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 358, 650, 280));

        jLabel2.setText("Quantidade");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, -1));
        getContentPane().add(txtQtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 215, 25));

        jLabel3.setText("Preço");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, -1));

        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 213, 25));

        jLabel4.setText("Nome");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 120, -1));

        txtpnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpnomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtpnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 213, 25));

        jLabel1.setText("Descrição");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, -1));
        getContentPane().add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 213, 25));

        txtBuscaDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaDescActionPerformed(evt);
            }
        });
        getContentPane().add(txtBuscaDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 327, -1));

        ButtonBuscar.setText("Buscar");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 130, 40));

        ButtonCadastrar.setText("Cadastrar");
        ButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 130, 40));

        ButtonExcluir.setText("Excluir");
        ButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 130, 40));

        ButtonATualizar.setText("Atualizar");
        ButtonATualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonATualizarActionPerformed(evt);
            }
        });
        getContentPane().add(ButtonATualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 130, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel5.setText("Cadastro de Produtos");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 255, 590, 10));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
        // TODO add your handling code here:

        if (jTProdutos.getSelectedRow() != -1) {
            txtpnome.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
            txtDesc.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            txtQtd.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            txtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());

        }

    }//GEN-LAST:event_jTProdutosMouseClicked

    private void jTProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutosKeyReleased
        // TODO add your handling code here:

        if (jTProdutos.getSelectedRow() != -1) {

            txtpnome.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
            txtDesc.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            txtQtd.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            txtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());

        }

    }//GEN-LAST:event_jTProdutosKeyReleased

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        try {
            // TODO add your handling code here:

            readJTableForDesc(txtBuscaDesc.getText());
        } catch (Exception ex) {
            Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void txtpnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpnomeActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void ButtonATualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonATualizarActionPerformed
        // TODO add your handling code here:

        if (jTProdutos.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setNome(txtpnome.getText());
            p.setDesc(txtDesc.getText());
            p.setQtd(Integer.parseInt(txtQtd.getText()));
            p.setPreco(Double.parseDouble(txtPreco.getText()));
            p.setId((int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));
            try {
                dao.update(p);
            } catch (Exception ex) {
                Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtpnome.setText("");
            txtDesc.setText("");
            txtQtd.setText("");
            txtPreco.setText("");

            try {
                readJTable();
            } catch (Exception ex) {
                Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_ButtonATualizarActionPerformed

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirActionPerformed
        // TODO add your handling code here:

        //        System.out.println("Linha selecionada: "+jTProdutos.getSelectedRow());
        if (jTProdutos.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setId((int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));

            try {
                dao.delete(p);
            } catch (Exception ex) {
                Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtpnome.setText("");
            txtDesc.setText("");
            txtQtd.setText("");
            txtPreco.setText("");

            try {
                readJTable();
            } catch (Exception ex) {
                Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }

    }//GEN-LAST:event_ButtonExcluirActionPerformed

    private void ButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCadastrarActionPerformed
        // TODO add your handling code here:

        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        p.setNome(txtpnome.getText());
        p.setDesc(txtDesc.getText());
        p.setQtd(Integer.parseInt(txtQtd.getText()));
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        try {
            dao.create(p);
        } catch (Exception ex) {
            Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }

        txtpnome.setText("");
        txtDesc.setText("");
        txtQtd.setText("");
        txtPreco.setText("");

        try {
            readJTable();

            //        DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
            //        Object[] dados = {txtDesc.getText(), txtQtd.getText(), txtPreco.getText()};
            //        dtmProdutos.addRow(dados);
        } catch (Exception ex) {
            Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonCadastrarActionPerformed

    private void txtBuscaDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaDescActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroProdutoView().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(CadastroProdutoView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonATualizar;
    private javax.swing.JButton ButtonBuscar;
    private javax.swing.JButton ButtonCadastrar;
    private javax.swing.JButton ButtonExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField txtBuscaDesc;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtpnome;
    // End of variables declaration//GEN-END:variables
}
