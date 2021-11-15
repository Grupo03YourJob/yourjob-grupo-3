package model.bean;

public class Recrutador {

	private long idRecrutador;
	private String nomeEmpresa;
	private String areaAtuacao;
	private Vaga vaga;

	public Recrutador(String nomeEmpresa, String areaAtuacao, Vaga vaga) {
		setNomeEmpresa(nomeEmpresa);
		setAreaAtuacao(areaAtuacao);
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

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public long getIdRecrutador() {
		return idRecrutador;
	}

}
