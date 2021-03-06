package data.dao;

import java.sql.Date;
import java.util.List;

import model.bean.Formacao;

public interface FormacaoDAO {

	void inserirFormacao(Formacao formacao);

	void deletarFormacao(Formacao formacao);

	void atualizarNomeFormacao(Formacao formacao, String novoNome);

	void atualizarInstituicaoFormacao(Formacao formacao, String novoInstituicao);

	void atualizarDataInicialFormacao(Formacao formacao, Date novoDataInical);

	void atualizarDataFinalFormacao(Formacao formacao, Date novoDataFinal);

	List<Formacao> recuperarFormacoes();

	List<Formacao> recuperarFormacoesOrdenadosNomeAscendente();

	List<Formacao> recuperarFormacoesOrdenadosNomeDescendente();

	List<Formacao> recuperarFormacoesOrdenadosInstituicaoAscendente();

	List<Formacao> recuperarFormacoesOrdenadosInstituicaoDescendente();

	List<Formacao> recuperarFormacoesOrdenadosDataInicialAscendente();

	List<Formacao> recuperarFormacoesOrdenadosDataInicialDescendente();

	List<Formacao> recuperarFormacoesOrdenadosDataFinalAscendente();

	List<Formacao> recuperarFormacoesOrdenadosDataFinalDescendente();

}