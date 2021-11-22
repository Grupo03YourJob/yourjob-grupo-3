package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Idioma;
import model.bean.TipoNivel;

public class IdiomaDAOImpl implements IdiomaDAO {

	public void inserirIdioma(Idioma idioma) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO idioma (nome_Idioma, nivel_Idioma) VALUES (?,?)");

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
	}

	public void deletarIdioma(Idioma idioma) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM idioma WHERE id_Idioma = ?");

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
			update = conexao.prepareStatement("UPDATE idioma SET nome_idioma = ? WHERE id_Idioma = ?");

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
			update = conexao.prepareStatement("UPDATE idioma SET nivel_idioma = ? WHERE id_Idioma = ?");

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

	public List<Idioma> recuperarIdioma() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM Idioma");

			while (resultado.next()) {

				long id = resultado.getLong("id_Idioma");
				String nome = resultado.getString("nome_Idioma");
				String nivel = resultado.getString("nivel_Idioma");

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

	public List<Idioma> recuperarIdiomaPorCurriculo(String idCurriculo) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma WHERE id_Curriculo = " + idCurriculo);

			while (resultado.next()) {

				long id = resultado.getLong("id_Idioma");
				String nome = resultado.getString("nome_Idioma");
				String nivel = resultado.getString("nivel_Idioma");

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

	public List<Idioma> recuperarIdiomaOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nome_Idioma ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Idioma");
				String nome = resultado.getString("nome_Idioma");
				String nivel = resultado.getString("nivel_Idioma");

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

	public List<Idioma> recuperarIdiomaOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idiomas = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nome_Idioma DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Idioma");
				String nome = resultado.getString("nome_Idioma");
				String nivel = resultado.getString("nivel_Idioma");

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
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=rootn&password=root");
	}
}
