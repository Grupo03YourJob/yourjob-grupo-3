package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.Usuario;

public class UsuarioDAOimpl implements UsuarioDAO {

	public void inserirUsuario(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO usuario (novo_usuario) VALUES (?,?,?,?)");

			insert.setString(1, usuario.getNomeUsuario());
			insert.setString(2, usuario.getSobrenomeUsuario());
			insert.setString(3, usuario.getEmailUsuario());
			insert.setString(4, usuario.getSenhaUsuario());

			insert.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (insert != null)
					insert.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void deletarUsuario(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");

			delete.setLong(1, usuario.getIdUsuario());

			delete.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (delete != null)
					delete.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public void atualizarNovoUsuario(Usuario usuario, String novoUsuario) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE idioma SET nome_usuario = ? WHERE id_usuario = ?");

			update.setString(1, novoUsuario);
			update.setLong(2, usuario.getIdUsuario());

			update.execute();

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (update != null)
					update.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
	}

	public List<Usuario> recuperarUsuario() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuario = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario");

			while (resultado.next()) {

				long idUsuario = resultado.getLong("id_usuario");
				String nomeUsuario = resultado.getString("nome_usuario");
				String sobrenomeUsuario = resultado.getString("sobrenome_usuario");
				String emailUsuario = resultado.getString("email_usuario");
				String senhaUsuario = resultado.getString("senha_usuario");

				usuario.add(new Usuario(idUsuario, nomeUsuario, sobrenomeUsuario, emailUsuario, senhaUsuario));
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return usuario;
	}

	public List<Usuario> recuperarUsuarioOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuario = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY nome_usuario ASC");

			while (resultado.next()) {

				long idUsuario = resultado.getLong("id_usuario");
				String nomeUsuario = resultado.getString("nome_usuario");
				String sobrenomeUsuario = resultado.getString("sobrenome_usuario");
				String emailUsuario = resultado.getString("email_usuario");
				String senhaUsuario = resultado.getString("senha_usuario");

				usuario.add(new Usuario(idUsuario, nomeUsuario, sobrenomeUsuario, emailUsuario, senhaUsuario));
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return usuario;
	}

	public List<Usuario> recuperarUsuarioOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuario = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY nome_usuario DESC");

			while (resultado.next()) {

				long idUsuario = resultado.getLong("id_usuario");
				String nomeUsuario = resultado.getString("nome_usuario");
				String sobrenomeUsuario = resultado.getString("sobrenome_usuario");
				String emailUsuario = resultado.getString("email_usuario");
				String senhaUsuario = resultado.getString("senha_usuario");

				usuario.add(new Usuario(idUsuario, nomeUsuario, sobrenomeUsuario, emailUsuario, senhaUsuario));
			}

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (resultado != null)
					resultado.close();

				if (consulta != null)
					consulta.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}

		return usuario;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}