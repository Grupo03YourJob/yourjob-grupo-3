package data.dao;

import java.util.List;
import model.bean.Usuario;

public interface UsuarioDAO {

	void inserirUsuario(Usuario usuario);

	void deletarUsuario(Usuario usuario);

	void atualizarNovoUsuario(Usuario usuario, String novoUsuario);

	public List<Usuario> recuperarUsuario();

	public List<Usuario> recuperarUsuarioOrdenadosNomeAscendente();

	public List<Usuario> recuperarUsuarioOrdenadosNomeDescendente();

}
