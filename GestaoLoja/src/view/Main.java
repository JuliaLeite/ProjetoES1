package view;

import dao.ProdutoDAO;
import model.Produto;

public class Main {
	public static void main(String[] args) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Produto produto = new Produto();
		produto.setNome("Blusa Rosa");
		produto.setDesc("Tamanho M");
		produto.setQtd(3);
		produto.setPreco(33.90);
		
		produtoDAO.salvar(produto);
	}
	
}
