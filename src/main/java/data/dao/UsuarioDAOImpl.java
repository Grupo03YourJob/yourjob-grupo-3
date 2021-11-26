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

	public Usuario inserirUsuario(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement insert = null;
		ResultSet resultado = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO usuario (nome_usuario, sobrenome_usuario, senha_usuario, genero_usuario) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			insert.setString(1, usuario.getNome());
			insert.setString(2, usuario.getSobrenome());
			insert.setString(3, usuario.getGenero().name());
			insert.setString(4, usuario.getSenha());

			insert.execute();

			resultado = insert.getGeneratedKeys();

			int id = 0;

			if (resultado.next()) {

				id = resultado.getInt(1);

				usuario.setId(id);
			}

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
		return usuario;
	}

	public void deletarUsuario(Usuario usuario) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");

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
			update = conexao.prepareStatement("UPDATE usuario SET nome_usuario = ? WHERE id_usuario = ?");

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
			update = conexao.prepareStatement("UPDATE usuario SET sobrenome_usuario = ? WHERE id_usuario = ?");

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
			update = conexao.prepareStatement("UPDATE usuario SET senha_usuario = ? WHERE id_usuario = ?");

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
			update = conexao.prepareStatement("UPDATE usuario SET senha_usuario = ? WHERE id_usuario = ?");

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

	public long recuperarLoginUsuario(String email, String senha) {

		Connection conexao = null;
		PreparedStatement select = null;
		ResultSet resultado = null;

		try {

			conexao = conectarBanco();
			select = conexao.prepareStatement(
					"SELECT usuario.id_usuario FROM usuario INNER JOIN contato ON usuario.fk_contato = contato.id_contato WHERE contato.email_contato = ? AND usuario.senha_usuario = ?");

			select.setString(1, email);
			select.setString(2, senha);

			resultado = select.executeQuery();

			int id = 0;

			if (resultado.next())
				id = resultado.getInt(1);

			return id;

		} catch (SQLException erro) {
			erro.printStackTrace();
		}

		finally {

			try {

				if (select != null)
					select.close();

				if (conexao != null)
					conexao.close();

			} catch (SQLException erro) {

				erro.printStackTrace();
			}
		}
		return 0;
	}

	public List<Usuario> recuperarUsuarios() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("nome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY nome_usuario ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY nome_usuario DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosSobrenomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY sobrenome_usuario ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosSobrenomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY sobrenome_usuario DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosSenhaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY senha_usuario ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosSenhaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY senha_usuario DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosGeneroAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY genero_usuario ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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

	public List<Usuario> recuperarUsuariosOrdenadosGeneroDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM usuario ORDER BY genero_usuario DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_usuario");
				String nome = resultado.getString("sobrenome_usuario");
				String sobrenome = resultado.getString("sobrenome_usuario");
				String senha = resultado.getString("senha_usuario");
				String genero = resultado.getString("genero_usuario");

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
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");

	}
}