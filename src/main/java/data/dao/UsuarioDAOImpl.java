package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.TipoGenero;
import model.bean.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	public void inserirUsuario(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO usuario (nome_Usuario, sobrenome_Usuario, senha_Usuario, genero_Usuario) VALUES (?,?,?,?)");

			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getSobrenome());
			insert.setString(3, usuario.getGenero().name());
			insert.setString(4, usuario.getSenha());

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
			delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_Usuario = ?");

			delete.setLong(1, usuario.getId());

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

	public void atualizarNomeUsuario(Usuario usuario, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE usuario SET nome_Usuario = ? WHERE id_Usuario = ?");

			update.setString(1, novoNome);
			update.setLong(2, usuario.getId());

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

	public void atualizarSobrenomeUsuario(Usuario usuario, String novoSobrenome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE usuario SET sobrenome_Usuario = ? WHERE id_Usuario = ?");

			update.setString(1, novoSobrenome);
			update.setLong(2, usuario.getId());

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

	public void atualizarSenhaUsuario(Usuario usuario, String novoSenha) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE usuario SET senha_Usuario = ? WHERE id_Usuario = ?");

			update.setString(1, novoSenha);
			update.setLong(2, usuario.getId());

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

	public void atualizarGeneroUsuario(Usuario usuario, TipoGenero novoGenero) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE usuario SET senha_Usuario = ? WHERE id_Usuario = ?");

			update.setString(1, novoGenero.name());
			update.setLong(2, usuario.getId());

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

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario");

			while (resultado.next()) {

				long id = resultado.getLong("id_Usuario");
				String nome = resultado.getString("sobrenome_Usuario");
				String sobrenome = resultado.getString("sobrenome_Usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_Usuario");

				usuarios.add(new Usuario(id, nome, sobrenome, senha, TipoGenero.valueOf(genero)));
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

		return usuarios;
	}

	public List<Usuario> recuperarUsuarioOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY nome_Usuario ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Usuario");
				String nome = resultado.getString("nome_Usuario");
				String sobrenome = resultado.getString("sobrenome_Usuario");
				String senha = resultado.getString("senha_Usuario");
				String genero = resultado.getString("genero_Usuario");

				usuarios.add(new Usuario(id, nome, sobrenome, senha, TipoGenero.valueOf(genero)));
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

		return usuarios;
	}

	public List<Usuario> recuperarUsuarioOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY nome_usuario DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Usuario");
				String nome = resultado.getString("nome_Usuario");
				String sobrenome = resultado.getString("sobrenome_Usuario");
				String senha = resultado.getString("senha_Usuario");
				String genero = resultado.getString("genero_Usuario");

				usuarios.add(new Usuario(id, nome, sobrenome, senha, TipoGenero.valueOf(genero)));
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

		return usuarios;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=root&password=root");
	}
}