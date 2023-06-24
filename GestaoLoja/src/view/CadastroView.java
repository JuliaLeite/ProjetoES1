package view;

import dao.UsuarioDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Usuario;

public class CadastroView extends JFrame {
    private JTextField textFieldUsuario;
    private JPasswordField passwordFieldSenha;
    private JButton buttonCadastrar;

    public CadastroView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelUsuario = new JLabel("Usuário:");
        textFieldUsuario = new JTextField();
        JLabel labelSenha = new JLabel("Senha:");
        passwordFieldSenha = new JPasswordField();
        buttonCadastrar = new JButton("Cadastrar");

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String usuario = textFieldUsuario.getText();
                String senha = String.valueOf(passwordFieldSenha.getPassword());

                // cadastra o usuário
                Usuario novoUsuario = new Usuario(usuario, senha, "usuario");
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.cadastrarUsuario(novoUsuario);

                JOptionPane.showMessageDialog(CadastroView.this, "Cadastro realizado com sucesso!");
                LoginView loginView = new LoginView();
                loginView.setVisible(true);
                dispose();
            }
        });



        panel.add(labelUsuario);
        panel.add(textFieldUsuario);
        panel.add(labelSenha);
        panel.add(passwordFieldSenha);
        panel.add(new JLabel());
        panel.add(buttonCadastrar);

        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CadastroView cadastroView = new CadastroView();
                cadastroView.setVisible(true);
            }
        });
    }
}
