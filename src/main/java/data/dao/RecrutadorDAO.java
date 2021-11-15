package data.dao;

import java.util.ArrayList;
import java.util.List;

import model.bean.Recrutador;

public class RecrutadorDAO {

	private static List<Recrutador> recrutadors = new ArrayList<Recrutador>();

	public void criarRecrutador(Recrutador recrutador) throws Exception {
		for (Recrutador recrutadorLista : recrutadors) {
			if (recrutador.getIdRecrutador() == recrutadorLista.getIdRecrutador()) {
				throw new Exception("Recruiter not created!");
			}
		}

		recrutadors.add(recrutador);
	}

	public Recrutador buscarRecrutador(long idRecrutador) throws Exception {
		for (Recrutador recrutadorLista : recrutadors) {
			if (recrutadorLista.getIdRecrutador() == idRecrutador) {
				return recrutadorLista;
			}
		}
		throw new Exception("Recruiter not found!");
	}

	public void editarRecrutador(Recrutador recrutadorNovo) throws Exception {
		for (int i = 0; i < recrutadors.size(); i++) {
			Recrutador recrutadorAntigo = recrutadors.get(i);
			if (recrutadorAntigo.getIdRecrutador() == recrutadorNovo.getIdRecrutador()) {
				recrutadors.add(i, recrutadorAntigo);
				return;
			}
		}
		throw new Exception("Recruiter not updated!");
	}

	public void excluirCandidato(Recrutador recrutador) {
		recrutadors.remove(recrutador);
	}

}
