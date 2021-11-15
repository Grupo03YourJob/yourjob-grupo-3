package model.bean;

public class Contato {

	private long idContato;
	private String telefone;
	private String celular;
	private String facebook = null;
	private String instagram = null;
	private String linkedin = null;

	public Contato(String telefone, String celular, String facebook, String instagram, String linkedin) {
		setTelefone(telefone);
		setCelular(celular);
		setFacebook(facebook);
		setInstagram(instagram);
		setLinkedin(linkedin);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public long getIdContato() {
		return idContato;
	}

}
