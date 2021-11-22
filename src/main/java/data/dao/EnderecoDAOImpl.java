package data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Endereco;

public class EnderecoDAOImpl implements EnderecoDAO {

	public void inserirEndereco(Endereco endereco) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO endereco (rua_Endereco, bairro_Endereco , numero_Endereco, cep_Endereco, cidade_endereco, estado_Endereco, referencia_Endereco) VALUES (?,?,?,?)");

			insert.setString(1, endereco.getRua());
			insert.setString(2, endereco.getBairro());
			insert.setString(3, endereco.getNumero());
			insert.setString(4, endereco.getCep());
			insert.setString(5, endereco.getCidade());
			insert.setString(6, endereco.getEstado());
			insert.setString(7, endereco.getReferencia());

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

	public void deletarEndereco(Endereco endereco) {

		Connection conexao = null;
		PreparedStatement delete = null;

		try {

			conexao = conectarBanco();
			delete = conexao.prepareStatement("DELETE FROM endereco WHERE id_Endereco = ?");

			delete.setLong(1, endereco.getId());

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

	public void atualizarRuaEndereco(Endereco endereco, String novoRua) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET rua_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoRua);
			update.setLong(2, endereco.getId());

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

	public void atualizarBairroEndereco(Endereco endereco, String novoBairro) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET bairro_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoBairro);
			update.setLong(2, endereco.getId());

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

	public void atualizarNumeroEndereco(Endereco endereco, String novoNumero) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET numero_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoNumero);
			update.setLong(2, endereco.getId());

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

	public void atualizarCepEndereco(Endereco endereco, String novoCep) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET cep_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoCep);
			update.setLong(2, endereco.getId());

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

	public void atualizarCidadeEndereco(Endereco endereco, String novoCidade) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET cidade_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoCidade);
			update.setLong(2, endereco.getId());

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

	public void atualizarEstadoEndereco(Endereco endereco, String novoEstado) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET estado_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoEstado);
			update.setLong(2, endereco.getId());

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

	public void atualizarReferenciaEndereco(Endereco endereco, String novoReferencia) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET referencia_Endereco = ? WHERE id_Endereco = ?");

			update.setString(1, novoReferencia);
			update.setLong(2, endereco.getId());

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

	public List<Endereco> recuperarEndereco() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco");

			while (resultado.next()) {

				Long id = resultado.getLong("id_Endereco");
				String rua = resultado.getString("rua_Endereco");
				String bairro = resultado.getString("bairro_Endereco");
				String numero = resultado.getString("numero_Endereco");
				String cep = resultado.getString("cep_Endereco");
				String cidade = resultado.getString("cidade_Endereco");
				String estado = resultado.getString("estado_Endereco");
				String referencia = resultado.getString("referencia_Endereco");

				enderecos.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return enderecos;
	}

	public List<Endereco> recuperarEnderecosOrdenadosRuaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY rua_Endereco ASC");

			while (resultado.next()) {

				Long id = resultado.getLong("id_Endereco");
				String rua = resultado.getString("rua_Endereco");
				String bairro = resultado.getString("bairro_Endereco");
				String numero = resultado.getString("numero_Endereco");
				String cep = resultado.getString("cep_Endereco");
				String cidade = resultado.getString("cidade_Endereco");
				String estado = resultado.getString("estado_Endereco");
				String referencia = resultado.getString("referencia_Endereco");

				enderecos.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return enderecos;
	}

	public List<Endereco> recuperarEnderecosOrdenadosRuaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY rua_Endereco DESC");

			while (resultado.next()) {

				Long id = resultado.getLong("id_Endereco");
				String rua = resultado.getString("rua_Endereco");
				String bairro = resultado.getString("bairro_Endereco");
				String numero = resultado.getString("numero_Endereco");
				String cep = resultado.getString("cep_Endereco");
				String cidade = resultado.getString("cidade_Endereco");
				String estado = resultado.getString("estado_Endereco");
				String referencia = resultado.getString("referencia_Endereco");

				enderecos.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return enderecos;
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=root&password=root");
	}
}
