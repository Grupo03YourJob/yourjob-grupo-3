package yourjob.modelo.dao.contato;

import java.util.List;

import yourjob.modelo.entidade.contato.Contato;

public interface ContatoDAO {

	Contato inserirContato(Contato contato);

	void deletarContato(Contato contato);

	void atualizarTelefoneContato(Contato contato, String novoTelefone);

	void atualizarCelularContato(Contato contato, String novoCelular);

	void atualizarEmailContato(Contato contato, String novoEmail);

	void atualizarFacebookContato(Contato contato, String novoFacebook);

	void atualizarInstagramContato(Contato contato, String novoInstagram);

	void atualizarLinkedinContato(Contato contato, String novoLinkedin);

	List<Contato> recuperarContatos();

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
