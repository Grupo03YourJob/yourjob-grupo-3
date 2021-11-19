package data.dao;

import java.util.List;

import model.bean.Experiencia;

public interface ExperienciaDAO {

	void inserirExperiencia(Experiencia experiencia);

	void deletarExperiencia(Experiencia experiencia);

	void atualizarEmpresaExperiencia(Experiencia experiencia, String empresa);

	void atualizarCargoExperiencia(Experiencia experiencia, String cargo);

	void atualizarDataInicialExperiencia(Experiencia experiencia, String dataInicial);

	void atualizarDataFinalExperiencia(Experiencia experiencia, String dataFinal);

	List<Experiencia> recuperarExperiencia();

	List<Experiencia> recuperarExperienciaEmpresaAscendente();

	List<Experiencia> recuperarExperienciaEmpresaDescendente();

	List<Experiencia> recuperarExperienciaCargoAscendente();

	List<Experiencia> recuperarExperienciaCargoDescendente();

	List<Experiencia> recuperarExperienciaDataInicialAscendente();

	List<Experiencia> recuperarExperienciaDataInicialDescendente();

	List<Experiencia> recuperarExperienciaDataFinalAscendente();

	List<Experiencia> recuperarExperienciaDataFinalDescendente();

}