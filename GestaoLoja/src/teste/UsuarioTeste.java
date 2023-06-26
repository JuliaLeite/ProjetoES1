package teste;

import dao.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author jdelgado
 */

public class UsuarioTeste {

    public static void main(String[] args) {
        try {
            // Criar objetos usuario
            Usuario usuario1 = new Usuario();
            usuario1.setNome("MTavares");
            usuario1.setSenha("123413");
            usuario1.setNivelAcesso("user");

            Usuario usuario2 = new Usuario();
            usuario2.setNome("JGaveon");
            usuario2.setSenha("123410");
            usuario2.setNivelAcesso("admin");

            Usuario usuario3 = new Usuario();
            usuario3.setNome("KSilva");
            usuario3.setSenha("123411");
            usuario3.setNivelAcesso("user");

            Usuario usuario4 = new Usuario();
            usuario4.setNome("BMarinoni");
            usuario4.setSenha("12342");
            usuario4.setNivelAcesso("user");


            // Criar instância do usuarioDAO
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            // Criar usuarios no banco de dados
            usuarioDAO.create(usuario1);
            usuarioDAO.create(usuario2);
            usuarioDAO.create(usuario3);
            usuarioDAO.create(usuario4);

            System.out.println("usuarios criados com sucesso!");

            // Listar usuarios do banco de dados
            System.out.println("Lista de usuarios:");
            for (Usuario usuario : usuarioDAO.read()) {
                System.out.println("ID: " + usuario.getId());
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("Senha: " + usuario.getSenha());
                System.out.println("NivelAcesso: " + usuario.getNivelAcesso());
                System.out.println("--------------------");
            }

            // Atualizar um usuario
            Usuario usuarioAtualizado = usuarioDAO.read().get(0);
            usuarioAtualizado.setNome("MTavaresF");
            usuarioAtualizado.setSenha("123456");
            usuarioAtualizado.setNivelAcesso("admin");
            
            usuarioDAO.update(usuarioAtualizado);

            System.out.println("usuario atualizado com sucesso!");

            // Excluir um usuario
            Usuario usuarioExcluir = usuarioDAO.read().get(1);
            usuarioDAO.delete(usuarioExcluir);

            System.out.println("usuario excluído com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}