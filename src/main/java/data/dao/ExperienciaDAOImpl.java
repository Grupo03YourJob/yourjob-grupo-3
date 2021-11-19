package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Experiencia;

public abstract class ExperienciaDAOImpl implements ExperienciaDAO {

	public void inserirExperiencia(Experiencia experiencia) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO experiencia (id_experiencia, empresa_experiencia, cargo_experiencia , dataInicial_experiencia, dataFinal_experiencia) VALUES (?,?,?,?)");

			insert.setLong(1, experiencia.getIdExperiencia());
			insert.setString(2, experiencia.getEmpresaExperiencia());
			insert.setString(3, experiencia.getCargoExperiencia());
			insert.setString(4, experiencia.getDataInicialExperiencia));
			insert.setString(4, experiencia.getDataFinalExperiencia());
			

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

			delete.setLong(1, Experiencia.getIdExperiencia());

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

	public void atualizarEmpresaExperiencia(Experiencia experiencia, String empresa) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET empresa_experiencia = ? WHERE id_experiencia = ?");

			String novaExperiencia;
			update.setString(1, novaExperiencia);
			update.setString(2, Experiencia.getIdExperiencia());

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

	public void atualizarCargoExperiencia(Experiencia experiencia, String novoCargo) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE experiencia SET cargo_experiencia = ? WHERE id_experiencia = ?");

			update.setString(1, novoCargo);
			update.setString(2, experiencia.getIdExperiencia());

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

	public void atualizarDataInicialExperiencia(Experiencia experiencia, String novaDataInicial) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE experiencia SET datainicial_experiencia = ? WHERE id_experiencia = ?");

			update.setString(1, novaDataInicial);
			update.setString(2, Experiencia.getDataInicialExperiencia());

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

	public void atualizarDataFinalExperiencia(Experiencia experiencia, String novaDataFinal) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE experiencia dataFinal_experiencia = ? WHERE id_experiencia = ?");

			update.setString(1, novaDataFinal);
			update.setString(2, Experiencia.getIdExperiencia());

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

		List<Experiencia> clientes = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

		List<Experiencia> experiencia;
		return Experiencia;
	}

	public List<Experiencia> recuperarExperienciaOrdenadosIdAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencia = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY id_experiencia ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosIdDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> contato = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY id_experiencia DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosEmpresaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencia = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY empresa_experiencia ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosEmpresaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> contato = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY empresa_experiencia DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosCargoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencia = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY cargo_experiencia ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosCargoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> contato = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY cargo_experiencia DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosDataInicialAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencia = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY dataInicial_experiencia ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosDataInicialDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> contato = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY dataInicial_experiencia DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosDataFinalAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> experiencia = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY dataFinal_experiencia ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	public List<Experiencia> recuperarExperienciaOrdenadosDataFinalDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Experiencia> contato = new ArrayList<Experiencia>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM experiencia ORDER BY dataFinal_experiencia DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String empresa = resultado.getString("rua_endereco");
				String cargo = resultado.getString("bairro_endereco");
				String dataInicial = resultado.getString("numero_endereco");
				String dataFinal = resultado.getString("cep_endereco");

				Experiencia.add(new Experiencia(id, empresa, cargo, dataInicial, dataFinal));
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

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
