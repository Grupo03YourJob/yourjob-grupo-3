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

public class ContatoDAOImpl implements ContatoDAO {

	public void inserirContato(Contato contato) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO contato (id_contato, telefone_contato, celular_contato, email_contato, facebook_contato, instagram_contato, linkedin_contato) VALUES (0, ?,?,?,?,?,?)");

			insert.setString(1, contato.getTelefone());
			insert.setString(2, contato.getCelular());
			insert.setString(3, contato.getEmail());
			insert.setString(4, contato.getFacebook());
			insert.setString(5, contato.getInstagram());
			insert.setString(6, contato.getLinkedin());

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

			delete.setLong(1, contato.getId());

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

	public void atualizarTelefoneContato(Contato contato, String novoTelefone) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET telefone_contato = ? WHERE id_contato = ?");

			update.setString(1, novoTelefone);
			update.setLong(2, contato.getId());

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
			update = conexao.prepareStatement("UPDATE contato SET celular_contato = ? WHERE id_contato = ?");

			update.setString(1, novoCelular);
			update.setLong(2, contato.getId());

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

	public void atualizarEmailContato(Contato contato, String novoEmail) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET email_contato = ? WHERE id_contato = ?");

			update.setString(1, novoEmail);
			update.setLong(2, contato.getId());

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

	public void atualizarFacebookContato(Contato contato, String novoFacebook) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET fabeook_contato = ? WHERE id_contato = ?");

			update.setString(1, novoFacebook);
			update.setLong(2, contato.getId());

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

	public void atualizarInstagramContato(Contato contato, String novoInstagram) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET instagram_contato = ? WHERE id_contato = ?");

			update.setString(1, novoInstagram);
			update.setLong(2, contato.getId());

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

	public void atualizarLinkedinContato(Contato contato, String novoLinkedin) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE contato SET linkedin_contato = ? WHERE id_contato = ?");

			update.setString(1, novoLinkedin);
			update.setLong(2, contato.getId());

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

	public List<Contato> recuperarContatos() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosTelefoneAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY telefone_contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosTelefoneDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY telefone_contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosCelularAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY celular_contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosCelularDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY celular_contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosEmailAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY email_contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosEmailDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY email_contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosFacebookAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY facebook_contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosFacebookDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY facebook_contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosInstagramAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY instagram_contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosInstagramDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY instagram_contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosLinkedinAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY linkedin_contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	public List<Contato> recuperarContatosOrdenadosLinkedinDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY linkedin_contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_contato");
				String telefone = resultado.getString("telefone_contato");
				String celular = resultado.getString("celular_contato");
				String email = resultado.getString("email_contato");
				String facebook = resultado.getString("facebook_contato");
				String instagram = resultado.getString("instagram_contato");
				String linkedin = resultado.getString("linkedin_contato");

				contatos.add(new Contato(id, telefone, celular, email, facebook, instagram, linkedin));
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

		return contatos;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}