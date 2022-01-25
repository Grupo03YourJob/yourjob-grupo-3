package yourjob.modelo.dao.curriculo;

import java.util.List;

import yourjob.modelo.entidade.curriculo.Curriculo;

public interface CurriculoDAO {

	void inserirCurriculo(Curriculo curriculo);

	void deletarCurriculo(Curriculo curriculo);

	void atualizarObjetivoCurriculo(Curriculo curriculo, String novoObjetivo);

	void atualizarHabilidadeCurriculo(Curriculo curriculo, String novoHabilidade);

	List<Curriculo> recuperarCurriculos();

	List<Curriculo> recuperarCurriculosOrdenadosObjetivoAscendente();

	List<Curriculo> recuperarCurriculosOrdenadosObjetivoDescendente();

	List<Curriculo> recuperarCurriculosOrdenadosHabilidadeAscendente();

	List<Curriculo> recuperarCurriculosOrdenadosHabilidadeDescendente();

}