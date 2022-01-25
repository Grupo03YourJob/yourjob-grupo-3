package yourjob.modelo.dao.curriculo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yourjob.modelo.entidade.curriculo.Curriculo;

public class CurriculoDAOImpl implements CurriculoDAO {

	public void inserirCurriculo(Curriculo curriculo) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao
					.prepareStatement("INSERT INTO curriculo (objetivo_curriculo, habilidade_curriculo) VALUES (?,?)");

			insert.setString(1, curriculo.getObjetivo());
			insert.setString(1, curriculo.getHabilidade());

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

	public void deletarCurriculo(Curriculo curriculo) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM curriculo WHERE id_curriculo = ?");

			delete.setLong(1, curriculo.getId());

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

	public void atualizarObjetivoCurriculo(Curriculo curriculo, String novoObjetivo) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE curriculo SET objetivo_curriculo = ? WHERE id_curriculo = ?");

			update.setString(1, novoObjetivo);
			update.setLong(2, curriculo.getId());

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

	public void atualizarHabilidadeCurriculo(Curriculo curriculo, String novoHabilidade) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE curriculo SET habilidade_curriculo = ? WHERE id_curriculo = ?");

			update.setString(1, novoHabilidade);
			update.setLong(2, curriculo.getId());

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

	public List<Curriculo> recuperarCurriculos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> curriculos = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo");

			while (resultado.next()) {

				long id = resultado.getLong("id_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");

				curriculos.add(new Curriculo(id, objetivo, habilidade));
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

		return curriculos;
	}

	public List<Curriculo> recuperarCurriculosOrdenadosObjetivoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> curriculos = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY objetivo_curriculo ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");

				curriculos.add(new Curriculo(id, objetivo, habilidade));
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

		return curriculos;
	}

	public List<Curriculo> recuperarCurriculosOrdenadosObjetivoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> curriculos = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY objetivo_curriculo DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");

				curriculos.add(new Curriculo(id, objetivo, habilidade));
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

		return curriculos;
	}

	public List<Curriculo> recuperarCurriculosOrdenadosHabilidadeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> curriculos = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY habilidade_curriculo ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");

				curriculos.add(new Curriculo(id, objetivo, habilidade));
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

		return curriculos;
	}

	public List<Curriculo> recuperarCurriculosOrdenadosHabilidadeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> curriculos = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY habilidade_curriculo DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");

				curriculos.add(new Curriculo(id, objetivo, habilidade));
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

		return curriculos;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}

}