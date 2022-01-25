package yourjob.modelo.entidade.candidato;

import java.util.Date;

import yourjob.modelo.entidade.usuario.Usuario;
import yourjob.modelo.enumeracao.TipoGenero;

public class Candidato extends Usuario {

	private long id;
	private Date dataNascimento;

	public Candidato(String nome, String sobrenome, String senha, TipoGenero genero, Date dataNascimento) {
		super(nome, sobrenome, senha, genero);
		setDataNascimento(dataNascimento);
	}

	public Candidato(long Id, Date dataNascimento) {
		setId(id);
		setDataNascimento(dataNascimento);
	}

	public Candidato(Date dataNascimento) {
		setDataNascimento(dataNascimento);
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

}
