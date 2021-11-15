package model.bean;

public class Candidato {

	private int idCandidato;
	private String nome;
	private String sobrenome;
	private boolean genero;
	private String dataNascimento;
	private Contato contato;
	private Curriculo curriculo;
	private Endereco endereco;
	private Vaga vaga;

	public Candidato(String nome, String sobrenome, boolean genero, String dataNascimento, Contato contato,
			Curriculo curriculo, Endereco endereco, Vaga vaga) {
		setNome(nome);
		setSobrenome(sobrenome);
		setGenero(genero);
		setDataNascimento(dataNascimento);
		setContato(contato);
		setCurriculo(curriculo);
		setEndereco(endereco);
		setVaga(vaga);
	}

	public int getIdCandidato() {
		return idCandidato;
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

}
