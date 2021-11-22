package model.bean;

import java.sql.Date;

public class Experiencia {

	private long id;
	private String empresa;
	private String cargoExercido;
	private Date dataInicial;
	private Date dataFinal;

	public Experiencia(String empresa, String cargoExercido, Date dataInicial, Date dataFinal) {
		setEmpresa(empresa);
		setCargoExercido(cargoExercido);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
	}

	public Experiencia(long id, String empresa, String cargoExercido, Date dataInicial, Date dataFinal) {
		setId(id);
		setEmpresa(empresa);
		setCargoExercido(cargoExercido);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargoExercido() {
		return cargoExercido;
	}

	public void setCargoExercido(String cargoExercido) {
		this.cargoExercido = cargoExercido;
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
