package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Endereco;

public class EnderecoDAO {

	private static List<Endereco> enderecos = new ArrayList<Endereco>();

	public void criarEndereco(Endereco endereco) throws Exception {
		for (Endereco enderecoLista : enderecos) {
			if (endereco.getIdEndereco() == enderecoLista.getIdEndereco()) {
				throw new Exception("Address not created!");
			}
		}

		enderecos.add(endereco);
	}

	public Endereco buscarEndereco(long idEndereco) throws Exception {
		for (Endereco enderecoLista : enderecos) {
			if (enderecoLista.getIdEndereco() == idEndereco) {
				return enderecoLista;
			}
		}
		throw new Exception("Address not found!");
	}

	public void editarEndereco(Endereco enderecoNovo) throws Exception {
		for (int i = 0; i < enderecos.size(); i++) {
			Endereco enderecoAntigo = enderecos.get(i);
			if (enderecoAntigo.getIdEndereco() == enderecoNovo.getIdEndereco()) {
				enderecos.add(i, enderecoAntigo);
				return;
			}
		}
		throw new Exception("Address not updated!");
	}

	public void excluirEndereco(Endereco endereco) {
		enderecos.remove(endereco);
	}
}
