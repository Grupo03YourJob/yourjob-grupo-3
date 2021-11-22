package data.dao;

import java.sql.Date;
import java.util.List;

import model.bean.Experiencia;

public interface ExperienciaDAO {

	void inserirExperiencia(Experiencia experiencia);

	void deletarExperiencia(Experiencia experiencia);

	void atualizarEmpresaExperiencia(Experiencia experiencia, String novoEmpresa);

	void atualizarCargoExercidoExperiencia(Experiencia experiencia, String CargoExercido);

	void atualizarDataInicalExperiencia(Experiencia experiencia, Date novoDataInical);

	void atualizarDataFinalExperiencia(Experiencia experiencia, Date novoDataFinal);

	List<Experiencia> recuperarExperiencia();

	List<Experiencia> recuperarExperienciaPorCurriculo(String idCurriculo);

	List<Experiencia> recuperarExperienciaEmpresaAscendente();

	List<Experiencia> recuperarExperienciaEmpresaDescendente();

}