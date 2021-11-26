package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Recrutador;
import model.bean.Usuario;

public class RecrutadorDAOImpl implements RecrutadorDAO {

	private UsuarioDAO usuarioDAO;

	public RecrutadorDAOImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public void inserirRecrutador(Recrutador recrutador) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			Usuario usuario = usuarioDAO.inserirUsuario(new Usuario(recrutador.getNome(), recrutador.getSobrenome(),
					recrutador.getSenha(), recrutador.getGenero()));

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO recrutador (empresa_recrutador, autacao_recrutador, fk_usuario) VALUES (?,?,?)");

			insert.setString(1, recrutador.getEmpresa());
			insert.setString(2, recrutador.getAtuacao());
			insert.setLong(3, usuario.getId());

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

	public void deletarRecrutador(Recrutador recrutador) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM recrutador WHERE id_recrutador = ?");

			delete.setLong(1, recrutador.getId());

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

	public void atualizarEmpresaRecrutador(Recrutador recrutador, String novoEmpresa) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE recrutador SET empresa_recrutador = ? WHERE id_recrutador = ?");

			update.setString(1, novoEmpresa);
			update.setLong(2, recrutador.getId());

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

	public void atualizarAtuacaoRecrutador(Recrutador recrutador, String novoAtuacao) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE recrutador SET atuacao_recrutador = ? WHERE id_recrutador = ?");

			update.setString(1, novoAtuacao);
			update.setLong(2, recrutador.getId());

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

	public List<Recrutador> recuperarRecrutadores() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador");

			while (resultado.next()) {

				long id = resultado.getLong("id_recrutador");
				String empresa = resultado.getString("empresa_recrutador");
				String atuacao = resultado.getString("atuacao_recrutador");
				long fkUsuario = resultado.getLong("fk_recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao, fkUsuario));
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

		return recrutadores;
	}

	public List<Recrutador> recuperarRecrutadoresOrdenadosEmpresaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador ORDER BY empresa_recrutador ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_recrutador");
				String empresa = resultado.getString("empresa_recrutador");
				String atuacao = resultado.getString("atuacao_recrutador");
				long fkUsuario = resultado.getLong("fk_recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao, fkUsuario));
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

		return recrutadores;
	}

	public List<Recrutador> recuperarRecrutadoresOrdenadosEmpresaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador ORDER BY empresa_recrutador DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_recrutador");
				String empresa = resultado.getString("empresa_recrutador");
				String atuacao = resultado.getString("atuacao_recrutador");
				long fkUsuario = resultado.getLong("fk_recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao, fkUsuario));
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

		return recrutadores;
	}

	public List<Recrutador> recuperarRecrutadoresOrdenadosAtuacaoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador ORDER BY atuacao_recrutador ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_recrutador");
				String empresa = resultado.getString("empresa_recrutador");
				String atuacao = resultado.getString("atuacao_recrutador");
				long fkUsuario = resultado.getLong("fk_recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao, fkUsuario));
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

		return recrutadores;
	}

	public List<Recrutador> recuperarRecrutadoresOrdenadosAtuacaoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador ORDER BY atuacao_recrutador DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_recrutador");
				String empresa = resultado.getString("empresa_recrutador");
				String atuacao = resultado.getString("atuacao_recrutador");
				long fkUsuario = resultado.getLong("fk_recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao, fkUsuario));
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

		return recrutadores;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");

	}
}