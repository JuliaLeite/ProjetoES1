package view;

import controller.ConnectionFactory;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class CaixaView extends JFrame {
    private JTable tableVendas;
    private DefaultTableModel tableModel;
    private JButton buttonRegistrarVenda;
    private JLabel labelTotalVendido;

    private List<Venda> vendas;
    private double totalVendido;

    public CaixaView() {
        vendas = new ArrayList<>();
        totalVendido = 0.0;
        initComponents();
    }

    private void initComponents() {
        setTitle("Caixa - Registro de Vendas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Produto", "Preço"}, 0);
        tableVendas = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableVendas);
        add(scrollPane, BorderLayout.CENTER);

        buttonRegistrarVenda = new JButton("Registrar Venda");
        buttonRegistrarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarVenda();
            }
        });
        add(buttonRegistrarVenda, BorderLayout.SOUTH);

        labelTotalVendido = new JLabel("Total Vendido: R$ 0.00");
        add(labelTotalVendido, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void registrarVenda() {
        String produto = JOptionPane.showInputDialog(this, "Informe o nome do produto:");
        if (produto == null || produto.trim().isEmpty()) {
            return;
        }

        String precoStr = JOptionPane.showInputDialog(this, "Informe o preço do produto:");
        if (precoStr == null || precoStr.trim().isEmpty()) {
            return;
        }

        try {
            double preco = Double.parseDouble(precoStr);

            vendas.add(new Venda(produto, preco));
            totalVendido += preco;
            atualizarTabelaVendas();
            atualizarLabelTotalVendido();

            Connection conn = ConnectionFactory.getConnection();
            String sql = "INSERT INTO registro_vendas (produto, preco, data_venda) VALUES (?, ?, NOW())";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto);
            stmt.setDouble(2, preco);
            stmt.executeUpdate();

            stmt.close();
            conn.close();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Informe um valor numérico válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar venda: " + e.getMessage());
        }
    }

    private void atualizarTabelaVendas() {
        tableModel.setRowCount(0);
        for (Venda venda : vendas) {
            Object[] rowData = {venda.getProduto(), venda.getPreco()};
            tableModel.addRow(rowData);
        }
    }

    private void atualizarLabelTotalVendido() {
        labelTotalVendido.setText("Total Vendido: R$ " + String.format("%.2f", totalVendido));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CaixaView caixaView = new CaixaView();
                caixaView.setVisible(true);
            }
        });
    }

    private class Venda {
        private String produto;
        private double preco;

        public Venda(String produto, double preco) {
            this.produto = produto;
            this.preco = preco;
        }

        public String getProduto() {
            return produto;
        }

        public double getPreco() {
            return preco;
        }
    }
}
