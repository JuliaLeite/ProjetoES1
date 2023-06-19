package view;

import controller.ConnectionFactory;
import dao.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class LoginView extends JFrame {
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;
    private JButton buttonLogin;
    private JButton buttonCadastro;

    public LoginView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelUsuario = new JLabel("Usuário:");
        textFieldUsuario = new JTextField();
        JLabel labelSenha = new JLabel("Senha:");
        passwordFieldSenha = new JPasswordField();
        buttonLogin = new JButton("Login");
        buttonCadastro = new JButton("Cadastrar");

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String usuario = textFieldUsuario.getText();
                String senha = String.valueOf(passwordFieldSenha.getPassword());

                UsuarioDAO usuarioDAO = new UsuarioDAO();

                // Verifica o login do usuário
                String nivelAcesso = usuarioDAO.verificarLogin(usuario, senha);

                if (nivelAcesso != null) {
                    // Redirecionar para o Menu se o usuário for adm
                    if (nivelAcesso.equals("admin")) {
                        Connection connection = ConnectionFactory.getConnection();
                        MenuPrincipal menuPrincipal = new MenuPrincipal(connection);
                        menuPrincipal.setVisible(true);
                        dispose();
                    } else {
                        CompraView compraView = new CompraView();
                        compraView.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginView.this, "Usuário ou senha inválidos!");
                }
            }
        });






        buttonCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CadastroView cadastroView = new CadastroView();
                cadastroView.setVisible(true);
                dispose();
            }
        });

        panel.add(labelUsuario);
        panel.add(textFieldUsuario);
        panel.add(labelSenha);
        panel.add(passwordFieldSenha);
        panel.add(new JLabel());
        panel.add(buttonLogin);
        panel.add(new JLabel());
        panel.add(buttonCadastro);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
            }
        });
    }
}
