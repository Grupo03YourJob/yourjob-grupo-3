package yourjob;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import yourjob.casodeuso.atualizarendereco.AtualizarEnderecoCasoDeUso;
import yourjob.casodeuso.cadastrarcandidato.CadastrarCandidatoCasoDeUso;
import yourjob.casodeuso.cadastrarcontato.CadastrarContatoCasoDeUso;
import yourjob.casodeuso.cadastrarendereco.CadastrarEnderecoCasoDeUso;
import yourjob.casodeuso.cadastrarexperiencia.CadastrarExperienciaCasoDeUso;
import yourjob.casodeuso.cadastrarformacao.CadastrarFormacaoCasoDeUso;
import yourjob.casodeuso.cadastraridioma.CadastrarIdiomaCasoDeUso;
import yourjob.casodeuso.cadastrarrecrutador.CadastrarRecrutadorCasoDeUso;
import yourjob.casodeuso.cadastrarvaga.CadastrarVagaCasoDeUso;
import yourjob.modelo.dao.candidato.CandidatoDAO;
import yourjob.modelo.dao.candidato.CandidatoDAOImpl;
import yourjob.modelo.dao.contato.ContatoDAO;
import yourjob.modelo.dao.contato.ContatoDAOImpl;
import yourjob.modelo.dao.endereco.EnderecoDAO;
import yourjob.modelo.dao.endereco.EnderecoDAOImpl;
import yourjob.modelo.dao.experiencia.ExperienciaDAO;
import yourjob.modelo.dao.experiencia.ExperienciaDAOImpl;
import yourjob.modelo.dao.formacao.FormacaoDAO;
import yourjob.modelo.dao.formacao.FormacaoDAOImpl;
import yourjob.modelo.dao.idioma.IdiomaDAO;
import yourjob.modelo.dao.idioma.IdiomaDAOImpl;
import yourjob.modelo.dao.recrutador.RecrutadorDAO;
import yourjob.modelo.dao.recrutador.RecrutadorDAOImpl;
import yourjob.modelo.dao.usuario.UsuarioDAO;
import yourjob.modelo.dao.usuario.UsuarioDAOImpl;
import yourjob.modelo.dao.vaga.VagaDAO;
import yourjob.modelo.dao.vaga.VagaDAOImpl;
import yourjob.modelo.entidade.candidato.Candidato;
import yourjob.modelo.entidade.contato.Contato;
import yourjob.modelo.entidade.endereco.Endereco;
import yourjob.modelo.entidade.experiencia.Experiencia;
import yourjob.modelo.entidade.formacao.Formacao;
import yourjob.modelo.entidade.idioma.Idioma;
import yourjob.modelo.entidade.recrutador.Recrutador;
import yourjob.modelo.entidade.vaga.Vaga;
import yourjob.modelo.entidade.usuario.Usuario;
import yourjob.modelo.enumeracao.TipoGenero;
import yourjob.modelo.enumeracao.TipoMenuCandidato;
import yourjob.modelo.enumeracao.TipoMenuEditarCandidato;
import yourjob.modelo.enumeracao.TipoMenuInicio;
import yourjob.modelo.enumeracao.TipoMenuRecrutador;
import yourjob.modelo.enumeracao.TipoMenuUsuario;
import yourjob.modelo.enumeracao.TipoNivel;
import yourjob.modelo.enumeracao.TipoTurno;

public class Principal {

	UsuarioDAO usuarioDAO = null;
	ContatoDAO contatoDAO = null;
	RecrutadorDAO recrutadorDAO = null;
	CandidatoDAO candidatoDAO = null;
	EnderecoDAO enderecoDAO = null;
	FormacaoDAO formacaoDAO = null;
	VagaDAO vagaDAO = null;
	ExperienciaDAO experienciaDAO = null;
	IdiomaDAO idiomaDAO = null;

	Scanner leitor = null;

	public static void main(String[] args) {

		new Principal();
	}

