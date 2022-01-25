package yourjob.modelo.entidade.formacao;

import java.util.Date;

public class Formacao {

	private long id;
	private String nome;
	private String instituicao;
	private Date dataInicial;
	private Date dataFinal;

	public Formacao(String nome, String instituicao, Date dataInicial, Date dataFinal) {
		setNome(nome);
		setInstituicao(instituicao);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
	}

	public Formacao(long id, String nome, String instituicao, Date dataInicial, Date dataFinal) {
		setId(id);
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

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
