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
import model.bean.Vaga;


public abstract class RecrutadorDAOimpl implements RecrutadorDAO {

	public void inserirRecrutador(Recrutador recrutador) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO recrutador (novo_recrutador) VALUES (?,?)");

			insert.setString(1, recrutador.getEmpresaRecrutador());
			insert.setString(2, recrutador.getAtuacaoEmpresaRecrutador());

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

			delete.setLong(1, recrutador.getIdRecrutador());

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

	public void atualizarNovoRecrutador(Recrutador recrutador, String novoRecrutador) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE idioma SET nome_recrutador = ? WHERE id_recrutador = ?");

			update.setString(1, novoRecrutador);
			update.setLong(2, recrutador.getIdRecrutador());

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

	public List<Recrutador> recuperarRecrutador() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutador = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma");

			while (resultado.next()) {

				long idRecrutador = resultado.getLong("id_recrutador");
				String empresaRecrutador = resultado.getString("empresa_recrutador");
				String atuacaoEmpresaRecrutador = resultado.getString("atuacaoEmpresa_recrutador");
				List<Vaga> vagas = resultado.setVaga("vagas_recrutador");

				recrutador.add(new Recrutador(idRecrutador, empresaRecrutador, atuacaoEmpresaRecrutador, List));
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

		return recrutador;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}