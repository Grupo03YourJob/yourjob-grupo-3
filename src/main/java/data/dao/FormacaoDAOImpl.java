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

import model.bean.Formacao;

public class FormacaoDAOImpl implements FormacaoDAO {

	public void inserirFormacao(Formacao formacao) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO experiencia (id_formacao, nome_formacao, instituicao_formacao, data_inicial_formacao, data_final_formacao) VALUES (0,?,?,?,?)");

			insert.setString(1, formacao.getNome());
			insert.setString(2, formacao.getInstituicao());
			insert.setDate(3, formacao.getDataInicial());
			insert.setDate(4, formacao.getDataFinal());

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

	public void deletarFormacao(Formacao formacao) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM formacao WHERE id_formacao = ?");

			delete.setLong(1, formacao.getId());

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

	public void atualizarNomeFormacao(Formacao formacao, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE formacao SET nome_formacao = ? WHERE id_formacao = ?");

			update.setString(1, novoNome);
			update.setLong(2, formacao.getId());

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

	public void atualizarInstituicaoFormacao(Formacao formacao, String novoInstituicao) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE formacao SET instituicao_formacao = ? WHERE id_formacao = ?");

			update.setString(1, novoInstituicao);
			update.setLong(2, formacao.getId());

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

	public void atualizarDataInicialFormacao(Formacao formacao, Date novoDataInicial) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE formacao SET data_Inicial_formacao = ? WHERE id_formacao = ?");

			update.setDate(1, novoDataInicial);
			update.setLong(2, formacao.getId());

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

	public void atualizarDataFinalFormacao(Formacao formacao, Date novoDataFinal) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE formacao SET data_final_formacao = ? WHERE id_formacao = ?");

			update.setDate(1, novoDataFinal);
			update.setLong(2, formacao.getId());

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

	public List<Formacao> recuperarFormacoes() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY nome_formacao ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY nome_formacao DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosInstituicaoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY instituicao_formacao ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosInstituicaoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY instituicao_formacao DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosDataInicialAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY data_inicial_formacao ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosDataInicialDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY data_inicial_formacao DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosDataFinalAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY data_final_formacao ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	public List<Formacao> recuperarFormacoesOrdenadosDataFinalDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY data_final_formacao DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_formacao");
				String nome = resultado.getString("nome_formacao");
				String instituicao = resultado.getString("instituicao_formacao");
				Date dataInicial = resultado.getDate("data_inicial_formacao");
				Date dataFinal = resultado.getDate("data_final_formacao");

				formacoes.add(new Formacao(id, nome, instituicao, dataInicial, dataFinal));
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

		return formacoes;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}