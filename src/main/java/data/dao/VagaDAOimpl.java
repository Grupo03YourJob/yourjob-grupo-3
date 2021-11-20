package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.bean.Vaga;

public abstract class VagaDAOimpl implements VagaDAO {

	public void inserirVaga(Vaga vaga) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO vaga (nova_vaga) VALUES (?,?,?,?,?)");

			insert.setString(1, vaga.getNomeVaga());
			insert.setString(2, vaga.getAtividadeVaga());
			insert.setString(3, vaga.getTurnoVaga());
			insert.setString(4, vaga.getSalarioVaga());
			insert.setString(5, vaga.getRequisitoVaga());

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

	public void deletarVaga(Vaga vaga) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM vaga WHERE id_vaga = ?");

			delete.setLong(1, vaga.getIdVaga());

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

	public void atualizarNovaVaga(Vaga vaga, String novaVaga) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE vaga SET nome_vaga = ? WHERE id_vaga = ?");

			update.setString(1, novaVaga);
			update.setLong(2, vaga.getIdVaga());

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

	public List<Vaga> recuperarVaga() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vaga = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga");

			while (resultado.next()) {

				String nomeVaga = resultado.getString("nome_vaga");
				String atividadeVaga = resultado.getString("atividade_vaga");
				String turnoVaga = resultado.getString("atividade_vaga");
				String salarioVaga = resultado.getString("salario_vaga");
				String requisitoVaga = resultado.getString("requisito_vaga");

				vaga.add(new Vaga(nomeVaga, atividadeVaga, turnoVaga, salarioVaga, requisitoVaga));
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

		return vaga;
	}

	public List<Vaga> recuperarVagaOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vaga = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY nome_vaga ASC");

			while (resultado.next()) {

				String nomeVaga = resultado.getString("nome_vaga");
				String atividadeVaga = resultado.getString("atividade_vaga");
				String turnoVaga = resultado.getString("atividade_vaga");
				String salarioVaga = resultado.getString("salario_vaga");
				String requisitoVaga = resultado.getString("requisito_vaga");

				vaga.add(new Vaga(nomeVaga, atividadeVaga, turnoVaga, salarioVaga, requisitoVaga));

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

		return vaga;
	}

	public List<Vaga> recuperarVagaOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vaga = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY nome_vaga DESC");

			while (resultado.next()) {

				String nomeVaga = resultado.getString("nome_vaga");
				String atividadeVaga = resultado.getString("atividade_vaga");
				String turnoVaga = resultado.getString("atividade_vaga");
				String salarioVaga = resultado.getString("salario_vaga");
				String requisitoVaga = resultado.getString("requisito_vaga");

				vaga.add(new Vaga(nomeVaga, atividadeVaga, turnoVaga, salarioVaga, requisitoVaga));
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

		return vaga;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}

}
