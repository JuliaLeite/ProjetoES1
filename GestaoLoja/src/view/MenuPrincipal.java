package view;

import controller.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MenuPrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuCadastros;
    private JMenu menuOperacoes;
    private JMenuItem jMenuItemProdutos;
    private JMenuItem jMenuItemFuncionarios;
    private JMenuItem jMenuItemCaixa;
    private JMenuItem jMenuItemCompra;

    private final Connection connection;

    public MenuPrincipal(Connection connection) {
        this.connection = connection;
        initComponents();
    }

    private void initComponents() {
        menuBar = new JMenuBar();
        menuCadastros = new JMenu("Cadastros");
        menuOperacoes = new JMenu("Operações");
        jMenuItemProdutos = new JMenuItem("Produtos");
        jMenuItemFuncionarios = new JMenuItem("Funcionários");
        jMenuItemCaixa = new JMenuItem("Caixa");
        jMenuItemCompra = new JMenuItem("Compra");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jMenuItemProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    CadastroProdutoView produtoView = new CadastroProdutoView();
                    produtoView.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jMenuItemFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    CadastroFuncionarioView funcionarioView = new CadastroFuncionarioView();
                    funcionarioView.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jMenuItemCaixa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    CaixaView caixaView = new CaixaView();
                    caixaView.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        jMenuItemCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    CompraView compraView = new CompraView();
                    compraView.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        menuCadastros.add(jMenuItemProdutos);
        menuCadastros.add(jMenuItemFuncionarios);
        menuOperacoes.add(jMenuItemCaixa);
        menuOperacoes.add(jMenuItemCompra);

        menuBar.add(menuCadastros);
        menuBar.add(menuOperacoes);

        setJMenuBar(menuBar);

        setSize(600, 400);
        setLocationRelativeTo(null);

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Connection connection = ConnectionFactory.getConnection();

                    MenuPrincipal menuPrincipal = new MenuPrincipal(connection);
                    menuPrincipal.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
