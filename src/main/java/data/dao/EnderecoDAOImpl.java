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

public abstract class EnderecoDAOImpl implements EnderecoDAO {

	public void inserirEndereco(Endereco endereco) {

		Connection conexao = null;
		PreparedStatement insert = null;

		try {

			conexao = conectarBanco();
			insert = conexao.prepareStatement(
					"INSERT INTO endereco (id_endereco, rua_endereco, bairro_endereco , numero_endereco, cep_endereco, cidade_endereco, estado_endereco, referenci_endereco) VALUES (?,?,?,?)");

			insert.setLong(1, endereco.getIdEndereco());
			insert.setString(2, endereco.getRuaEndereco());
			insert.setString(3, endereco.getBairroEndereco());
			insert.setString(4, endereco.getNumeroEndereco));
			insert.setString(4, endereco.getCepEndereco());
			insert.setString(4, endereco.getCidadeEndereco));
			insert.setString(4, endereco.getEstadoEndereco));
			insert.setString(4, endereco.getReferenciaEndereco));

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

			delete.setLong(1, Endereco.getIdEndereco());

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

	public void atualizarRuaEndereco(Endereco endereco, String rua) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE endereco SET rua_Endereco = ? WHERE id_endereco = ?");

			String novaRua;
			update.setString(1, novaRua);
			update.setString(2, Endereco.getRuaEndereco());

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
			update = conexao.prepareStatement("UPDATE Endereco SET bairro_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoBairro);
			update.setString(2, endereco.getIdEndereco());

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
			update.setString(2, Endereco.getIdEndereco());

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
			update = conexao.prepareStatement("UPDATE endereco cep_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoCep);
			update.setString(2, Endereco.getIdEndereco());

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

	public void atualizarCidadeEndereco(Endereco endereco, String cidade) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE Endereco cidade_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novaCidade);
			update.setString(2, Endereco.getIdEndereco());

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

	public void atualizarEstadoEndereco(Endereco endereco, String estado) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE Endereco estado_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novoEstado);
			update.setString(2, Endereco.getIdEndereco());

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

	public void atualizarReferenciaEndereco(Endereco endereco, String referencia) {

		Connection conexao = null;
		PreparedStatement update = null;

		try {

			conexao = conectarBanco();
			update = conexao.prepareStatement("UPDATE Endereco referencia_endereco = ? WHERE id_endereco = ?");

			update.setString(1, novaReferencia);
			update.setString(2, Endereco.getIdEndereco());

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

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		List<Endereco> endereco;
		return endereco;
	}

	public List<Endereco> recuperarEnderecoOrdenadosIdAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY id_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosIdDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY id_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosRuaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY rua_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosRuaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY rua_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosBairroAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY bairro_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosBairroDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY bairro_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosNumeroAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY numero_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosNumeroDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY numero_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosCepAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cep_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosCepDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cep_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosCidadeAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cidade_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosCidadeDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY cidade_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosEstadoAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY estado_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosEstadoDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY estado_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	public List<Endereco> recuperarEnderecoOrdenadosReferenciaAscendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> clientes = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY referencia_endereco ASC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

	public List<Endereco> recuperarEnderecoOrdenadosReferenciaDescendente() {

		Connection conexao = null;
		Statement consulta = null;
		ResultSet resultado = null;

		List<Endereco> contato = new ArrayList<Endereco>();

		try {

			conexao = conectarBanco();
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery("SELECT * FROM endereco ORDER BY referencia_endereco DESC");

			while (resultado.next()) {

				String id = resultado.getString("id_endereco");
				String rua = resultado.getString("rua_endereco");
				String bairro = resultado.getString("bairro_endereco");
				String numero = resultado.getString("numero_endereco");
				String cep = resultado.getString("cep_endereco");
				String cidade = resultado.getString("cidade_endereco");
				String estado = resultado.getString("estado_endereco");
				String referencia = resultado.getString("referencia_endereco");

				Endereco.add(new Endereco(id, rua, bairro, numero, cep, cidade, estado, referencia));
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

		return recuperarEndereco();
	}

	private Connection conectarBanco() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/cadastro?user=admin&password=password");
	}
}
