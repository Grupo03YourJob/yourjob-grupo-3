package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.TipoTurno;
import model.bean.Vaga;

public class VagaDAOImpl implements VagaDAO {

	public void inserirVaga(Vaga vaga) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO vaga (nome_Vaga, atividade_Vaga, salario_Vaga, requisito_Vaga, turno_Vaga) VALUES (?,?,?,?,?)");

			insert.setString(1, vaga.getNome());
			insert.setString(2, vaga.getAtividade());
			insert.setString(3, vaga.getSalario());
			insert.setString(4, vaga.getRequisito());
			insert.setString(5, vaga.getTurno().name());

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
			delete = conexao.prepareStatement("DELETE FROM vaga WHERE id_Vaga = ?");

			delete.setLong(1, vaga.getId());

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

	public void atualizarNomeVaga(Vaga vaga, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE vaga SET nome_Vaga = ? WHERE id_Vaga = ?");

			update.setString(1, novoNome);
			update.setLong(2, vaga.getId());

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

	public void atualizarAtividadeVaga(Vaga vaga, String novoAtividade) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE vaga SET atividade_Vaga = ? WHERE id_Vaga = ?");

			update.setString(1, novoAtividade);
			update.setLong(2, vaga.getId());

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

	public void atualizarSalarioVaga(Vaga vaga, String novoSalario) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE vaga SET salario_Vaga = ? WHERE id_Vaga = ?");

			update.setString(1, novoSalario);
			update.setLong(2, vaga.getId());

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

	public void atualizarRequisitoVaga(Vaga vaga, String novoRequisito) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE vaga SET requisito_Vaga = ? WHERE id_Vaga = ?");

			update.setString(1, novoRequisito);
			update.setLong(2, vaga.getId());

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

	public void atualizarTurnoVaga(Vaga vaga, TipoTurno novoTurno) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE vaga SET turno_Vaga = ? WHERE id_Vaga = ?");

			update.setString(1, novoTurno.name());
			update.setLong(2, vaga.getId());

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

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga");

			while (resultado.next()) {

				long id = resultado.getLong("Id_Vaga");
				String nome = resultado.getString("nome_Vaga");
				String atividade = resultado.getString("atividade_Vaga");
				String salario = resultado.getString("salario_Vaga");
				String requisito = resultado.getString("requisito_Vaga");
				String turno = resultado.getString("atividade_Vaga");

				vagas.add(new Vaga(id, nome, atividade, salario, requisito, TipoTurno.valueOf(turno)));
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

		return vagas;
	}

	public List<Vaga> recuperarVagaPorRecrutador(String idRecrutador) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga WHERE id_Recrutador = " + idRecrutador);

			while (resultado.next()) {

				long id = resultado.getLong("Id_Vaga");
				String nome = resultado.getString("nome_Vaga");
				String atividade = resultado.getString("atividade_Vaga");
				String salario = resultado.getString("salario_Vaga");
				String requisito = resultado.getString("requisito_Vaga");
				String turno = resultado.getString("atividade_Vaga");

				vagas.add(new Vaga(id, nome, atividade, salario, requisito, TipoTurno.valueOf(turno)));
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

		return vagas;
	}

	public List<Vaga> recuperarVagaPorCandidato(String idCandidato) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga WHERE id_Candidato = " + idCandidato);

			while (resultado.next()) {

				long id = resultado.getLong("Id_Vaga");
				String nome = resultado.getString("nome_Vaga");
				String atividade = resultado.getString("atividade_Vaga");
				String salario = resultado.getString("salario_Vaga");
				String requisito = resultado.getString("requisito_Vaga");
				String turno = resultado.getString("atividade_Vaga");

				vagas.add(new Vaga(id, nome, atividade, salario, requisito, TipoTurno.valueOf(turno)));
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

		return vagas;
	}

	public List<Vaga> recuperarVagaOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY nome_Vaga ASC");

			while (resultado.next()) {

				long id = resultado.getLong("Id_Vaga");
				String nome = resultado.getString("nome_Vaga");
				String atividade = resultado.getString("atividade_Vaga");
				String salario = resultado.getString("salario_Vaga");
				String requisito = resultado.getString("requisito_Vaga");
				String turno = resultado.getString("atividade_Vaga");

				vagas.add(new Vaga(id, nome, atividade, salario, requisito, TipoTurno.valueOf(turno)));

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

		return vagas;
	}

	public List<Vaga> recuperarVagaOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY nome_Vaga DESC");

			while (resultado.next()) {

				long id = resultado.getLong("Id_Vaga");
				String nome = resultado.getString("nome_Vaga");
				String atividade = resultado.getString("atividade_Vaga");
				String salario = resultado.getString("salario_Vaga");
				String requisito = resultado.getString("requisito_Vaga");
				String turno = resultado.getString("atividade_Vaga");

				vagas.add(new Vaga(id, nome, atividade, salario, requisito, TipoTurno.valueOf(turno)));
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

		return vagas;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=root&password=root");
	}

}
