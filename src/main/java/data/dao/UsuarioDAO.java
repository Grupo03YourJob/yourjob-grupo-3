package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Usuario;

public class UsuarioDAO {

	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public void criarUsuario(Usuario usuario) throws Exception {
		for (Usuario usuarioLista : usuarios) {
			if (usuario.getIdUsuario() == usuarioLista.getIdUsuario()) {
				throw new Exception("User not created!");
			}
		}

		usuarios.add(usuario);
	}

	public Usuario buscarUsuario(long idUsuario) throws Exception {
		for (Usuario usuarioLista : usuarios) {
			if (usuarioLista.getIdUsuario() == idUsuario) {
				return usuarioLista;
			}
		}
		throw new Exception("User not found!");
	}

	public void editarUsuario(Usuario usuarioNovo) throws Exception {
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario usuarioAntigo = usuarios.get(i);
			if (usuarioAntigo.getIdUsuario() == usuarioNovo.getIdUsuario()) {
				usuarios.add(i, usuarioAntigo);
				return;
			}
		}
		throw new Exception("User not updated!");
	}

	public void excluirCandidato(Usuario usuario) {
		usuarios.remove(usuario);
	}

}
