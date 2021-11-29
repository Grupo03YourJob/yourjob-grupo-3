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
import model.util.TipoTurno;

public class VagaDAOImpl implements VagaDAO {

	public void inserirVaga(Vaga vaga) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO vaga (id_vaga, "
					+ "nome_vaga, atividade_vaga, salario_vaga, requisito_vaga, turno_vaga) VALUES (0,?,?,?,?,?)");

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
			delete = conexao.prepareStatement("DELETE FROM vaga WHERE id_vaga = ?");

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
			update = conexao.prepareStatement("UPDATE vaga SET nome_vaga = ? WHERE id_vaga = ?");

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
			update = conexao.prepareStatement("UPDATE vaga SET ativade_vaga = ? WHERE id_vaga = ?");

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
			update = conexao.prepareStatement("UPDATE vaga SET salario_vaga = ? WHERE id_vaga = ?");

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
			update = conexao.prepareStatement("UPDATE vaga SET requisito_vaga = ? WHERE id_vaga = ?");

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
			update = conexao.prepareStatement("UPDATE vaga SET turno_vaga = ? WHERE id_vaga = ?");

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

	public List<Vaga> recuperarVagas() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY nome_vaga ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY nome_vaga DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosAtividadeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY atividade_vaga ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosAtividadeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY atividade_vaga DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosSalarioAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY salario_vaga ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosSalarioDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY salario_vaga DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosRequisitoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY requisito_vaga ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosRequisitoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY requisito_vaga DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosTurnoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY turno_vaga ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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

	public List<Vaga> recuperarVagasOrdenadosTurnoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Vaga> vagas = new ArrayList<Vaga>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM vaga ORDER BY turno_vaga DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_vaga");
				String nome = resultado.getString("nome_vaga");
				String atividade = resultado.getString("atividade_vaga");
				String salario = resultado.getString("salario_vaga");
				String requisito = resultado.getString("requisito_vaga");
				String turno = resultado.getString("turno_vaga");

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
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}