package teste;

import dao.ProdutoDAO;
import model.Produto;

/**
 *
 * @author tarcio
 */

public class ProdutoTeste {

    public static void main(String[] args) {
        try {
            // Criar objetos Produto
            Produto produto1 = new Produto();
            produto1.setNome("Produto 1");
            produto1.setDesc("Descrição do Produto 1");
            produto1.setQtd(10);
            produto1.setPreco(9.99);

            Produto produto2 = new Produto();
            produto2.setNome("Produto 2");
            produto2.setDesc("Descrição do Produto 2");
            produto2.setQtd(5);
            produto2.setPreco(19.99);

            // Criar instância do ProdutoDAO
            ProdutoDAO produtoDAO = new ProdutoDAO();

            // Criar produtos no banco de dados
            produtoDAO.create(produto1);
            produtoDAO.create(produto2);

            System.out.println("Produtos criados com sucesso!");

            // Listar produtos do banco de dados
            System.out.println("Lista de Produtos:");
            for (Produto produto : produtoDAO.read()) {
                System.out.println("ID: " + produto.getId());
                System.out.println("Nome: " + produto.getNome());
                System.out.println("Descrição: " + produto.getDesc());
                System.out.println("Quantidade: " + produto.getQtd());
                System.out.println("Preço: " + produto.getPreco());
                System.out.println("--------------------");
            }

            // Atualizar um produto
            Produto produtoAtualizado = produtoDAO.read().get(0);
            produtoAtualizado.setNome("Novo Nome");
            produtoAtualizado.setDesc("Nova Descrição");
            produtoAtualizado.setQtd(20);
            produtoAtualizado.setPreco(29.99);
            
            produtoDAO.update(produtoAtualizado);

            System.out.println("Produto atualizado com sucesso!");

            // Excluir um produto
            Produto produtoExcluir = produtoDAO.read().get(1);
            produtoDAO.delete(produtoExcluir);

            System.out.println("Produto excluído com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}