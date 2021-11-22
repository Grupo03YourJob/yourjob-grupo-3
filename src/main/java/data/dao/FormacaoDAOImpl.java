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
					"INSERT INTO formacao (nome_Formacao, instituicao_Formacao, dataInicial, dataFinal) VALUES (?,?,?,?)");

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
			delete = conexao.prepareStatement("DELETE FROM formacao WHERE id_Formacao = ?");

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
			update = conexao.prepareStatement("UPDATE formacao SET nome_Formacao = ? WHERE id_Formacao = ?");

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
			update = conexao.prepareStatement("UPDATE formacao SET instituicao_Formacao = ? WHERE id_Formacao = ?");

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
			update = conexao.prepareStatement("UPDATE formacao SET dataIncial_Formacao = ? WHERE id_Formacao = ?");

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
			update = conexao.prepareStatement("UPDATE formacao SET dataIncial_Formacao = ? WHERE id_Formacao = ?");

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

	public List<Formacao> recuperarFormacao() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao");

			while (resultado.next()) {

				long id = resultado.getLong("id_Formacao");
				String nome = resultado.getString("nome_Formacao");
				String instituicao = resultado.getString("instituicao_Formacao");
				Date dataInicial = resultado.getDate("dataInicial_Formacao");
				Date dataFinal = resultado.getDate("dataFinal_Formacao");

				formacoes.add(new Formacao(nome, instituicao, dataInicial, dataFinal));
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

	public List<Formacao> recuperarFormacaoPorCurriculo(String idCurriculo) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao WHERE id_Curriculo = " + idCurriculo);

			while (resultado.next()) {

				long id = resultado.getLong("id_Formacao");
				String nome = resultado.getString("nome_Formacao");
				String instituicao = resultado.getString("instituicao_Formacao");
				Date dataInicial = resultado.getDate("dataInicial_Formacao");
				Date dataFinal = resultado.getDate("dataFinal_Formacao");

				formacoes.add(new Formacao(nome, instituicao, dataInicial, dataFinal));
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

	public List<Formacao> recuperarFormacaoOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY nome_formacao ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Formacao");
				String nome = resultado.getString("nome_Formacao");
				String instituicao = resultado.getString("instituicao_Formacao");
				Date dataInicial = resultado.getDate("dataInicial_Formacao");
				Date dataFinal = resultado.getDate("dataFinal_Formacao");

				formacoes.add(new Formacao(nome, instituicao, dataInicial, dataFinal));
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

	public List<Formacao> recuperarFormacaoOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacoes = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY nome_formacao DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Formacao");
				String nome = resultado.getString("nome_Formacao");
				String instituicao = resultado.getString("instituicao_Formacao");
				Date dataInicial = resultado.getDate("dataInicial_Formacao");
				Date dataFinal = resultado.getDate("dataFinal_Formacao");

				formacoes.add(new Formacao(nome, instituicao, dataInicial, dataFinal));
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
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=root&password=root");
	}
}
