package model.bean;

public class Recrutador {

	private String nomeEmpresa;
	private String areaAtuacao;
	private Endereco endereco;
	private Vaga vaga;

	public Recrutador(String nomeEmpresa, String areaAtuacao, Endereco endereco, Vaga vaga) {
		setNomeEmpresa(nomeEmpresa);
		setAreaAtuacao(areaAtuacao);
		setEndereco(endereco);
		setVaga(vaga);
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;

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
