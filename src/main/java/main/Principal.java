package main;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import data.dao.CandidatoDAO;
import data.dao.CandidatoDAOImpl;
import data.dao.ContatoDAO;
import data.dao.ContatoDAOImpl;
import data.dao.EnderecoDAO;
import data.dao.RecrutadorDAO;
import data.dao.RecrutadorDAOImpl;
import data.dao.UsuarioDAO;
import data.dao.UsuarioDAOImpl;
import model.bean.Candidato;
import model.bean.Contato;
import model.bean.Endereco;
import model.bean.Recrutador;
import model.bean.TipoGenero;
import model.bean.TipoMenuInicio;
import model.bean.TipoMenuUsuario;
import model.bean.Usuario;

public class Principal {

	UsuarioDAO usuarioDAO = null;
	ContatoDAO contatoDAO = null;
	RecrutadorDAO recrutadorDAO = null;
	CandidatoDAO candidatoDAO = null;
	EnderecoDAO enderecoDAO = null;

	Scanner leitor = null;

	public static void main(String[] args) {

		new Principal();
	}

	Principal() {

		String status = "";

		menuInicio();

		usuarioDAO = new UsuarioDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		recrutadorDAO = new RecrutadorDAOImpl(usuarioDAO);
		candidatoDAO = new CandidatoDAOImpl(usuarioDAO);

		leitor = new Scanner(System.in);

		TipoMenuInicio menuInicio = null;
		TipoMenuUsuario menuUsuario = null;

		do {

			try {
				menuInicio = TipoMenuInicio.values()[Integer.parseInt(leitor.next()) - 1];

				switch (menuInicio) {

				case CADASTRAR:

					menuUsuario();

					menuUsuario = TipoMenuUsuario.values()[Integer.parseInt(leitor.next()) - 1];

					if (menuUsuario == TipoMenuUsuario.CANDIDATO)
						cadastrarCandidato();
					else
						cadastrarRecrutador();

					break;

				case LOGAR:

					menuUsuario();

					loginUsuario();

					menuUsuario = TipoMenuUsuario.values()[Integer.parseInt(leitor.next()) - 1];

					menuInicio = TipoMenuInicio.SAIR;

					status = "passou";
					break;

				default:
					break;

				}

			} catch (Exception e) {

				System.out.println("Opção inválida!");

			}

		} while (menuInicio != TipoMenuInicio.SAIR);

		while (status == "passou") {
		}

		leitor.close();
	}

	public void menuInicio() {

		System.out.println("Olá, obrigado por usar nosso sistema!");
		System.out.println("=====================================");
		System.out.println();
		System.out.println("Qual opção deseja inciar?");
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Logar Usuário");
		System.out.println("3 - Sair do Sistema");

	}

	public void menuUsuario() {

		System.out.println();
		System.out.println("Qual usuário?");
		System.out.println();
		System.out.println("1 - Candidato");
		System.out.println("2 - Recrutador");

	}

	public void loginUsuario() {

		System.out.println();

		System.out.println("Informe o e-mail para login: ");
		String email = leitor.next();

		System.out.println("Informe a senha para o login: ");
		String senha = leitor.next();

		long idUsuario = usuarioDAO.recuperarLoginUsuario(email, senha);
	}

	public Usuario lerDadosUsuario() {

		System.out.println();

		System.out.println("Informe o nome do usuário: ");
		String nome = leitor.next();

		System.out.println("Informe o sobrenome do usuário: ");
		String sobrenome = leitor.next();

		System.out.println("Informe o genero do usuário: ");
		System.out.println("1 - Masculino");
		System.out.println("2 - Feminino");
		System.out.println("3 - Outro");

		TipoGenero genero = null;

		do {

			try {

				genero = TipoGenero.values()[Integer.parseInt(leitor.next()) - 1];

			} catch (Exception e) {

				System.out.println("Opção inválida!");

			}
		} while (genero != TipoGenero.FEMININO && genero != TipoGenero.MASCULINO && genero != TipoGenero.OUTRO);

		cadastrarContato();

		System.out.println("Informe a senha do usuário: ");
		String senha = leitor.next();

		return new Usuario(nome, sobrenome, senha, genero);

	}

	public void cadastrarContato() {

		System.out.println("Informe o número do celular do usuário: ");
		String celular = leitor.next();

		System.out.println("Informe o e-mail do usuário: ");
		String email = leitor.next();

		contatoDAO.inserirContato(new Contato(celular, email));

	}

	public void cadastrarEndereço() {

		System.out.println();

		System.out.println("Agora vamos cadastrar seu endereço!");

		System.out.println("Informe a rua: ");
		String rua = leitor.next();

		System.out.println("Informe o bairro: ");
		String bairro = leitor.next();

		System.out.println("Informe o número: ");
		String numero = leitor.next();

		System.out.println("Informe o cep: ");
		String cep = leitor.next();

		System.out.println("Informe a cidade: ");
		String cidade = leitor.next();

		System.out.println("Informe o estado: ");
		String estado = leitor.next();

		System.out.println("Informe a referência: ");
		String referencia = leitor.next();

		enderecoDAO.inserirEndereco(new Endereco(rua, bairro, numero, cep, cidade, estado, referencia));
		System.out.println("Endereço salvo com sucesso.\n");

	}

	public void cadastrarCandidato() {

		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		Usuario usuario = lerDadosUsuario();

		System.out.println("Informe a da de nascimento: ");
		System.out.println("YYYY-MM-DD");

		String dataNascimentoString = leitor.next();

		try {

			Date dataNascimento = formato.parse(dataNascimentoString);

			candidatoDAO.inserirCandidato(new Candidato(usuario.getNome(), usuario.getSobrenome(), usuario.getSenha(),
					usuario.getGenero(), dataNascimento));
		} catch (Exception e) {

		}

	}

	public void cadastrarRecrutador() {

		Usuario usuario = lerDadosUsuario();

		System.out.println("Informe o nome da empresa: ");
		String empresa = leitor.next();

		System.out.println("Informa a área de atuação: ");
		String atuacao = leitor.next();

		recrutadorDAO.inserirRecrutador(new Recrutador(usuario.getNome(), usuario.getSobrenome(), usuario.getSenha(),
				usuario.getGenero(), empresa, atuacao));

	}

}
