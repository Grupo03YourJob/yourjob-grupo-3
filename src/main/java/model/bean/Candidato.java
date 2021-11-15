package model.bean;

public class Candidato {

	private String nome;
	private String sobrenome;
	private boolean genero;
	private String dataNascimento;

	public Candidato(String nome, String sobrenome, boolean genero, String dataNascimento) {
		setNome(nome);
		setSobrenome(sobrenome);
		setGenero(genero);
		setDataNascimento(dataNascimento);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
