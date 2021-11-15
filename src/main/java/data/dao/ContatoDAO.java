package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Contato;

public class ContatoDAO {

	private static List<Contato> contatos = new ArrayList<Contato>();

	public void criarContato(Contato contato) throws Exception {
		for (Contato contatoLista : contatos) {
			if (contato.getIdContato() == contatoLista.getIdContato()) {
				throw new Exception("Contact not created!");
			}
		}

		contatos.add(contato);
	}

	public Contato buscarContato(long idContato) throws Exception {
		for (Contato contatoLista : contatos) {
			if (contatoLista.getIdContato() == idContato) {
				return contatoLista;
			}
		}
		throw new Exception("Contact not found!");
	}

	public void editarContato(Contato contatoNovo) throws Exception {
		for (int i = 0; i < contatos.size(); i++) {
			Contato contatoAntigo = contatos.get(i);
			if (contatoAntigo.getIdContato() == contatoNovo.getIdContato()) {
				contatos.add(i, contatoAntigo);
				return;
			}
		}
		throw new Exception("Contact not updated!");
	}

	public void excluirCandidato(Contato contato) {
		contatos.remove(contato);
	}
}
