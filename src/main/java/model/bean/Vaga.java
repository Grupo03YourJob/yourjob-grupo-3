package model.bean;

public class Vaga {

	private long idVaga;
	private String nome;
	private String atribuicao;
	private String turno;
	private String salario;
	private String requisito;

	public Vaga(String nome, String atribuicao, String turno, String salario, String requisito) {
		setNome(nome);
		setAtribuicao(atribuicao);
		setTurno(turno);
		setSalario(salario);
		setRequisito(requisito);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtribuicao() {
		return atribuicao;
	}

	public void setAtribuicao(String atribuicao) {
		this.atribuicao = atribuicao;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public long getIdVaga() {
		return idVaga;
	}

}
