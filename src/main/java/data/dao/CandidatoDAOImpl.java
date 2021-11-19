package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Candidato;

public abstract class CandidatoDAOImpl implements CandidatoDAO {

	public void inserirCandidato(Candidato candidato) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO candidato (nome_candidato, sobreNome_candidato,dataNascimento_candidato , email_candidato, contato_candidato, curriculo_candidato, vaga_candidato, senha_candidato) VALUES (?,?,?,?)");

			insert.setString(1, candidato.getNomeUsuario());
			insert.setString(2, candidato.getSobrenomeUsuario());
			insert.setDate(3, candidato.getDataNascimentoCandidato());
			insert.setString(4, candidato.getEmailUsuario());
			insert.setDate(4, candidato.getContato());
			insert.setDouble(4, candidato.getCurriculo());
			insert.setDouble(4, candidato.getVagas());
			insert.setDouble(4, candidato.getSenhaUsuario());

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

	public void deletarCandidato(Candidato candidato) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM candidato WHERE nome_candidato = ?");

			delete.setString(1, candidato.getNomeUsuario());

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

	public void atualizarNomeCandidato(Candidato candidato, String novoNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE candidato SET nome_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novoNome);
			update.setInt(2, candidato.getNomeCandidato());

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

	public void atualizarSobreNOme(Candidato candidato, String novoSobreNome) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE candidato SET sobreNome_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novoSobreNome);
			update.setString(2, candidato.getNomeUsuario());

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

	public void atualizarDataNascimentoCandidato(Candidato candidato, String novaDataNascimento) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao
					.prepareStatement("UPDATE cliente SET dataNascimento_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novaDataNascimento);
			update.setString(2, candidato.getNomeUsuario());

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

	public void atualizarEmail(Candidato candidato, String novoEmail) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente email_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novoEmail);
			update.setString(2, candidato.getNomeUsuario());

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

	public void atualizarContato(Candidato candidato, String novoContato) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente contato_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novoContato);
			update.setString(2, candidato.getContato());

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

	public void atualizarCurriculo(Candidato candidato, String novoCurriculo) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente curriculo_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novoCurriculo);
			update.setString(2, candidato.getCurriculo());

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

	public void atualizarVaga(Candidato candidato, String novaVaga) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente vaga_candidato = ? WHERE nome_candidato = ?");

			update.setString(1, novaVaga);
			update.setString(2, candidato.getVaga());

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

	public void atualizarSenha(Candidato candidato, String novoSenha) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE cliente senha_candidato = ? WHERE nome_candidato = ?");

			String novaSenha;
			update.setString(1, novaSenha);
			update.setString(2, candidato.getSenha());

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

	public List<Candidato> recuperarCandidato() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> clientes = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> clientes = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY nome_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return recuperarCandidato();
	}

	public List<Candidato> recuperarCandidatoOrdenadosNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY nome_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosSobreNomeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> clientes = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM Candidato ORDER BY sobreNome_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return recuperarCandidato();
	}

	public List<Candidato> recuperarCandidatoOrdenadosSobreNomeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> clientes = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY sobreNome_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return recuperarCandidato();
	}

	public List<Candidato> recuperarCandidatoOrdenadosDataNascimentoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY dataNascimento_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosDataNascimentoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY dataNascimento_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosEmailAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY email_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarClientesOrdenadosEmailDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY email_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosContatoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY contato_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosContatoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY contato_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadoscurriculoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY curriculo_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosCurriculoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY curriculo_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosVagaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY vaga_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosVagaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY vaga_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosSenhaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY senha_candidato ASC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	public List<Candidato> recuperarCandidatoOrdenadosSenhaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Candidato> candidato = new ArrayList<Candidato>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM candidato ORDER BY senha_candidato DESC");

			while (resultado.next()) {

				String nome = resultado.getString("nome_candidato");
				String sobreNome = resultado.getString("sobreNome_candidato");
				String dataNascimento = resultado.getString("dataNascimento_candidato");
				String email = resultado.getString("email_candidato");
				String contato = resultado.getString("contato_candidato");
				String curriculo = resultado.getString("curriculo_candidato");
				String vaga = resultado.getString("vaga_candidato");
				String senha = resultado.getString("senha_candidato");

				candidato.add(new Candidato(nome, sobreNome, dataNascimento, email, contato, curriculo, senha));
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

		return candidato;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
