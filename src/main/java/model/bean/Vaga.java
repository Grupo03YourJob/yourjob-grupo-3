package model.bean;

public class Vaga {

	private long idVaga;
	private String nomeVaga;
	private String atividadeVaga;
	private String turnoVaga;
	private String salarioVaga;
	private String requisitoVaga;

	public Vaga(String nomeVaga, String atribuicaoVaga, String turnoVaga, String salarioVaga, String requisitoVaga) {
		setNomeVaga(nomeVaga);
		setAtividadeVaga(atribuicaoVaga);
		setTurnoVaga(turnoVaga);
		setSalarioVaga(salarioVaga);
		setRequisitoVaga(requisitoVaga);
	}

	public String getNomeVaga() {
		return nomeVaga;
	}

	public void setNomeVaga(String nomeVaga) {
		this.nomeVaga = nomeVaga;
	}

	public String getAtividadeVaga() {
		return atividadeVaga;
	}

	public void setAtividadeVaga(String atividadeVaga) {
		this.atividadeVaga = atividadeVaga;
	}

	public String getTurnoVaga() {
		return turnoVaga;
	}

	public void setTurnoVaga(String turnoVaga) {
		this.turnoVaga = turnoVaga;
	}

	public String getSalarioVaga() {
		return salarioVaga;
	}

	public void setSalarioVaga(String salarioVaga) {
		this.salarioVaga = salarioVaga;
	}

	public String getRequisitoVaga() {
		return requisitoVaga;
	}

	public void setRequisitoVaga(String requisitoVaga) {
		this.requisitoVaga = requisitoVaga;
	}

	public long getIdVaga() {
		return idVaga;
	}

}
