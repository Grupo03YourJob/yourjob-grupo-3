package model.bean;

public class Endereco {

	private long idEndereco;
	private String ruaEndereco;
	private String bairroEndereco;
	private int numeroEndereco;
	private String cepEndereco;
	private String cidadeEndereco;
	private String estadoEndereco;
	private String referenciaEndereco;

	public Endereco(String ruaEndereco, String bairroEndereco, int numeroEndereco, String cepEndereco,
			String cidadeEndereco, String estadoEndereco, String referenciaEndereco) {
		setRuaEndereco(ruaEndereco);
		setBairroEndereco(bairroEndereco);
		setNumeroEndereco(numeroEndereco);
		setCepEndereco(cepEndereco);
		setCidadeEndereco(cidadeEndereco);
		setEstadoEndereco(estadoEndereco);
		setReferenciaEndereco(referenciaEndereco);
	}

	public String getRuaEndereco() {
		return ruaEndereco;
	}

	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}

	public String getBairroEndereco() {
		return bairroEndereco;
	}

	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getCepEndereco() {
		return cepEndereco;
	}

	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}

	public String getCidadeEndereco() {
		return cidadeEndereco;
	}

	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}

	public String getEstadoEndereco() {
		return estadoEndereco;
	}

	public void setEstadoEndereco(String estadoEndereco) {
		this.estadoEndereco = estadoEndereco;
	}

	public String getReferenciaEndereco() {
		return referenciaEndereco;
	}

	public void setReferenciaEndereco(String referenciaEndereco) {
		this.referenciaEndereco = referenciaEndereco;
	}

	public long getIdEndereco() {
		return idEndereco;
	}

}
