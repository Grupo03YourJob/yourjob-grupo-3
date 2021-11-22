package model.bean;

public class Vaga {

	private long id;
	private String nome;
	private String atividade;
	private String salario;
	private String requisito;
	private TipoTurno turno;

	public Vaga(String nome, String atribuicao, String salario, String requisito, TipoTurno turno) {
		setNome(nome);
		setAtividade(atribuicao);
		setSalario(salario);
		setRequisito(requisito);
		setTurno(turno);
	}

	public Vaga(long id, String nome, String atribuicao, String salario, String requisito, TipoTurno turno) {
		setId(id);
		setNome(nome);
		setAtividade(atribuicao);
		setSalario(salario);
		setRequisito(requisito);
		setTurno(turno);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
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

	public TipoTurno getTurno() {
		return turno;
	}

	public void setTurno(TipoTurno turno) {
		this.turno = turno;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
