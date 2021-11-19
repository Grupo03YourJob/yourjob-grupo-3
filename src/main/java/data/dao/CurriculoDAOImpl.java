package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Curriculo;

public abstract class CurriculoDAOImpl implements CurriculoDAO {

	public void inserirCurriculo(Curriculo curriculo) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO curriculo (id_curriculo, objetivo_curriculo, habilidade_curriculo , formcao_curriculo, experiencia_curriculo, idioma_curriculo) VALUES (?,?,?,?)");

			insert.setLong(1, curriculo.getIdCurriculo());
			insert.setString(2, curriculo.getObjetivoCurriculo());
			insert.setString(3, curriculo.getHabilidadeCurriculo());
			insert.setString(4, curriculo.getformacaoCurriculo));
			insert.setString(4, curriculo.getExperiencias());
			insert.setString(4, curriculo.getIdiomasCurriculo));

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
			delete = conexao.prepareStatement("DELETE FROM curriculo WHERE id_Curriculo = ?");

			delete.setLong(1, Curriculo.getIdCurriculo());

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

	public void atualizarObjetivoCurriculo(Curriculo curriculo, String objetivo) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE curriculo SET objetivo_curriculo = ? WHERE nome_contato = ?");

			String novoObjetivo;
			update.setString(1, novoObjetivo);
			update.setString(2, Curriculo.getObjetivoCurriculo());

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

	public void atualizarHabilidadeCurriculo(Curriculo curriculo, String novaHabilidade) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET habilidade_curriculo = ? WHERE nome_curriculo = ?");

			update.setString(1, novaHabilidade);
			update.setString(2, curriculo.getNomeCurriculo());

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

	public void atualizarFormacaoCurriculo(Curriculo curriculo, String novaFormacao) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET formacao_curriculo = ? WHERE nome_curriculo = ?");

			update.setString(1, novaFormacao);
			update.setString(2, Curriculo.getNomeCurriculo());

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

	public void atualizarExperienciaCurriculo(Curriculo curriculo, String novoExperiencia) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente experiencia_curriculo = ? WHERE nome_curriculo = ?");

			update.setString(1, novaExperiencia);
			update.setString(2, Curriculo.getNomeCurriculo());

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

	public void atualizarIdiomaCurriculo(Curriculo curriculo, String idioma) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente idioma_curriculo = ? WHERE nome_curriculo = ?");

			update.setString(1, novoIdioma);
			update.setString(2, curriculo.getNomeCurriculo());

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

	public List<Curriculo> recuperarCurriculo() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		List<Curriculo> curriculo;
		return curriculo;
	}

	public List<Curriculo> recuperarCurriculoOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY nome_curriculo ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> contato = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY nome_curriculo DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosObjetivoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY objetivo_curriculo ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosObjetivoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> contato = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY objetivo_curriculo DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosHabilidadeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY habilidade_curriculo ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosHabilidadeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> contato = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY habilidade_curriculo DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosFormacaoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY formacao_curriculo ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosFormacaoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> contato = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY formacao_curriculo DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosExperienciaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY experiencia_curriculo ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosExperienciaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> contato = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY experiencia_curriculo DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosIdiomaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> clientes = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY idioma_curriculo ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	public List<Curriculo> recuperarCurriculoOrdenadosIdiomaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Curriculo> contato = new ArrayList<Curriculo>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM curriculo ORDER BY idioma_curriculo DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_curriculo");
				String objetivo = resultado.getString("objetivo_curriculo");
				String habilidade = resultado.getString("habilidade_curriculo");
				String formacao = resultado.getString("formacao_curriculo");
				String experiencia = resultado.getString("experiencia_curriculo");
				String idioma = resultado.getString("idioma_curriculo");

				Curriculo.add(new Curriculo(nome, objetivo, , habilidade, experiencia, idioma));
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

		return recuperarCurriculo();
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
