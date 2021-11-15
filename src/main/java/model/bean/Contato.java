package model.bean;

public class Contato {

	private String email;
	private String telefone;
	private String celular;
	private String facebook = null;
	private String instagram = null;
	private String linkedin = null;

	public Contato(String email, String telefone, String celular, String facebook, String instagram, String linkedin) {
		setEmail(email);
		setTelefone(telefone);
		setCelular(celular);
		setFacebook(facebook);
		setInstagram(instagram);
		setLinkedin(linkedin);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		if (facebook == null) {
			return;
		}
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		if (instagram == null) {
			return;
		}
		this.instagram = instagram;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		if (linkedin == null) {
			return;
		}
		this.linkedin = linkedin;
	}

}
