package dao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

import controller.ConnectionFactory;





public class ProdutooDAO {

	 public void create(Produto p) throws Exception {
	        
	        Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement pst = null;

	        try {
	            pst = con.prepareStatement("INSERT INTO produto (nome, descricao, quantidade, preco)VALUES(?,?,?,?)");
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

	    public List<Produto> read() {

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
	                produto.setNome(rs.getString("Nome"));
	                produto.setDesc(rs.getString("descricao"));
	                produto.setQtd(rs.getInt("qtd"));
	                produto.setPreco(rs.getDouble("preco"));
	                produtos.add(produto);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } finally {
	            ConnectionFactory.closeConnection(con, pst, rs);
	        }

	        return produtos;

	    }
	    public List<Produto> readForDesc(String desc) {

	        Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        List<Produto> produtos = new ArrayList<>();

	        try {
	            stmt = con.prepareStatement("SELECT * FROM produto WHERE descricao LIKE ?");
	            stmt.setString(1, "%"+desc+"%");
	            
	            rs = stmt.executeQuery();

	            while (rs.next()) {

	                Produto produto = new Produto();

	                produto.setId(rs.getInt("id"));
	                produto.setNome(rs.getString("Nome"));
	                produto.setDesc(rs.getString("descricao"));
	                produto.setQtd(rs.getInt("qtd"));
	                produto.setPreco(rs.getDouble("preco"));
	                produtos.add(produto);
	            }

	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } finally {
	            ConnectionFactory.closeConnection(con, stmt, rs);
	        }

	        return produtos;

	    }

	    public void update(Produto p) throws Exception {

	        Connection con = ConnectionFactory.getConnection();
	        
	        PreparedStatement pst = null;

	        try {
	            pst = con.prepareStatement("UPDATE produto SET nome = ?, descricao = ? ,qtd = ?,preco = ? WHERE id = ?");
	            pst.setString(1, p.getNome());
	            pst.setString(2, p.getDesc());
	            pst.setInt(3, p.getQtd());
	            pst.setDouble(4, p.getPreco());
	            pst.setInt(5, p.getId());

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
	            pst = con.prepareStatement("DELETE FROM produto WHERE id = ?");
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