	Principal() {

		usuarioDAO = new UsuarioDAOImpl();
		contatoDAO = new ContatoDAOImpl();
		recrutadorDAO = new RecrutadorDAOImpl(usuarioDAO);
		candidatoDAO = new CandidatoDAOImpl(usuarioDAO);
		enderecoDAO = new EnderecoDAOImpl();
		formacaoDAO = new FormacaoDAOImpl();
		vagaDAO = new VagaDAOImpl();
		experienciaDAO = new ExperienciaDAOImpl();
		idiomaDAO = new IdiomaDAOImpl();
		leitor = new Scanner(System.in);

		TipoMenuInicio menuInicio = null;
		TipoMenuUsuario menuUsuario = null;
		TipoMenuCandidato menuCandidato = null;
		TipoMenuRecrutador menuRecrutador = null;
		TipoMenuEditarCandidato menuEditarCandidato = null;

		String status = "";

		System.out.println("Olá, obrigado por usar nosso sistema!");
		System.out.println("=====================================");

		do {

			try {
				menuInicio();

				menuInicio = TipoMenuInicio.values()[Integer.parseInt(leitor.nextLine()) - 1];

				switch (menuInicio) {

				case CADASTRAR:
					menuUsuario();

					menuUsuario = TipoMenuUsuario.values()[Integer.parseInt(leitor.nextLine()) - 1];

					if (menuUsuario == TipoMenuUsuario.CANDIDATO)
						cadastrarCandidato();
					else
						cadastrarRecrutador();
					break;

				case LOGAR:
					String encontrou = loginUsuario();

					do {

						if (encontrou.equals("Candidato")) {
							menuCandidato();

							menuCandidato = TipoMenuCandidato.values()[Integer.parseInt(leitor.nextLine()) - 1];

						} else if (encontrou.equals("Recrutador")) {
							menuRecrutador();

							menuRecrutador = TipoMenuRecrutador.values()[Integer.parseInt(leitor.nextLine()) - 1];

						} else {
							System.out.println("Usuário não encontrado!");

						}

					} while (menuCandidato != TipoMenuCandidato.SAIRUSUARIO && menuCandidato != null
							|| menuRecrutador != TipoMenuRecrutador.SAIRUSUARIO && menuRecrutador != null);

					status = "passou";

					break;

				default:
					break;

				}

			} catch (Exception e) {
				System.err.println("Opção inválida!");
			}

		} while (menuInicio != TipoMenuInicio.SAIR);

		while (status.equals("passou")) {
		}

		leitor.close();
	}

	public void menuInicio() {
		System.out.println("\nQual opção deseja inciar?");
		System.out.println("1 - Cadastrar Usuário");
		System.out.println("2 - Logar Usuário");
		System.out.println("3 - Sair do Sistema");

	}

	public void menuUsuario() {
		System.out.println("\nQual usuário?\n");
		System.out.println("1 - Candidato");
		System.out.println("2 - Recrutador");

	}

	public void menuCandidato() {
		System.out.println("\nQual opção deseja continuar?\n");
		System.out.println("1 - Mostrar perfil");
		System.out.println("2 - Editar perfil");
		System.out.println("3 - Mostrar currículo");
		System.out.println("4 - Cadastrar currículo");
		System.out.println("5 - Sair do usuário");

	}

	public void menuRecrutador() {
		System.out.println("\nQual opção deseja continuar?\n");
		System.out.println("1 - Mostrar perfil");
		System.out.println("2 - Editar perfil");
		System.out.println("3 - Mostrar vagas");
		System.out.println("4 - Cadastrar vaga");
		System.out.println("5 - Excluir vaga");
		System.out.println("6 - Sair do usuário");

	}

	public void menuEditarCandidato() {
		System.out.println("\nQual opção deseja continuar?\n");
		System.out.println("\nOBS:Quando escolher editar, as informações serão removidas\n");
		System.out.println("1 - Editar Endereço");
		System.out.println("2 - Editar Contato");
		System.out.println("3 - Editar Idioma");
		System.out.println("4 - Editar Formação");
		System.out.println("5 - Editar Experiência");
		System.out.println("6 - Voltar ao menu inicial");

	}

