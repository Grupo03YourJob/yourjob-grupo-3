package model.bean;

public class Endereco {

	private long id;
	private String rua;
	private String bairro;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String referencia;

	public Endereco(String rua, String bairro, String numero, String cep, String cidade, String estado,
			String referencia) {
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
	}

	public Endereco(long id, String rua, String bairro, String numero, String cep, String cidade, String estado,
			String referencia) {
		setId(id);
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setReferencia(referencia);
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
