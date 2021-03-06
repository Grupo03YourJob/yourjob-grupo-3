package data.dao;

import model.bean.TipoGenero;
import model.bean.Usuario;

public interface UsuarioDAO {

	Usuario inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarNomeUsuario(Usuario usuario, String novoNome);

	void atualizarSobrenomeUsuario(Usuario usuario, String novoSobrenome);

	void atualizarSenhaUsuario(Usuario usuario, String novoSenha);

	void atualizarGeneroUsuario(Usuario usuario, TipoGenero novoGenero);

	long recuperarLoginUsuario(String email, String senha);
}