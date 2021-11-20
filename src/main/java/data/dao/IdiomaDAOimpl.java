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

public class IdiomaDAOimpl implements IdiomaDAO {

	public void inserirIdioma(Idioma idioma) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement("INSERT INTO idioma (novo_idioma) VALUES (?,?)");

			insert.setString(1, idioma.getNomeIdioma());
			insert.setString(2, idioma.getNivelIdioma());

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
			delete = conexao.prepareStatement("DELETE FROM idioma WHERE id_idioma = ?");

			delete.setLong(1, idioma.getIdIdioma());

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

	public void atualizarNovoIdioma(Idioma idioma, String novoIdioma) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE idioma SET nome_idioma = ? WHERE id_idioma = ?");

			update.setString(1, novoIdioma);
			update.setLong(2, idioma.getIdIdioma());

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

		List<Idioma> idioma = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma");

			while (resultado.next()) {

				long idIdioma = resultado.getLong("id_idioma");
				String nomeIdioma = resultado.getString("nome_idioma");
				String nivelIdioma = resultado.getString("nivelIdioma_idioma");

				idioma.add(new Idioma(idIdioma, nomeIdioma, nivelIdioma));
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

		return idioma;
	}

	public List<Idioma> recuperarIdiomaOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idioma = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nome_idioma ASC");

			while (resultado.next()) {

				long idIdioma = resultado.getLong("id_idioma");
				String nomeIdioma = resultado.getString("nome_idioma");
				String nivelIdioma = resultado.getString("nivel_idioma");

				idioma.add(new Idioma(idIdioma, nomeIdioma, nivelIdioma));
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

		return idioma;
	}

	public List<Idioma> recuperarIdiomaOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Idioma> idioma = new ArrayList<Idioma>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM idioma ORDER BY nome_idioma DESC");

			while (resultado.next()) {

				long idIdioma = resultado.getLong("id_idioma");
				String nomeIdioma = resultado.getString("nome_idioma");
				String nivelIdioma = resultado.getString("nivel_idioma");

				idioma.add(new Idioma(idIdioma, nomeIdioma, nivelIdioma));
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

		return idioma;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
