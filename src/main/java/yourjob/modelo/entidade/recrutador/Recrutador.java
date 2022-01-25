package yourjob.modelo.entidade.recrutador;

import yourjob.modelo.entidade.usuario.Usuario;
import yourjob.modelo.enumeracao.TipoGenero;

public class Recrutador extends Usuario {

	private long id;
	private String empresa;
	private String atuacao;
	private long fkUsuario;

	public Recrutador(String nome, String sobrenome, String senha, TipoGenero genero, String empresa, String atuacao) {
		super(nome, sobrenome, senha, genero);
		setEmpresa(empresa);
		setAtuacao(atuacao);
	}

	public Recrutador(long id, String empresa, String atuacao, long fkUsuario) {
		setId(id);
		setEmpresa(empresa);
		setAtuacao(atuacao);
		setFkUsuario(fkUsuario);
	}

	public Recrutador(String empresa, String atuacao) {
		setEmpresa(empresa);
		setAtuacao(atuacao);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(long fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

}
