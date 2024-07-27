//Felipe Maciel Scalco
//RA: 25658388

import java.util.ArrayList;

public class Reuniao extends Evento {
	private String tema;
	private ArrayList<String> participantes;

	public Reuniao() {
		tema = "";
		participantes = new ArrayList<String>();
	}

	// Polimorfismo por Sobrecarga
	public Reuniao(String tema, ArrayList<String> participantes) {
		this.tema = tema;
		this.participantes = participantes;
	}

	public String getTema() {
		return tema;
	}

	public ArrayList<String> getParticipantes() {
		return participantes;
	}

	public void setTema(String tema) throws TextoSemNadaException {
		if (tema.isBlank() || tema.isEmpty()) {
			throw new TextoSemNadaException();
		}
		this.tema = tema;
	}

	public void setParticipantes(ArrayList<String> participantes) {
		this.participantes = participantes;
	}
}
