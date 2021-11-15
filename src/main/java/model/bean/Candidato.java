package model.bean;

public class Candidato {

	private long idCandidato;
	private String sobrenome;
	private boolean genero;
	private String dataNascimento;
	private Curriculo curriculo;
	private Vaga vaga;

	public Candidato(String sobrenome, boolean genero, String dataNascimento, Curriculo curriculo, Vaga vaga) {
		setSobrenome(sobrenome);
		setGenero(genero);
		setDataNascimento(dataNascimento);
		setCurriculo(curriculo);
		setVaga(vaga);
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

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public long getIdCandidato() {
		return idCandidato;
	}

}
