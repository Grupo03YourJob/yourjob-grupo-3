package data.dao;

import java.sql.Date;
import java.util.List;

import model.bean.Candidato;

public interface CandidatoDAO {

	void inserirCandidato(Candidato candidato);

	void deletarCandidato(Candidato candidato);

	void atualizarDataNascimentoCandidato(Candidato candidato, Date novoDataNascimento);

	List<Candidato> recuperarCandidatos();

	List<Candidato> recuperarCandidatosOrdenadosDataNascimentoAscendente();

	List<Candidato> recuperarCandidatosOrdenadosDataNascimentoDescendente();

}