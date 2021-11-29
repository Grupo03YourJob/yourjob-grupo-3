package data.dao;

import java.sql.Date;
import java.util.List;

import model.bean.Experiencia;

public interface ExperienciaDAO {

	void inserirExperiencia(Experiencia experiencia);

	void deletarExperiencia(Experiencia candidato);

	void atualizarEmpresaExperiencia(Experiencia experiencia, String novoEmpresa);

	void atualizarCargoExercidoExperiencia(Experiencia experiencia, String novoCargoExercido);

	void atualizarDataInicialExperiencia(Experiencia experiencia, Date novoDataInicial);

	void atualizarDataFinalExperiencia(Experiencia experiencia, Date novoDataFinal);

	List<Experiencia> recuperarExperiencias();

	List<Experiencia> recuperarExperienciasOrdenadosEmpresaAscendente();

	List<Experiencia> recuperarExperienciasOrdenadosEmpresaDescendente();

	List<Experiencia> recuperarExperienciasOrdenadosCargoExercidoAscendente();

	List<Experiencia> recuperarExperienciasOrdenadosCargoExercidoDescendente();

	List<Experiencia> recuperarExperienciasOrdenadosDataInicialAscendente();

	List<Experiencia> recuperarExperienciasOrdenadosDataInicialDescendente();

	List<Experiencia> recuperarExperienciasOrdenadosDataFinalAscendente();

	List<Experiencia> recuperarExperienciasOrdenadosDataFinalDescendente();

}