package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Formacao;

public class FormacaoDAO {

	private static List<Formacao> formacaos = new ArrayList<Formacao>();

	public void criarFormacao(Formacao formacao) throws Exception {
		for (Formacao formacaoLista : formacaos) {
			if (formacao.getIdFormacao() == formacaoLista.getIdFormacao()) {
				throw new Exception("Formation not created!");
			}
		}

		formacaos.add(formacao);
	}

	public Formacao buscarFormacao(long idFormacao) throws Exception {
		for (Formacao formacaoLista : formacaos) {
			if (formacaoLista.getIdFormacao() == idFormacao) {
				return formacaoLista;
			}
		}
		throw new Exception("Formation not found!");
	}

	public void editarFormacao(Formacao formacaoNovo) throws Exception {
		for (int i = 0; i < formacaos.size(); i++) {
			Formacao formacaoAntigo = formacaos.get(i);
			if (formacaoAntigo.getIdFormacao() == formacaoNovo.getIdFormacao()) {
				formacaos.add(i, formacaoAntigo);
				return;
			}
		}
		throw new Exception("Formation not updated!");
	}

	public void excluirCandidato(Formacao formacao) {
		formacaos.remove(formacao);
	}

}
