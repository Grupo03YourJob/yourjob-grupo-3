package data.dao;

import java.util.List;

import model.bean.Contato;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void deletarContato(Contato contato);

	void atualizarTelefoneContato(Contato contato, String novoTelefone);

	void atualizarCelularContato(Contato contato, String novoCelular);

	void atualizarEmailContato(Contato contato, String novoEmail);

	void atualizarFacebookContato(Contato contato, String novoFacebook);

	void atualizarInstagramContato(Contato contato, String novoInstagram);

	void atualizarLinkedinContato(Contato contato, String novoLinkedin);

	List<Contato> recuperarContatos();

	List<Contato> recuperarContatosPorUsuario(String idUsuario);

	List<Contato> recuperarContatosOrdenadosTelefoneAscendente();

	List<Contato> recuperarContatosOrdenadosTelefoneDescendente();

	List<Contato> recuperarContatosOrdenadosCelularAscendente();

	List<Contato> recuperarContatosOrdenadosCelularDescendente();

	List<Contato> recuperarContatosOrdenadosEmailAscendente();

	List<Contato> recuperarContatosOrdenadosEmailDescendente();

	List<Contato> recuperarContatosOrdenadosFacebookAscendente();

	List<Contato> recuperarContatosOrdenadosFacebookDescendente();

	List<Contato> recuperarContatosOrdenadosInstagramAscendente();

	List<Contato> recuperarContatosOrdenadosInstagramDescendente();

	List<Contato> recuperarContatosOrdenadosLinkedinAscendente();

	List<Contato> recuperarContatosOrdenadosLinkedinDescendente();

}
