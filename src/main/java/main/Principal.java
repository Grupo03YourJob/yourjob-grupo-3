package main;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int opcaoUsuario;

		Scanner leitor = new Scanner(System.in);

		do {
			menuUsuario();
			opcaoUsuario = leitor.nextInt();

			if (opcaoUsuario > 2 || opcaoUsuario < 0) {
				limparTela();
				System.out.println("Opção inválida!!");
				System.out.println();
			}

		} while (opcaoUsuario > 2 || opcaoUsuario < 0);

		leitor.close();
	}

	public static void limparTela() {
		for (int i = 0; i < 100; i++) {
			System.out.println();
		}
	}

	public static void menuUsuario() {

		System.out.println("Qual usuário deseja iniciar?");
		System.out.println();
		System.out.println("1 - Candidato");
		System.out.println("2 - Recrutador");

	}

	public static void menuCandidato() {

		System.out.println("");
	}

}
