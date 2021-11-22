package data.dao;

import java.sql.Date;
import java.util.List;
import model.bean.Formacao;

public interface FormacaoDAO {

	void inserirFormacao(Formacao formacao);

	void deletarFormacao(Formacao formacao);

	void atualizarNomeFormacao(Formacao formacao, String novoNome);

	void atualizarInstituicaoFormacao(Formacao formacao, String novoInstituicao);

	void atualizarDataInicialFormacao(Formacao formacao, Date novoDataIncial);

	void atualizarDataFinalFormacao(Formacao formacao, Date novoDataFinal);

	List<Formacao> recuperarFormacao();

	List<Formacao> recuperarFormacaoPorCurriculo(String idCurriculo);

	List<Formacao> recuperarFormacaoOrdenadosNomeAscendente();

	List<Formacao> recuperarFormacaoOrdenadosNomeDescendente();

}
