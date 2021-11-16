package model.bean;

import java.util.Date;

public class Experiencia {

	private long idExperiencia;
	private String empresaExperiencia;
	private String cargoExercidoExperiencia;
	private Date dataInicialExperiencia;
	private Date dataFinalExperiencia;

	public Experiencia(String empresaExperiencia, String cargoExercidoExperiencia, Date dataInicialExperiencia,
			Date dataFinalExperiencia) {
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

	public Date getDataInicialExperiencia() {
		return dataInicialExperiencia;
	}

	public void setDataInicialExperiencia(Date dataInicialExperiencia) {
		this.dataInicialExperiencia = dataInicialExperiencia;
	}

	public Date getDataFinalExperiencia() {
		return dataFinalExperiencia;
	}

	public void setDataFinalExperiencia(Date dataFinalExperiencia) {
		this.dataFinalExperiencia = dataFinalExperiencia;
	}

	public long getIdExperiencia() {
		return idExperiencia;
	}

}
