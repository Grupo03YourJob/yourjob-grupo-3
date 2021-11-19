package data.dao;

import java.util.List;

import model.bean.Contato;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void deletarContato(Contato contato);

	void atualizarNomeContato(Contato contato, String novoNome);

	void atualizarTelefone(Contato contato, String telefone);

	void atualizarCelular(Contato contato, String Celula);

	void atualizarFacebook(Contato contato, String facebook);

	void atualizarInstagran(Contato contato, String instagran);

	void atualizarLinkedin(Contato contato, String linkedin);

	List<Contato> recuperarContato();

	List<Contato> recuperarContatoOrdenadosNomeAscendente();

	List<Contato> recuperarContatoOrdenadosNomeDescendente();

	List<Contato> recuperarContatoOrdenadosTelefoneAscendente();

	List<Contato> recuperarContatoOrdenadosTelefoneDescendente();

	List<Contato> recuperarContatoOrdenadosCelularAscendente();

	List<Contato> recuperarContatoOrdenadosCelularDescendente();

	List<Contato> recuperarContatoOrdenadosFacebookAscendente();

	List<Contato> recuperarContatoOrdenadosFacebookDescendente();

	List<Contato> recuperarContatoOrdenadosInstagranAscendente();

	List<Contato> recuperarContatoOrdenadosInstagranDescendente();

	List<Contato> recuperarContatoOrdenadosLinkedinAscendente();

	List<Contato> recuperarContatoOrdenadosLinkedinDescendente();

}
