package data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Candidato;

public class CandidatoDAOImpl implements CandidatoDAO {

	public void inserirCandidato(Candidato candidato) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO candidato (data_Nascimento_Candidato) VALUES (?)");

			insert.setDate(1, candidato.getDataNascimento());

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

	public void deletarCandidato(Candidato candidato) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM candidato WHERE id_Candidato = ?");

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
					.prepareStatement("UPDATE candidato SET data_Nascimento_Candidato = ? WHERE id_Candidato = ?");

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

				long id = resultado.getLong("id_Candidato");
				Date dataNascimento = resultado.getDate("data_Nascimento_Candidato");

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
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY data_Nascimento_Candidato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Candidato");
				Date dataNascimento = resultado.getDate("data_Nascimento_Candidato");

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
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY data_Nascimento_Candidato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Candidato");
				Date dataNascimento = resultado.getDate("data_Nascimento_Candidato");

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

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=rootn&password=root");
	}
}