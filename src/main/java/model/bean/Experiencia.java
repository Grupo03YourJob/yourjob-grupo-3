package model.bean;

public class Experiencia {

	private int idExperiencia;
	private String ultimaEmpresa;
	private String dataInicial;
	private String dataFinal;
	private String cargoExercido;

	public Experiencia(String ultimaEmpresa, String dataInicial, String dataFinal, String cargoExercido) {
		setUltimaEmpresa(ultimaEmpresa);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setCargoExercido(cargoExercido);
	}

	public int getIdExperiencia() {
		return idExperiencia;
	}

	public String getUltimaEmpresa() {
		return ultimaEmpresa;
	}

	public void setUltimaEmpresa(String ultimaEmpresa) {
		this.ultimaEmpresa = ultimaEmpresa;
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

	public String getCargoExercido() {
		return cargoExercido;
	}

	public void setCargoExercido(String cargoExercido) {
		this.cargoExercido = cargoExercido;
	}

}
