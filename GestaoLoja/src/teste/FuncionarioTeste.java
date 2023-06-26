package teste;

import dao.FuncionarioDAO;
import model.Funcionario;

/**
 *
 * @author jdelgado
 */

public class FuncionarioTeste {

    public static void main(String[] args) {
        try {
            // Criar objetos funcionario
            Funcionario funcionario1 = new Funcionario();
            funcionario1.setNome("Márcia Tavares");
            funcionario1.setCargo("Gerente");
            funcionario1.setSalario(6500.00);

            Funcionario funcionario2 = new Funcionario();
            funcionario2.setNome("João Gaveon");
            funcionario2.setCargo("Operador Junior");
            funcionario2.setSalario(2500.00);

            Funcionario funcionario3 = new Funcionario();
            funcionario3.setNome("Karla Silva");
            funcionario3.setCargo("Operador Senior");
            funcionario3.setSalario(3500.00);

            Funcionario funcionario4 = new Funcionario();
            funcionario4.setNome("Bruno Marinoni");
            funcionario4.setCargo("Operador Pleno");
            funcionario4.setSalario(2700.00);


            // Criar instância do funcionarioDAO
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            // Criar funcionarios no banco de dados
            funcionarioDAO.create(funcionario1);
            funcionarioDAO.create(funcionario2);
            funcionarioDAO.create(funcionario3);
            funcionarioDAO.create(funcionario4);

            System.out.println("funcionarios criados com sucesso!");

            // Listar funcionarios do banco de dados
            System.out.println("Lista de funcionarios:");
            for (Funcionario funcionario : funcionarioDAO.read()) {
                System.out.println("ID: " + funcionario.getId());
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Salario: " + funcionario.getSalario());
                System.out.println("--------------------");
            }

            // Atualizar um funcionario
            Funcionario funcionarioAtualizado = funcionarioDAO.read().get(0);
            funcionarioAtualizado.setNome("Márcia Tavares Formosa");
            funcionarioAtualizado.setCargo("Gerente Senior");
            funcionarioAtualizado.setSalario(8000.00);
            
            funcionarioDAO.update(funcionarioAtualizado);

            System.out.println("funcionario atualizado com sucesso!");

            // Excluir um funcionario
            Funcionario funcionarioExcluir = funcionarioDAO.read().get(1);
            funcionarioDAO.delete(funcionarioExcluir);

            System.out.println("funcionario excluído com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}