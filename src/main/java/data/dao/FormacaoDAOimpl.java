package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.Formacao;

public class FormacaoDAOimpl implements FormacaoDAO {

	public void inserirFormacao(Formacao formacao) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO formacao (nova_formacao) VALUES (?,?,?,?)");

			insert.setString(1, formacao.getNomeFormacao());
			insert.setString(2, formacao.getInstituicaoFormacao());
			insert.setString(3, formacao.getDataInicialFormacao());
			insert.setString(4, formacao.getDataFinalFormacao());

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

			delete.setLong(1, formacao.getIdFormacao());

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

	public void atualizarNovaFormacao(Formacao formacao, String novaFormacao) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE formacao SET nome_cliente = ? WHERE id_cliente = ?");

			update.setString(1, novaFormacao);
			update.setLong(2, formacao.getIdFormacao());

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

		List<Formacao> formacao = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao");

			while (resultado.next()) {

				String nomeFormacao = resultado.getString("nome_formacao");
				String instituicaoFormacao = resultado.getString("instituicao_formacao");
				String dataInicialFormacao = resultado.getString("dataInicial_formacao");
				String dataFinalFormacao = resultado.getString("dataFinal_formacao");

				formacao.add(new Formacao(nomeFormacao, instituicaoFormacao, dataInicialFormacao, dataFinalFormacao));
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

		return formacao;
	}

	public List<Formacao> recuperarFormacaoOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacao = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY nome_formacao ASC");

			while (resultado.next()) {

				String nomeFormacao = resultado.getString("nome_formacao");
				String instituicaoFormacao = resultado.getString("instituicao_formacao");
				String dataInicialFormacao = resultado.getString("dataInicial_formacao");
				String dataFinalFormacao = resultado.getString("dataFinal_formacao");

				formacao.add(new Formacao(nomeFormacao, instituicaoFormacao, dataInicialFormacao, dataFinalFormacao));
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

		return formacao;
	}

	public List<Formacao> recuperarFormacaoOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Formacao> formacao = new ArrayList<Formacao>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM formacao ORDER BY nome_formacao DESC");

			while (resultado.next()) {

				String nomeFormacao = resultado.getString("nome_formacao");
				String instituicaoFormacao = resultado.getString("instituicao_formacao");
				String dataInicialFormacao = resultado.getString("dataInicial_formacao");
				String dataFinalFormacao = resultado.getString("dataFinal_formacao");

				formacao.add(new Formacao(nomeFormacao, instituicaoFormacao, dataInicialFormacao, dataFinalFormacao));
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

		return formacao;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
