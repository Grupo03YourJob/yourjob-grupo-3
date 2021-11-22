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

public class RecrutadorDAOImpl implements RecrutadorDAO {

	public void inserirRecrutador(Recrutador recrutador) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao
					.prepareStatement("INSERT INTO recrutador (empresa_Recrutador, atuacao_Recrutador) VALUES (?,?)");

			insert.setString(1, recrutador.getEmpresa());
			insert.setString(2, recrutador.getAtuacao());

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
			delete = conexao.prepareStatement("DELETE FROM recrutador WHERE id_Recrutador = ?");

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
			update = conexao.prepareStatement("UPDATE recrutador SET empresa_Recrutador = ? WHERE id_Recrutador = ?");

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
			update = conexao.prepareStatement("UPDATE recrutador SET atuacao_Recrutador = ? WHERE id_Recrutador = ?");

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

	public List<Recrutador> recuperarRecrutador() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador");

			while (resultado.next()) {

				long id = resultado.getLong("id_Recrutador");
				String empresa = resultado.getString("empresa_Recrutador");
				String atuacao = resultado.getString("atuacao_Recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao));
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

	public List<Recrutador> recuperarRecrutadorOrdenadosEmpresaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador ORDER BY empresa_Recrutador ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Recrutador");
				String empresa = resultado.getString("empresa_Recrutador");
				String atuacao = resultado.getString("atuacao_Recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao));
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

	public List<Recrutador> recuperarRecrutadorOrdenadosEmpresaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Recrutador> recrutadores = new ArrayList<Recrutador>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM recrutador ORDER BY empresa_Recrutador DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Recrutador");
				String empresa = resultado.getString("empresa_Recrutador");
				String atuacao = resultado.getString("atuacao_Recrutador");

				recrutadores.add(new Recrutador(id, empresa, atuacao));
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
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=root&password=root");
	}
}