package model.bean;

public class Vaga {

	private String nome;
	private String descricao;

	public Vaga(String nome, String descricao) {
		setNome(nome);
		setDescricao(descricao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
