package yourjob.modelo.entidade.usuario;

import yourjob.modelo.entidade.contato.Contato;
import yourjob.modelo.entidade.endereco.Endereco;
import yourjob.modelo.enumeracao.TipoGenero;

public abstract class Usuario {

	private long id;
	private String nome;
	private String sobrenome;
	private String senha;
	private Endereco endereco;
	private Contato contato;
	private TipoGenero genero;

	protected Usuario(String nome, String sobrenome, String senha, TipoGenero genero) {
		setNome(nome);
		setSobrenome(sobrenome);
		setSenha(senha);
		setGenero(genero);
	}

	protected Usuario(long id, String nome, String sobrenome, String senha, TipoGenero genero) {
		setId(id);
		setNome(nome);
		setSobrenome(sobrenome);
		setSenha(senha);
		setGenero(genero);
	}

	protected Usuario() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
