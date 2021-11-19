package data.dao;

import java.util.List;

import model.bean.Candidato;

public interface CandidatoDAO {

	void inserirCandidato(Candidato candidato);

	void deletarCandidato(Candidato candidato);

	void atualizarNomeCandidato(Candidato candidato, String novoNome);

	void atualizarSobreNome(Candidato candidado, String sobreNome);

	void atualizarDataNascimento(Candidato candidato, String dataNascimento);

	void atualizarEmailCandidato(Candidato candidato, String novoEmail);

	void atualizarEndereçoCandidato(Candidato candidato, String novoEndereço);

	void atualizarContatoCandidato(Candidato candidato, String novoContato);

	void atualizarCurriculoCandidato(Candidato candidato, String novoCurriculo);

	void atualizarVagaCandidato(Candidato candidato, String novaVaga);

	void atualizarSenhaCandidato(Candidato candidato, String novaSenha);

	List<Candidato> recuperarCandidato();

	List<Candidato> recuperarCandidatoOrdenadosNomeAscendente();

	List<Candidato> recuperarCandidatoOrdenadosNomeDescendente();

	List<Candidato> recuperarCandidatoOrdenadosSobreNomeAscendente();

	List<Candidato> recuperarCandidatoOrdenadosSobreNomeDescendente();

	List<Candidato> recuperarCandidatoOrdenadosDataNascimentoAscendente();

	List<Candidato> recuperarCandidatoOrdenadosDataNascimentoDescendente();

	List<Candidato> recuperarCandidatoOrdenadosEmailAscendente();

	List<Candidato> recuperarCandidatoOrdenadosEmailDescendente();

	List<Candidato> recuperarCandidatoOrdenadosEndereçoAscendente();

	List<Candidato> recuperarCandidatoOrdenadosEndereçoDescendente();

	List<Candidato> recuperarCandidatoOrdenadosContatoAscendente();

	List<Candidato> recuperarCandidatoOrdenadosContatoDescendente();

	List<Candidato> recuperarCandidatoOrdenadosCurriculoAscendente();

	List<Candidato> recuperarCandidatoOrdenadosCurriculoDescendente();

	List<Candidato> recuperarCandidatoOrdenadosVagaAscendente();

	List<Candidato> recuperarCandidatoOrdenadosVagaDescendente();

	List<Candidato> recuperarCandidatoOrdenadosSenhaAscendente();

	List<Candidato> recuperarCandidatoOrdenadosSenhaDescendente();

}