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
					"INSERT INTO contato (telefone_Contato, celular_Contato, email_Contato, facebook_Contato, instagram_Contato, linkedin_Contato) VALUES (?,?,?,?,?,?)");

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
			delete = conexao.prepareStatement("DELETE FROM contato WHERE id_Contato = ?");

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
			update = conexao.prepareStatement("UPDATE contato SET telefone_Contato = ? WHERE id_Contato = ?");

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
			update = conexao.prepareStatement("UPDATE contato SET celular_Contato = ? WHERE id_Contato = ?");

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
			update = conexao.prepareStatement("UPDATE contato SET email_Contato = ? WHERE id_Contato = ?");

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
			update = conexao.prepareStatement("UPDATE contato SET fabeook_Contato = ? WHERE id_Contato = ?");

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
			update = conexao.prepareStatement("UPDATE contato SET instagram_Contato = ? WHERE id_Contato = ?");

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
			update = conexao.prepareStatement("UPDATE contato SET linkedin_Contato = ? WHERE id_Contato = ?");

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

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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

	public List<Contato> recuperarContatosPorUsuario(String idUsuario) {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Contato> contatos = new ArrayList<Contato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM contato WHERE id_Usuario = " + idUsuario);

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY telefone_Contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY telefone_Contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY celular_Contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY celular_Contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY email_Contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY email_Contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY facebook_Contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY facebook_Contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY instagram_Contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY instagram_Contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY linkedin_Contato ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
			resultado = consulta.executeQuery("SELECT * FROM contato ORDER BY linkedin_Contato DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_Contato");
				String telefone = resultado.getString("telefone_Contato");
				String celular = resultado.getString("celular_Contato");
				String email = resultado.getString("email_Contato");
				String facebook = resultado.getString("facebook_Contato");
				String instagram = resultado.getString("instagram_Contato");
				String linkedin = resultado.getString("linkedin_Contato");

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
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=rootn&password=root");
	}
}