	public void lerDadosUsuario(Usuario usuario) {
		System.out.println("\nInforme o nome do usuário: ");
		String nome = leitor.nextLine();

		System.out.println("\nInforme o sobrenome do usuário: ");
		String sobrenome = leitor.nextLine();

		System.out.println("\nInforme o genero do usuário: ");
		System.out.println("1 - Masculino");
		System.out.println("2 - Feminino");
		System.out.println("3 - Outro");

		TipoGenero genero = null;

		do {

			try {
				genero = TipoGenero.values()[Integer.parseInt(leitor.nextLine()) - 1];

			} catch (Exception e) {
				System.err.println("Opção inválida!");

			}

		} while (genero != TipoGenero.FEMININO && genero != TipoGenero.MASCULINO && genero != TipoGenero.OUTRO);

		Contato contato = cadastrarContato();

		System.out.println("\nVamos terminar de cadastrar seu usuário: ");

		System.out.println("\nInforme a senha do usuário: ");
		String senha = leitor.nextLine();

		Endereco endereco = cadastrarEndereco();

		usuario.setNome(nome);
		usuario.setSobrenome(sobrenome);
		usuario.setSenha(senha);
		usuario.setGenero(genero);
		usuario.setEndereco(endereco);
		usuario.setContato(contato);
	}

	public void lerDadosCurriculo() {
		System.out.println("\nInforme o nome do objetivo: ");
		String nome = leitor.nextLine();

		System.out.println("\nInforme o nome da habilidade: ");
		String habilidade = leitor.nextLine();

	}

