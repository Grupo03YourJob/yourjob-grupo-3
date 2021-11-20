package data.dao;

import java.util.List;
import model.bean.Formacao;

public interface FormacaoDAO {

	void inserirFormacao(Formacao formacao);

	void deletarFormacao(Formacao formacao);

	void atualizarNovaFormacao(Formacao formacao, String novaFormacao);

	List<Formacao> recuperarFormacao();

	List<Formacao> recuperarFormacaoOrdenadosNomeAscendente();

	List<Formacao> recuperarFormacaoOrdenadosNomeDescendente();

}
