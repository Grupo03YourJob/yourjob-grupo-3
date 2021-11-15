package model.bean;

public class Experiencia {

	private long idExperiencia;
	private String ultimaEmpresa;
	private String cargoExercido;
	private String dataInicial;
	private String dataFinal;

	public Experiencia(String ultimaEmpresa, String cargoExercido, String dataInicial, String dataFinal) {
		setUltimaEmpresa(ultimaEmpresa);
		setCargoExercido(cargoExercido);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);

	}

	public String getUltimaEmpresa() {
		return ultimaEmpresa;
	}

	public void setUltimaEmpresa(String ultimaEmpresa) {
		this.ultimaEmpresa = ultimaEmpresa;
	}

	public String getCargoExercido() {
		return cargoExercido;
	}

	public void setCargoExercido(String cargoExercido) {
		this.cargoExercido = cargoExercido;
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

	public long getIdExperiencia() {
		return idExperiencia;
	}

}
