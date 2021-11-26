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

import model.bean.Experiencia;

public class ExperienciaDAOImpl implements ExperienciaDAO {

	public void inserirExperiencia(Experiencia experiencia) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO experiencia (empresa_experiencia, cargo_exercido_experiencia, data_inicial_experiencia, data_final_experiencia) VALUES (?,?,?,?)");

			insert.setString(1, experiencia.getEmpresa());
			insert.setString(2, experiencia.getCargoExercido());
			insert.setDate(3, experiencia.getDataInicial());
			insert.setDate(4, experiencia.getDataFinal());

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

	public void deletarExperiencia(Experiencia experiencia) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM experiencia WHERE id_experiencia = ?");

			delete.setLong(1, experiencia.getId());

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

	public void atualizarEmpresaExperiencia(Experiencia experiencia, String novoEmpresa) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET empresa_experiencia = ? WHERE id_experiencia = ?");

			update.setString(1, novoEmpresa);
			update.setLong(2, experiencia.getId());

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

	public void atualizarCargoExercidoExperiencia(Experiencia experiencia, String novoCargoExercido) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET cargo_exercido_experiencia = ? WHERE id_experiencia = ?");

			update.setString(1, novoCargoExercido);
			update.setLong(2, experiencia.getId());

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

	public void atualizarDataInicialExperiencia(Experiencia experiencia, Date novoDataInicial) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET data_inicial_experiencia = ? WHERE id_experiencia = ?");

			update.setDate(1, novoDataInicial);
			update.setLong(2, experiencia.getId());

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

	public void atualizarDataFinalExperiencia(Experiencia experiencia, Date novoDataFinal) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET data_final_experiencia = ? WHERE id_experiencia = ?");

			update.setDate(1, novoDataFinal);
			update.setLong(2, experiencia.getId());

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

	public List<Experiencia> recuperarExperiencias() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosEmpresaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY empresa_experiencia ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosEmpresaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY empresa_experiencia DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosCargoExercidoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY cargo_exercido_experiencia ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosCargoExercidoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY cargo_exercido_experiencia DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosDataInicialAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY data_inicial_experiencia ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosDataInicialDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY data_inicial_experiencia DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosDataFinalAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY data_final_experiencia ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	public List<Experiencia> recuperarExperienciasOrdenadosDataFinalDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY data_final_experiencia DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_experiencia");
				String empresa = resultado.getString("empresa_experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_experiencia");
				Date dataInicial = resultado.getDate("data_inicial_experiencia");
				Date dataFinal = resultado.getDate("data_final_experiencia");

				experiencias.add(new Experiencia(id, empresa, cargoExercido, dataInicial, dataFinal));
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

		return experiencias;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}