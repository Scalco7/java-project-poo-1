//Felipe Maciel Scalco
//RA: 25658388

import java.util.ArrayList;

public class Esporte extends Evento implements CampeonatoInterface {
	private ArrayList<String> times;
	private String esporte;

	public Esporte() {
		times = new ArrayList<String>();
		esporte = "";
	}

	// Polimorfismo por Sobrecarga
	public Esporte(ArrayList<String> times, String esporte) {
		this.times = times;
		this.esporte = esporte;
	}

	// Interface
	// Polimorfismo por sobreescrita
	public ArrayList<String> getJogos() {
		ArrayList<String> jogos = new ArrayList<String>();

		for (int i = 0; i < times.size(); i++) {
			for (int j = (i + 1); j < times.size(); j++) {
				String jogo = times.get(i).toString() + " VS " + times.get(j).toString();
				jogos.add(jogo);
			}
		}

		return jogos;
	}

	public ArrayList<String> getTimes() {
		return times;
	}

	public String getEsporte() {
		return esporte;
	}

	public void setTimes(ArrayList<String> times) {
		this.times = times;
	}

	public void setEsporte(String esporte) throws TextoSemNadaException {
		if (esporte.isBlank() || esporte.isEmpty()) {
			throw new TextoSemNadaException();
		}
		this.esporte = esporte;
	}
}
