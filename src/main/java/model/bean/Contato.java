package model.bean;

public class Contato {

	private long id;
	private String telefone;
	private String celular;
	private String email;
	private String facebook = null;
	private String instagram = null;
	private String linkedin = null;

	public Contato(String telefone, String celular, String email, String facebook, String instagram, String linkedin) {
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
		setFacebook(facebook);
		setInstagram(instagram);
		setLinkedin(linkedin);
	}

	public Contato(long id, String telefone, String celular, String email, String facebook, String instagram,
			String linkedin) {
		setId(id);
		setTelefone(telefone);
		setCelular(celular);
		setEmail(email);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
