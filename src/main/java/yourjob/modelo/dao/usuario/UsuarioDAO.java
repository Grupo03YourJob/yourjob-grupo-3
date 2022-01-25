package yourjob.modelo.dao.usuario;

import yourjob.modelo.entidade.usuario.Usuario;
import yourjob.modelo.enumeracao.TipoGenero;

public interface UsuarioDAO {

	Usuario inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarNomeUsuario(Usuario usuario, String novoNome);

	void atualizarSobrenomeUsuario(Usuario usuario, String novoSobrenome);

	void atualizarSenhaUsuario(Usuario usuario, String novoSenha);

	void atualizarGeneroUsuario(Usuario usuario, TipoGenero novoGenero);

	long recuperarLoginUsuario(String email, String senha);

}