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
					"INSERT INTO endereco (rua_endereco, bairro_endereco, numero_ endereco, cep_endereco, cidade_endereco, estado_endereco, referencia_endereco) VALUES (?,?,?,?,?,?,?)");

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
			delete = conexao.prepareStatement("DELETE FROM endereco WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET rua_endereco = ? WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET bairro_endereco = ? WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET numero_endereco = ? WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET cep_endereco = ? WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET cidade_endereco = ? WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET estado_endereco = ? WHERE id_endereco = ?");

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
			update = conexao.prepareStatement("UPDATE endereco SET referencia_endereco = ? WHERE id_endereco = ?");

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

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY rua_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY rua_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosBairroAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY bairro_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosBairroDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY bairro_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosNumeroAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY numero_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosNumeroDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY numero_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosCepAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cep_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosCepDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cep_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosCidadeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cidade_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosCidadeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cidade_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosEstadoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY estado_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosEstadoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY estados_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosReferenciaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY referencia_endereco ASC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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

	public List<Endereco> recuperarEnderecosOrdenadosReferenciaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> enderecos = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY referencia_endereco DESC");

			while (resultado.next()) {

				long id = resultado.getLong("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

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
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/db_yourjob?useTimezone=true&serverTimezone=UTC&user=root&password=root");
	}
}