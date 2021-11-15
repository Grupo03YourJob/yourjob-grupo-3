package model.bean;

import java.util.List;

public class Curriculo {

	private long idCurriculo;
	private String objetivoCurriculo;
	private String habilidadeCurriculo;

	private List<Formacao> formacoes;
	private List<Experiencia> experiencias;
	private List<Idioma> idiomas;

	public Curriculo(String objetivoCurriculo, String habilidadeCurriculo, List<Formacao> formacoes,
			List<Experiencia> experiencias, List<Idioma> idiomas) {
		setObjetivoCurriculo(objetivoCurriculo);
		setHabilidadeCurriculo(habilidadeCurriculo);
		setFormacoes(formacoes);
		setExperiencias(experiencias);
		setIdiomas(idiomas);
	}

	public List<Formacao> getFormacoes() {
		return formacoes;
	}

	public void setFormacoes(List<Formacao> formacoes) {
		this.formacoes = formacoes;
	}

	public List<Experiencia> getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
	}

	public List<Idioma> getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}

	public String getObjetivoCurriculo() {
		return objetivoCurriculo;
	}

	public void setObjetivoCurriculo(String objetivoCurriculo) {
		this.objetivoCurriculo = objetivoCurriculo;
	}

	public String getHabilidadeCurriculo() {
		return habilidadeCurriculo;
	}

	public void setHabilidadeCurriculo(String habilidadeCurriculo) {
		this.habilidadeCurriculo = habilidadeCurriculo;
	}

	public long getIdCurriculo() {
		return idCurriculo;
	}

}
