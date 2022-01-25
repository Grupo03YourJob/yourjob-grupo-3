package yourjob.modelo.dao.candidato;

import java.sql.Date;
import java.util.List;

import yourjob.modelo.entidade.candidato.Candidato;

public interface CandidatoDAO {

	Candidato inserirCandidato(Candidato candidato);

	void deletarCandidato(Candidato candidato);

	void atualizarDataNascimentoCandidato(Candidato candidato, Date novoDataNascimento);

	List<Candidato> recuperarCandidatos();

	List<Candidato> recuperarCandidatosOrdenadosDataNascimentoAscendente();

	List<Candidato> recuperarCandidatosOrdenadosDataNascimentoDescendente();
	
	long recuperarCandidatoUsuario(long idUsuario);

}