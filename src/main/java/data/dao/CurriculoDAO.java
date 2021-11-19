package data.dao;

import java.util.List;

import model.bean.Curriculo;

public interface CurriculoDAO {

	void inserirCurriculo(Curriculo curriculo);

	void deletarCurriculo(Curriculo curriculo);

	void atualizarNomeCurriculo(Curriculo curriculo, String novoNome);

	void atualizarObjetivoCurriculo(Curriculo curriculo, String objetivo);

	void atualizarHabilidadeCurriculo(Curriculo curriculo, String habilidade);

	void atualizarFormacao(Curriculo curriculo, String formação);

	void atualizarExperiencia(Curriculo curriculo, String Experiencia);

	void atualizarIdiomaCurriculo(Curriculo Curriculo, String novoIdioma);

	List<Curriculo> recuperarCurriculo();

	List<Curriculo> recuperarCurriculoOrdenadosNomeAscendente();

	List<Curriculo> recuperarCurriculoOrdenadosNomeDescendente();

	List<Curriculo> recuperarCurriculoOrdenadosObjetivoAscendente();

	List<Curriculo> recuperarCurriculoOrdenadosObjetivoDescendente();

	List<Curriculo> recuperarCurriculoOrdenadosHabilidadeAscendente();

	List<Curriculo> recuperarCurriculoOrdenadosHabilidadeDescendente();

	List<Curriculo> recuperarCurriculoOrdenadosFormacaoAscendente();

	List<Curriculo> recuperarCurriculoOrdenadosFormacaoDescendente();

	List<Curriculo> recuperarCurriculoOrdenadosExperienciaAscendente();

	List<Curriculo> recuperarCurriculoOrdenadosExperienciaDescendente();

	List<Curriculo> recuperarCurriculoOrdenadosIdiomaAscendente();

	List<Curriculo> recuperarCurriculoOrdenadosIdiomaDescendente();

}