/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JOptionPane;
import model.Funcionario;


/**
 *
 * @author jdelgado
 */
public class FuncionarioDAO {

    public void create(Funcionario f) throws Exception {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("INSERT INTO funcionarios (nome,cargo,salario)VALUES(?,?,?)");
            pst.setString(1, f.getNome());
            pst.setString(2, f.getCargo());
            pst.setDouble(3, f.getSalario());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }

    }

    public List<Funcionario> read() throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * FROM funcionarios");
            rs = pst.executeQuery();

            while (rs.next()) {

                Funcionario Funcionario = new Funcionario();

	        Funcionario.setId(rs.getInt("id"));
	        Funcionario.setNome(rs.getString("nome"));
	        Funcionario.setCargo(rs.getString("cargo"));
	        Funcionario.setSalario(rs.getDouble("salario"));
                funcionarios.add(Funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }

        return funcionarios;

    }
    public List<Funcionario> readForDesc(String desc) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * FROM funcionarios WHERE descricao LIKE ?");
            pst.setString(1, "%"+desc+"%");
            
            rs = pst.executeQuery();

            while (rs.next()) {

                Funcionario Funcionario = new Funcionario();

	        Funcionario.setId(rs.getInt("id"));
	        Funcionario.setNome(rs.getString("nome"));
	        Funcionario.setCargo(rs.getString("cargo"));
	        Funcionario.setSalario(rs.getDouble("salario"));
                funcionarios.add(Funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }

        return funcionarios;

    }

    public void update(Funcionario f) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("UPDATE funcionarios SET nome = ?, cargo = ? , salario = ? WHERE id = ?");

            pst.setString(1, f.getNome());
            pst.setString(2, f.getCargo());
            pst.setDouble(3, f.getSalario());
            pst.setInt(4, f.getId());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }

    }
    public void delete(Funcionario f) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("DELETE FROM funcionarios WHERE id = ?");
            pst.setInt(1, f.getId());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }

    }


}
