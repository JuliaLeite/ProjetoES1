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
import model.Produto;


/**
 *
 * @author jdelgado
 */
public class ProdutoDAO {

    public void create(Produto p) throws Exception {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("INSERT INTO produtos (nome,descricao,quantidade,preco)VALUES(?,?,?,?)");
            pst.setString(1, p.getNome());
            pst.setString(2, p.getDesc());
            pst.setInt(3, p.getQtd());
            pst.setDouble(4, p.getPreco());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }

    }

    public List<Produto> read() throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * FROM produtos");
            rs = pst.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

	        produto.setId(rs.getInt("id"));
	        produto.setNome(rs.getString("nome"));
	        produto.setDesc(rs.getString("descricao"));
	        produto.setQtd(rs.getInt("quantidade"));
	        produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }

        return produtos;

    }
    public List<Produto> readForDesc(String desc) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            pst = con.prepareStatement("SELECT * FROM produtos WHERE descricao LIKE ?");
            pst.setString(1, "%"+desc+"%");
            
            rs = pst.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
	        produto.setNome(rs.getString("nome"));
	        produto.setDesc(rs.getString("descricao"));
	        produto.setQtd(rs.getInt("quantidade"));
	        produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst, rs);
        }

        return produtos;

    }

    public void update(Produto p) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("UPDATE produtos SET nome = ?, descricao = ? , quantidade = ?, preco = ? WHERE id = ?");

            pst.setString(1, p.getNome());
            pst.setString(2, p.getDesc());
            pst.setInt(3, p.getQtd());
            pst.setDouble(4, p.getPreco());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }

    }
    public void delete(Produto p) throws Exception {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement("DELETE FROM produtos WHERE id = ?");
            pst.setInt(1, p.getId());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, pst);
        }

    }

}
