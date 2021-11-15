package model.bean;

public class Recrutador {

	private String nomeEmpresa;
	private String areaAtuacao;

	public Recrutador(String nomeEmpresa, String areaAtuacao) {
		setNomeEmpresa(nomeEmpresa);
		setAreaAtuacao(areaAtuacao);
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

}
