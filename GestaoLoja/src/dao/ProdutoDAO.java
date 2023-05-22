package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.Conexao;
import model.Produto;
import controller.ConnectionFactory;
public class ProdutoDAO {
	
	public void salvar(Produto produto) {
		String sql = "insert into produto(nome,quantidade,preco)values(?,?,?)";
		
		Connection con = null;
		PreparedStatement pst = null;

	        try {
	        	//Criar uma conexão com o banco de dados
	        	con = ConnectionFactory.getConnection();
	        	
	        	//Cria uma pst para executar uma query
	        	pst = con.prepareStatement(sql);
	        	
	        	//Adiciona os valores que são esperados pela query
				pst.setString(1, produto.getNome());
				pst.setString(2, produto.getDesc());
				pst.setInt(3, produto.getQtd());
				//pst.setDouble(4, produto.getPreco());
				
				//Executa a query
				pst.executeUpdate();
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }finally {
	        	
	        	//Fecha as conexões
	        	try {
	        		if(pst!=null) {
	        			pst.close();
	        		}
	        		
	        		if (con!=null) {
	        			con.close();
	        		}
	        	}catch (Exception e) {
	        		
	        	}
	        }
	}
}
