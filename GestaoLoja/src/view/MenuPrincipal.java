package view;

import controller.ConnectionFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import view.FuncionarioView;
import view.ProdutoView;

public class MenuPrincipal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuCadastros;
    private JMenuItem jMenuItemProdutos;
    private JMenuItem jMenuItemFuncionarios;

    private Connection connection;

    public MenuPrincipal(Connection connection) {
        this.connection = connection;
        initComponents();
    }

    private void initComponents() {
        menuBar = new JMenuBar();
        menuCadastros = new JMenu("Cadastros");
        jMenuItemProdutos = new JMenuItem("Produtos");
        jMenuItemFuncionarios = new JMenuItem("Funcionários");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        jMenuItemProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    ProdutoView produtoView = new ProdutoView();
                    produtoView.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        jMenuItemFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    FuncionarioView funcionarioView = new FuncionarioView();
                    funcionarioView.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });


        menuCadastros.add(jMenuItemProdutos);
        menuCadastros.add(jMenuItemFuncionarios);

        menuBar.add(menuCadastros);

        setJMenuBar(menuBar);

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
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
