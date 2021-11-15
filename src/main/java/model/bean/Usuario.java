package model.bean;

public class Usuario {

	private String senha;
	private Contato contato;

	public Usuario(String senha, Contato contato) {
		setSenha(senha);
		setContato(contato);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