	public String loginUsuario() {
		try {
			System.out.println("\nInforme o e-mail para login: ");
			String email = leitor.nextLine();

			System.out.println("\nInforme a senha para o login: ");
			String senha = leitor.nextLine();

			long idUsuario = usuarioDAO.recuperarLoginUsuario(email, senha);

			long idCandidato = candidatoDAO.recuperarCandidatoUsuario(idUsuario);

			long idRecrutador = recrutadorDAO.recuperarRecrutadorUsuario(idUsuario);

			if (idCandidato != 0) {
				return "Candidato";

			} else if (idRecrutador != 0) {
				return "Recrutador";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "nada";
	}

	public Contato cadastrarContato() {
		System.out.println("\nAgora vamos cadastrar o seu contato!");

		Contato contato = null;

		CadastrarContatoCasoDeUso cadastrarContatoCasoDeUso = new CadastrarContatoCasoDeUso(contatoDAO);

		do {

			System.out.println("\nInforme o número do celular do usuário: ");
			String celular = leitor.nextLine();

			System.out.println("\nInforme o e-mail do usuário: ");
			String email = leitor.nextLine();

			contato = cadastrarContatoCasoDeUso.cadastrarContato(new Contato(celular, email));

		} while (contato == null);

		return contato;
	}

	public Endereco cadastrarEndereco() {
		System.out.println("\nAgora vamos cadastrar o seu endereço!");

		System.out.println("\nInforme a rua: \n");
		String rua = leitor.nextLine();

		System.out.println("\nInforme o bairro: ");
		String bairro = leitor.nextLine();

		System.out.println("\nInforme o número: ");
		String numero = leitor.nextLine();

		System.out.println("\nInforme o cep: ");
		String cep = leitor.nextLine();

		System.out.println("\nInforme a cidade: ");
		String cidade = leitor.nextLine();

		System.out.println("\nInforme o estado: ");
		String estado = leitor.nextLine();

		System.out.println("\nInforme a referência: ");
		String referencia = leitor.nextLine();

		CadastrarEnderecoCasoDeUso cadastrarEnderecoCasoDeUso = new CadastrarEnderecoCasoDeUso(enderecoDAO);

		return cadastrarEnderecoCasoDeUso
				.cadastrarEndereco(new Endereco(rua, bairro, numero, cep, cidade, estado, referencia));
	}

	public Endereco AtualizarEndereco() {
		System.out.println("\nDigite as informações do endereço!");

		System.out.println("\nInforme a rua: \n");
		String rua = leitor.nextLine();

		System.out.println("\nInforme o bairro: ");
		String bairro = leitor.nextLine();

		System.out.println("\nInforme o número: ");
		String numero = leitor.nextLine();

		System.out.println("\nInforme o cep: ");
		String cep = leitor.nextLine();

		System.out.println("\nInforme a cidade: ");
		String cidade = leitor.nextLine();

		System.out.println("\nInforme o estado: ");
		String estado = leitor.nextLine();

		System.out.println("\nInforme a referência: ");
		String referencia = leitor.nextLine();

		AtualizarEnderecoCasoDeUso atualizarEnderecoCasoDeUso = new AtualizarEnderecoCasoDeUso(enderecoDAO);

		return atualizarEnderecoCasoDeUso
				.atualizarEndereco(new Endereco(rua, bairro, numero, cep, cidade, estado, referencia));
	}

	public Formacao cadastrarFormacao() {
		String validacao = "";

		Formacao formacao = null;

		System.out.println("\nAgora vamos cadastrar a sua formação!");

		do {

			try {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

				System.out.println("\nInforme o nome da formação: ");
				String nome = leitor.nextLine();

				System.out.println("\nInforme o nome da instituição: ");
				String instituicao = leitor.nextLine();

				System.out.println("\nInforme a data inicial da sua formação: ");

				System.out.println("\nInforme o dia: ");
				String diaInicialString = leitor.nextLine();

				System.out.println("\nInforme o mes: ");
				String mesInicialString = leitor.nextLine();

				System.out.println("\nInforme o ano: ");
				String anoInicialString = leitor.nextLine();

				String dataInicialString = (diaInicialString + "-" + mesInicialString + "-" + anoInicialString);

				System.out.println("\nInforme a data final da sua formação: ");

				System.out.println("\nInforme o dia: ");
				String diaFinalString = leitor.nextLine();

				System.out.println("\nInforme o mes: ");
				String mesFinalString = leitor.nextLine();

				System.out.println("\nInforme o ano: ");
				String anoFinalString = leitor.nextLine();

				String dataFinalString = (diaFinalString + "-" + mesFinalString + "-" + anoFinalString);

				Date dataInicial = formato.parse(dataInicialString);
				Date dataFinal = formato.parse(dataFinalString);

				CadastrarFormacaoCasoDeUso cadastrarFormacaoCasoDeUso = new CadastrarFormacaoCasoDeUso(formacaoDAO);

				formacao = new Formacao(nome, instituicao, dataInicial, dataFinal);

				cadastrarFormacaoCasoDeUso.cadastrarFormacao(formacao);

				System.out.println("Deseja cadastrar mais uma formação? [S/N]");
				validacao = leitor.nextLine();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (!validacao.equals("N"));

		return formacao;
	}

	public Experiencia cadastrarExperiencia() {
		String validacao = "";

		Experiencia experiencia = null;

		System.out.println("\nAgora vamos cadastrar a sua experiencia!");

		do {

			try {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

				System.out.println("\nInforme o nome da empresa: ");
				String empresa = leitor.nextLine();

				System.out.println("\nInforme o nome do cargo exercido: ");
				String cargoExercido = leitor.nextLine();

				System.out.println("\nInforme a data inicial da sua experiência: ");

				System.out.println("\nInforme o dia: ");
				String diaInicialString = leitor.nextLine();

				System.out.println("\nInforme o mes: ");
				String mesInicialString = leitor.nextLine();

				System.out.println("\nInforme o ano: ");
				String anoInicialString = leitor.nextLine();

				String dataInicialString = (diaInicialString + "-" + mesInicialString + "-" + anoInicialString);

				System.out.println("\nInforme a data final da sua experiência: ");

				System.out.println("\nInforme o dia: ");
				String diaFinalString = leitor.nextLine();

				System.out.println("\nInforme o mes: ");
				String mesFinalString = leitor.nextLine();

				System.out.println("\nInforme o ano: ");
				String anoFinalString = leitor.nextLine();

				String dataFinalString = (diaFinalString + "-" + mesFinalString + "-" + anoFinalString);

				Date dataInicial = formato.parse(dataInicialString);
				Date dataFinal = formato.parse(dataFinalString);

				CadastrarExperienciaCasoDeUso cadastrarExperienciaCasoDeUso = new CadastrarExperienciaCasoDeUso(
						experienciaDAO);

				experiencia = new Experiencia(empresa, cargoExercido, dataInicial, dataFinal);

				cadastrarExperienciaCasoDeUso.cadastrarExperiencia(experiencia);

				System.out.println("Deseja cadastrar mais uma experiência? [S/N]");
				validacao = leitor.nextLine();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (!validacao.equals("N"));

		return experiencia;
	}

	public Idioma cadastrarIdioma() {
		String validacao = "";

		Idioma idioma = null;

		System.out.println("\nAgora vamos cadastrar o seu idioma!");

		do {

			try {
				System.out.println("\nInforme o nome do idioma: ");
				String nome = leitor.nextLine();

				System.out.println("\nInforme o nível do idioma: ");
				System.out.println("1 - Básico");
				System.out.println("2 - Intermediário");
				System.out.println("3 - Avançado");

				TipoNivel nivel = null;

				do {

					try {
						nivel = TipoNivel.values()[Integer.parseInt(leitor.nextLine()) - 1];

					} catch (Exception e) {
						System.err.println("Opção inválida!");

					}

				} while (nivel != TipoNivel.BASICO && nivel != TipoNivel.INTERMEDIARIO && nivel != TipoNivel.AVANCADO);

				CadastrarIdiomaCasoDeUso cadastrarIdiomaCasoDeUso = new CadastrarIdiomaCasoDeUso(idiomaDAO);

				idioma = new Idioma(nome, nivel);

				cadastrarIdiomaCasoDeUso.cadastrarIdioma(idioma);

			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println("Deseja cadastrar mais uma formação? [S/N]");
			validacao = leitor.nextLine();

		} while (!validacao.equals("N"));

		return idioma;
	}

	public Vaga cadastrarVaga() {
		System.out.println("\nInforme o nome da vaga: ");
		String nome = leitor.nextLine();

		System.out.println("\nInforma a atividade da vaga: ");
		String atividade = leitor.nextLine();

		System.out.println("\nInforma o salário da vaga: ");
		String salario = leitor.nextLine();

		System.out.println("\nInforma os requisitos da vaga: ");
		String requisito = leitor.nextLine();

		System.out.println("\nInforme o turno: ");
		System.out.println("1 - Matutino");
		System.out.println("2 - Vespertino");
		System.out.println("3 - Noturno");

		TipoTurno turno = null;

		do {

			try {
				turno = TipoTurno.values()[Integer.parseInt(leitor.nextLine()) - 1];

			} catch (Exception e) {
				System.out.println("Opção inválida!");
			}
		} while (turno != TipoTurno.MATUTINO && turno != TipoTurno.VESPERTINO && turno != TipoTurno.NOTURNO);

		CadastrarVagaCasoDeUso cadastrarVagaCasoDeUso = new CadastrarVagaCasoDeUso(vagaDAO);

		return cadastrarVagaCasoDeUso.cadastrarVaga(new Vaga(nome, atividade, salario, requisito, turno));
	}

	public Candidato cadastrarCandidato() {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

		System.out.println("\nInforme o dia de nascimento: ");
		String diaNascimento = leitor.nextLine();

		System.out.println("\nInforme o mês de nascimento: ");
		String mesNascimento = leitor.nextLine();

		System.out.println("\nInforme o ano de nascimento: ");
		String anoNascimento = leitor.nextLine();

		String dataNascimentoString = (anoNascimento + "-" + mesNascimento + "-" + diaNascimento);

		CadastrarCandidatoCasoDeUso cadastrarCandidatoCasoDeUso = new CadastrarCandidatoCasoDeUso(candidatoDAO);

		Candidato candidato = null;

		try {
			Date dataNascimento = formato.parse(dataNascimentoString);

			candidato = new Candidato(dataNascimento);

			lerDadosUsuario(candidato);

			cadastrarCandidatoCasoDeUso.cadastrarCandidato(candidato);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return candidato;

	}

	public Recrutador cadastrarRecrutador() {
		System.out.println("\nInforme o nome da empresa: ");
		String empresa = leitor.nextLine();

		System.out.println("\nInforma a área de atuação: ");
		String atuacao = leitor.nextLine();

		CadastrarRecrutadorCasoDeUso cadastrarRecrutadorCasoDeUso = new CadastrarRecrutadorCasoDeUso(recrutadorDAO);

		Recrutador recrutador = new Recrutador(empresa, atuacao);

		lerDadosUsuario(recrutador);

		cadastrarRecrutadorCasoDeUso.cadastrarRecrutador(recrutador);

		return recrutador;
	}
}
