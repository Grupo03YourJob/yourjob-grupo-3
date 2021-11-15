package model.bean;

public class Formacao {

	private long idFormacao;
	private String nomeFormacao;
	private String instituicaoFormacao;
	private String dataInicialFormacao;
	private String dataFinalFormacao;

	public Formacao(String nomeFormacao, String instituicaoFormacao, String dataInicialFormacao,
			String dataFinalFormacao) {
		setNomeFormacao(nomeFormacao);
		setInstituicaoFormacao(instituicaoFormacao);
		setDataInicialFormacao(dataInicialFormacao);
		setDataFinalFormacao(dataFinalFormacao);
	}

	public String getNomeFormacao() {
		return nomeFormacao;
	}

	public void setNomeFormacao(String nomeFormacao) {
		this.nomeFormacao = nomeFormacao;
	}

	public String getInstituicaoFormacao() {
		return instituicaoFormacao;
	}

	public void setInstituicaoFormacao(String instituicaoFormacao) {
		this.instituicaoFormacao = instituicaoFormacao;
	}

	public String getDataInicialFormacao() {
		return dataInicialFormacao;
	}

	public void setDataInicialFormacao(String dataInicialFormacao) {
		this.dataInicialFormacao = dataInicialFormacao;
	}

	public String getDataFinalFormacao() {
		return dataFinalFormacao;
	}

	public void setDataFinalFormacao(String dataFinalFormacao) {
		this.dataFinalFormacao = dataFinalFormacao;
	}

	public long getIdFormacao() {
		return idFormacao;
	}

}
