package model.bean;


public abstract class Usuario {

	private long idUsuario;
	private String nomeUsuario;
	private String sobrenomeUsuario;
	private String emailUsuario;
	private String senhaUsuario;
	private Endereco endereco;
	private Contato contato;
	

	public Usuario(String nomeUsuario, String sobrenomeUsuario, String emailUsuario, String senhaUsuario, Endereco endereco,
			Contato contato) {

		setNomeUsuario(nomeUsuario);
		setSobrenomeUsuario(sobrenomeUsuario);
		setEmailUsuario(emailUsuario);
		setSenhaUsuario(senhaUsuario);
		setEndereco(endereco);
		setContato(contato);
		
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getSobrenomeUsuario() {
		return sobrenomeUsuario;
	}


	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenomeUsuario = sobrenomeUsuario;
	}


	public String getEmailUsuario() {
		return emailUsuario;
	}


	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}


	public String getSenhaUsuario() {
		return senhaUsuario;
	}


	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
	}


	public long getIdUsuario() {
		return idUsuario;
	}

}
