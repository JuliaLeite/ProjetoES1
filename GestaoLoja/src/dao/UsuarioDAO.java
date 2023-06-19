package dao;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

public class UsuarioDAO {
    private Connection connection;

    public UsuarioDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrarUsuario(Usuario usuario) {
        PreparedStatement stmt = null;

        try {
            String sql = "INSERT INTO usuarios (nome, senha, nivel_acesso) VALUES (?, ?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNivelAcesso());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    
    public static boolean isUsuarioAdmin(String usuario) {
        boolean isAdmin = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT nivel_acesso FROM usuarios WHERE usuario = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            rs = stmt.executeQuery();

            if (rs.next()) {
                String nivelAcesso = rs.getString("nivel_acesso");
                isAdmin = nivelAcesso.equals("admin");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return isAdmin;
    }


    public String verificarLogin(String usuario, String senha) {
        String nivelAcesso = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT nivel_acesso FROM usuarios WHERE nome = ? AND senha = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nivelAcesso = rs.getString("nivel_acesso");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return nivelAcesso;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM usuarios";
            stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivelAcesso(rs.getString("nivel_acesso"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return usuarios;
    }
}
