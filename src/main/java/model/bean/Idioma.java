package model.bean;

import model.util.TipoNivel;

public class Idioma {

	private long id;
	private String nome;
	private TipoNivel nivel;

	public Idioma(String nome, TipoNivel nivel) {
		setNome(nome);
		setNivel(nivel);
	}

	public Idioma(long id, String nome, TipoNivel nivel) {
		setId(id);
		setNome(nome);
		setNivel(nivel);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoNivel getNivel() {
		return nivel;
	}

	public void setNivel(TipoNivel nivel) {
		this.nivel = nivel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
