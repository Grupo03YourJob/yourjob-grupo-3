package data.dao;

import java.util.List;

import model.bean.TipoGenero;
import model.bean.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarNomeUsuario(Usuario usuario, String novoNome);

	void atualizarSobrenomeUsuario(Usuario usuario, String novoSobrenome);

	void atualizarSenhaUsuario(Usuario usuario, String novoSenha);

	void atualizarGeneroUsuario(Usuario usuario, TipoGenero novoGenero);

	List<Usuario> recuperarUsuario();

	List<Usuario> recuperarUsuarioOrdenadosNomeAscendente();

	List<Usuario> recuperarUsuarioOrdenadosNomeDescendente();

}
