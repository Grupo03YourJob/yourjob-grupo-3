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
					"INSERT INTO experiencia (empresa_Experiencia, cargo_Exercido_Experiencia, dataInicial_experiencia, dataFinal_experiencia) VALUES (?,?,?,?)");

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
			delete = conexao.prepareStatement("DELETE FROM experiencia WHERE id_Experiencia = ?");

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
					.prepareStatement("UPDATE experiencia SET empresa_Experiencia = ? WHERE id_Experiencia = ?");

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
					.prepareStatement("UPDATE experiencia SET cargo_Exercido_Experiencia = ? WHERE id_Experiencia = ?");

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

	public void atualizarDataInicalExperiencia(Experiencia experiencia, Date novoDataIncial) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET dataIncial_Experiencia = ? WHERE id_Experiencia = ?");

			update.setDate(1, novoDataIncial);
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
					.prepareStatement("UPDATE experiencia SET dataFinal_Experiencia = ? WHERE id_Experiencia = ?");

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

	public List<Experiencia> recuperarExperiencia() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia");

			while (resultado.next()) {

				long id = resultado.getLong("id_Exeperiencia");
				String empresa = resultado.getString("empresa_Experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_Experiencia");
				Date dataInicial = resultado.getDate("dataInicial_Experiencia");
				Date dataFinal = resultado.getDate("dataFinal_Experiencia");

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

	public List<Experiencia> recuperarExperienciaPorCurriculo(String idCurriculo) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia WHERE id_Curriculo = " + idCurriculo);

			while (resultado.next()) {

				long id = resultado.getLong("id_Exeperiencia");
				String empresa = resultado.getString("empresa_Experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_Experiencia");
				Date dataInicial = resultado.getDate("dataInicial_Experiencia");
				Date dataFinal = resultado.getDate("dataFinal_Experiencia");

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

	public List<Experiencia> recuperarExperienciaEmpresaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY id_Experiencia ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Exeperiencia");
				String empresa = resultado.getString("empresa_Experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_Experiencia");
				Date dataInicial = resultado.getDate("dataInicial_Experiencia");
				Date dataFinal = resultado.getDate("dataFinal_Experiencia");

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

		return recuperarExperiencia();
	}

	public List<Experiencia> recuperarExperienciaEmpresaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencias = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY id_experiencia DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Exeperiencia");
				String empresa = resultado.getString("empresa_Experiencia");
				String cargoExercido = resultado.getString("cargo_Exercido_Experiencia");
				Date dataInicial = resultado.getDate("dataInicial_Experiencia");
				Date dataFinal = resultado.getDate("dataFinal_Experiencia");

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
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=root&password=root");
	}

}
