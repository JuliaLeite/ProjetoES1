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
            produto1.setNome("Bala Jureminha");
            produto1.setDesc("Doce saboroso");
            produto1.setQtd(10);
            produto1.setPreco(0.90);

            Produto produto2 = new Produto();
            produto2.setNome("Pão doce da vovó");
            produto2.setDesc("Delicioso pão caseiro");
            produto2.setQtd(2);
            produto2.setPreco(3.50);

            Produto produto3 = new Produto();
            produto3.setNome("Galinha caipira");
            produto3.setDesc("Carne de frango fresca");
            produto3.setQtd(5);
            produto3.setPreco(29.90);

            Produto produto4 = new Produto();
            produto4.setNome("Café Pássaro Preto");
            produto4.setDesc("Café torrado e moído");
            produto4.setQtd(4);
            produto4.setPreco(12.50);

            Produto produto5 = new Produto();
            produto5.setNome("Salgadinho de Queijo");
            produto5.setDesc("Salgado crocante");
            produto5.setQtd(8);
            produto5.setPreco(3.25);

            Produto produto6 = new Produto();
            produto6.setNome("Cerveja Êta nóis");
            produto6.setDesc("Cerveja artesanal");
            produto6.setQtd(6);
            produto6.setPreco(9.99);

            Produto produto7 = new Produto();
            produto7.setNome("Sorvete de Baunilha");
            produto7.setDesc("Sorvete cremoso");
            produto7.setQtd(1);
            produto7.setPreco(6.99);


            // Criar instância do ProdutoDAO
            ProdutoDAO produtoDAO = new ProdutoDAO();

            // Criar produtos no banco de dados
            produtoDAO.create(produto1);
            produtoDAO.create(produto2);
            produtoDAO.create(produto3);
            produtoDAO.create(produto4);
            produtoDAO.create(produto5);
            produtoDAO.create(produto6);
            produtoDAO.create(produto7);

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
            produtoAtualizado.setNome("Carne Vegana");
            produtoAtualizado.setDesc("Mato");
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