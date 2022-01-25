package yourjob.modelo.dao.idioma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import yourjob.modelo.entidade.idioma.Idioma;
import yourjob.modelo.enumeracao.TipoNivel;

public class IdiomaDAOImpl implements IdiomaDAO {

	public Idioma inserirIdioma(Idioma idioma) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO idioma (nome_idioma, nivel_idioma) VALUES (?,?)");

			insert.setString(1, idioma.getNome());
			insert.setString(2, idioma.getNivel().name());

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

		return idioma;
	}

	public void deletarIdioma(Idioma idioma) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM idioma WHERE id_idioma = ?");

			delete.setLong(1, idioma.getId());

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

	public void atualizarNomeIdioma(Idioma idioma, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE idioma SET nome_idioma = ? WHERE id_idioma = ?");

			update.setString(1, novoNome);
			update.setLong(2, idioma.getId());

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

	public void atualizarNivelIdioma(Idioma idioma, TipoNivel novoNivel) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE idioma SET nivel_idioma = ? WHERE id_idioma = ?");

			update.setString(1, novoNivel.name());
			update.setLong(2, idioma.getId());

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

	public List<Idioma> recuperarIdiomas() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma");

			while (resultado.next()) {

				long id = resultado.getLong("id_idioma");
				String nome = resultado.getString("nome_idioma");
				String nivel = resultado.getString("nivel_idioma");

				idiomas.add(new Idioma(id, nome, TipoNivel.valueOf(nivel)));
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

		return idiomas;
	}

	public List<Idioma> recuperarIdiomasOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nome_idioma ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_idioma");
				String nome = resultado.getString("nome_idioma");
				String nivel = resultado.getString("nivel_idioma");

				idiomas.add(new Idioma(id, nome, TipoNivel.valueOf(nivel)));
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

		return idiomas;
	}

	public List<Idioma> recuperarIdiomasOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nome_idioma DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_idioma");
				String nome = resultado.getString("nome_idioma");
				String nivel = resultado.getString("nivel_idioma");

				idiomas.add(new Idioma(id, nome, TipoNivel.valueOf(nivel)));
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

		return idiomas;
	}

	public List<Idioma> recuperarIdiomasOrdenadosNivelAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nivel_idioma ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_idioma");
				String nome = resultado.getString("nome_idioma");
				String nivel = resultado.getString("nivel_idioma");

				idiomas.add(new Idioma(id, nome, TipoNivel.valueOf(nivel)));
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

		return idiomas;
	}

	public List<Idioma> recuperarIdiomasOrdenadosNivelDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nivel_idioma DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_idioma");
				String nome = resultado.getString("nome_idioma");
				String nivel = resultado.getString("nivel_idioma");

				idiomas.add(new Idioma(id, nome, TipoNivel.valueOf(nivel)));
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

		return idiomas;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}