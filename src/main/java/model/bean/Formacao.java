package model.bean;

public class Formacao {

	private long idFormacao;
	private String nome;
	private String instituicao;
	private String dataInicial;
	private String dataFinal;

	public Formacao(String nome, String instituicao, String dataInicial, String dataFinal) {
		setNome(nome);
		setInstituicao(instituicao);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public long getIdFormacao() {
		return idFormacao;
	}

}
