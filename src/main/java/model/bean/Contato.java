package model.bean;

public class Contato {

	private long idContato;
	private String telefoneContato;
	private String celularContato;
	private String facebookContato = null;
	private String instagramContato = null;
	private String linkedinContato = null;

	public Contato(String telefoneContato, String celularContato, String facebookContato, String instagramContato,
			String linkedinContato) {
		setTelefoneContato(telefoneContato);
		setCelularContato(celularContato);
		setFacebookContato(facebookContato);
		setInstagramContato(instagramContato);
		setLinkedinContato(linkedinContato);
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public String getCelularContato() {
		return celularContato;
	}

	public void setCelularContato(String celularContato) {
		this.celularContato = celularContato;
	}

	public String getFacebookContato() {
		return facebookContato;
	}

	public void setFacebookContato(String facebookContato) {
		this.facebookContato = facebookContato;
	}

	public String getInstagramContato() {
		return instagramContato;
	}

	public void setInstagramContato(String instagramContato) {
		this.instagramContato = instagramContato;
	}

	public String getLinkedinContato() {
		return linkedinContato;
	}

	public void setLinkedinContato(String linkedinContato) {
		this.linkedinContato = linkedinContato;
	}

	public long getIdContato() {
		return idContato;
	}

}
