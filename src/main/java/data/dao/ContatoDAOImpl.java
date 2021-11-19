package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Contato;

public abstract class ContatoDAOImpl implements ContatoDAO {

	public void inserirContato(Contato contato) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO contato (nome_contato, telefone_contato, celular_contato , facebook_contato, instagran_contato, linkedin_contato) VALUES (?,?,?,?)");

			insert.setLong(1, contato.getIdContato());
			insert.setString(2, contato.getTelefoneContato());
			insert.setString(3, contato.getCelularContato());
			insert.setString(4, contato.getFacebookContato());
			insert.setString(4, contato.getInstagramContato());
			insert.setString(4, contato.getLinkedinContato());

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

	public void deletarContato(Contato contato) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM contato WHERE id_contato = ?");

			delete.setLong(1, contato.getIdContato());

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

	public void atualizarTelefoneContato(Contato contato, String telefone) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET telefone_contato = ? WHERE nome_contato = ?");

			String novoTelefone;
			update.setString(1, novoTelefone);
			update.setString(2, Contato.getTelefoneContato());

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

	public void atualizarCelularContato(Contato contato, String novoCelular) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET celular_candidato = ? WHERE nome_contato = ?");

			update.setString(1, novoCelular);
			update.setString(2, contato.getNomeContato());

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

	public void atualizarFacebookContato(Contato contato, String novaFacebook) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente SET facebook_contato = ? WHERE nome_contato = ?");

			update.setString(1, novaFacebook);
			update.setString(2, contato.getNomeContato());

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

	public void atualizarInstagranContato(Contato contato, String novoInstagran) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente instagran_contato = ? WHERE nome_contato = ?");

			update.setString(1, novoInstagran);
			update.setString(2, contato.getNomeContato());

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

	public void atualizarLinkedinContato(Contato contato, String linkedin) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente linkedin_contato = ? WHERE nome_contato = ?");

			update.setString(1, novoLinkedin);
			update.setString(2, contato.getNomeContato());

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

	public List<Contato> recuperarContato() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		List<Contato> contato;
		return contato;
	}

	public List<Contato> recuperarContatoOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY nome_contato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return recuperarContato();
	}

	public List<Contato> recuperarContatoOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contato = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY nome_contato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return contato;
	}

	public List<Contato> recuperarContatoOrdenadosTelefoneAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY telefone_contato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return recuperarContato();
	}

	public List<Contato> recuperarContatoOrdenadosTelefoneDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contato = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY telefone_contato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return contato;
	}

	public List<Contato> recuperarContatoOrdenadosCelularAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY celular_contato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return recuperarContato();
	}

	public List<Contato> recuperarContatoOrdenadosCelularDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contato = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY celular_contato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return contato;
	}

	public List<Contato> recuperarContatoOrdenadosFacebookAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY facebook_contato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return recuperarContato();
	}

	public List<Contato> recuperarContatoOrdenadosFacebookDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contato = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY facebook_contato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return contato;
	}

	public List<Contato> recuperarContatoOrdenadosInstagranAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY instagran_contato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return recuperarContato();
	}

	public List<Contato> recuperarContatoOrdenadosInstagranDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contato = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY instagran_contato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return contato;
	}

	public List<Contato> recuperarContatoOrdenadosLinkedinAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> clientes = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY linkedin_contato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return recuperarContato();
	}

	public List<Contato> recuperarContatoOrdenadosLinkedinDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contato = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY linkedin_contato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagran = resultado.getString("instagran_contato");
				String linkedin = resultado.getString("linkedin_contato");

				Contato.add(new Contato(nome, telefone, celular, facebook, instagran, linkedin));
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

		return contato;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
