package model.bean;

public class Experiencia {

	private long idExperiencia;
	private String empresaExperiencia;
	private String cargoExercidoExperiencia;
	private String dataInicialExperiencia;
	private String dataFinalExperiencia;

	public Experiencia(String empresaExperiencia, String cargoExercidoExperiencia, String dataInicialExperiencia,
			String dataFinalExperiencia) {
		setEmpresaExperiencia(empresaExperiencia);
		setCargoExercidoExperiencia(cargoExercidoExperiencia);
		setDataInicialExperiencia(dataInicialExperiencia);
		setDataFinalExperiencia(dataFinalExperiencia);

	}

	public String getEmpresaExperiencia() {
		return empresaExperiencia;
	}

	public void setEmpresaExperiencia(String empresaExperiencia) {
		this.empresaExperiencia = empresaExperiencia;
	}

	public String getCargoExercidoExperiencia() {
		return cargoExercidoExperiencia;
	}

	public void setCargoExercidoExperiencia(String cargoExercidoExperiencia) {
		this.cargoExercidoExperiencia = cargoExercidoExperiencia;
	}

	public String getDataInicialExperiencia() {
		return dataInicialExperiencia;
	}

	public void setDataInicialExperiencia(String dataInicialExperiencia) {
		this.dataInicialExperiencia = dataInicialExperiencia;
	}

	public String getDataFinalExperiencia() {
		return dataFinalExperiencia;
	}

	public void setDataFinalExperiencia(String dataFinalExperiencia) {
		this.dataFinalExperiencia = dataFinalExperiencia;
	}

	public long getIdExperiencia() {
		return idExperiencia;
	}

}
