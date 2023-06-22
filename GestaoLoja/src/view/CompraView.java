package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import dao.ProdutoDAO;
import model.Produto;

public class CompraView extends JFrame {
    private JTable tableProdutos;
    private DefaultTableModel tableModel;
    private JButton buttonComprar;
    private JLabel labelMensagem;
    private JTextField textFieldBusca;

    private final ProdutoDAO produtoDAO;

    public CompraView() {
        produtoDAO = new ProdutoDAO();
        initComponents();
        carregarProdutos();
    }

    private void initComponents() {
        setTitle("Compra de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"ID", "Nome", "Descrição", "Quantidade", "Preço"}, 0);
        tableProdutos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProdutos);
        add(scrollPane, BorderLayout.CENTER);

        textFieldBusca = new JTextField();
        add(textFieldBusca, BorderLayout.NORTH);

        JButton buttonBuscar = new JButton("Buscar");
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProdutos();
            }
        });
        add(buttonBuscar, BorderLayout.WEST);

        buttonComprar = new JButton("Comprar");
        buttonComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderProduto();
            }
        });
        add(buttonComprar, BorderLayout.SOUTH);

        labelMensagem = new JLabel("");
        add(labelMensagem, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void carregarProdutos() {
        try {
            List<Produto> produtos = produtoDAO.read();
            for (Produto produto : produtos) {
                Object[] rowData = {produto.getId(), produto.getNome(), produto.getDesc(), produto.getQtd(), produto.getPreco()};
                tableModel.addRow(rowData);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }
    }

    private void buscarProdutos() {
        String busca = textFieldBusca.getText();
        if (busca.isEmpty()) {
            carregarProdutos();
        } else {
            try {
                List<Produto> produtos = produtoDAO.readForDesc(busca);
                tableModel.setRowCount(0);
                for (Produto produto : produtos) {
                    Object[] rowData = {produto.getId(), produto.getNome(), produto.getDesc(), produto.getQtd(), produto.getPreco()};
                    tableModel.addRow(rowData);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Erro ao buscar produtos: " + e.getMessage());
            }
        }
    }

    private void venderProduto() {
        int selectedRow = tableProdutos.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto na tabela!");
            return;
        }

        int idProduto = (int) tableProdutos.getValueAt(selectedRow, 0);
        String nomeProduto = (String) tableProdutos.getValueAt(selectedRow, 1);

        try {
            Produto produto = produtoDAO.getProdutoById(idProduto);

            if (produto.getQtd() > 0) {
                // Diminuir a quantidade do estoque
                produto.setQtd(produto.getQtd() - 1);
                produtoDAO.update(produto);

                // Atualizar a tabela
                tableProdutos.setValueAt(produto.getQtd(), selectedRow, 3);

                JOptionPane.showMessageDialog(this, "Produto '" + nomeProduto + "' vendido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Sem estoque do produto '" + nomeProduto + "'!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao vender produto: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CompraView compraView = new CompraView();
                compraView.setVisible(true);
            }
        });
    }
}
