package yourjob.modelo.dao.candidato;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yourjob.modelo.dao.usuario.UsuarioDAO;
import yourjob.modelo.entidade.candidato.Candidato;
import yourjob.modelo.entidade.usuario.Usuario;

public class CandidatoDAOImpl implements CandidatoDAO {

	private UsuarioDAO usuarioDAO;

	public CandidatoDAOImpl(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public Candidato inserirCandidato(Candidato candidato) {

		Connection conexao = null;
		PreparedStatement insert = null;
		ResultSet resultado = null;

		try {
			Usuario usuario = usuarioDAO.inserirUsuario(candidato);

			java.sql.Date dataNascimentoSql = new java.sql.Date(candidato.getDataNascimento().getTime());

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO candidato (data_nascimento_candidato, fk_usuario) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			insert.setDate(1, dataNascimentoSql);
			insert.setLong(2, usuario.getId());

			insert.execute();

			resultado = insert.getGeneratedKeys();

			int id = 0;

			if (resultado.next()) {

				id = resultado.getInt(1);

				candidato.setId(id);
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

		return candidato;
	}

	public void deletarCandidato(Candidato candidato) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM candidato WHERE id_candidato = ?");

			delete.setLong(1, candidato.getId());

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

	public void atualizarDataNascimentoCandidato(Candidato candidato, Date novoDataNascimento) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE candidato SET data_nascimento_candidato = ? WHERE id_candidato = ?");

			update.setDate(1, novoDataNascimento);
			update.setLong(2, candidato.getId());

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

	public List<Candidato> recuperarCandidatos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidatos = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato");

			while (resultado.next()) {

				long id = resultado.getLong("id_candidato");
				Date dataNascimento = resultado.getDate("data_nascimento_candidato");

				candidatos.add(new Candidato(id, dataNascimento));
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

		return candidatos;
	}

	public List<Candidato> recuperarCandidatosOrdenadosDataNascimentoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidatos = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY data_nascimento_candidato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_candidato");
				Date dataNascimento = resultado.getDate("data_nascimento_candidato");

				candidatos.add(new Candidato(id, dataNascimento));
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

		return candidatos;
	}

	public List<Candidato> recuperarCandidatosOrdenadosDataNascimentoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidatos = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY data_nascimento_candidato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_candidato");
				Date dataNascimento = resultado.getDate("data_nascimento_candidato");

				candidatos.add(new Candidato(id, dataNascimento));
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

		return candidatos;
	}

	public long recuperarCandidatoUsuario(long idUsuario) {

		Connection conexao = null;
		PreparedStatement select = null;
		ResultSet resultado = null;

		try {

			conexao = conectarBanco();
			select = conexao.prepareStatement("SELECT candidato.id_candidato FROM candidato WHERE fk_usuario = ?");

			select.setLong(1, idUsuario);

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

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}