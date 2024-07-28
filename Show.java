//Felipe Maciel Scalco
//RA: 25658388

import java.util.ArrayList;

public class Show extends Evento {
	private ArrayList<String> artistas;
	private String tipo;
	private double precoIngresso;

	public Show() {
		artistas = new ArrayList<String>();
		tipo = "";
		precoIngresso = 0;
	}

	// Polimorfismo por Sobrecarga
	public Show(ArrayList<String> artistas, String tipo, double precoIngresso) {
		this.artistas = artistas;
		this.tipo = tipo;
		this.precoIngresso = precoIngresso;
	}

	// Polimorfismo por Sobreescrita
	public void concluirEvento() {
		estadoDoEvento = "Finalizado";
	}

	public ArrayList<String> getArtistas() {
		return artistas;
	}

	public String getTipo() {
		return tipo;
	}

	public double getPrecoIngresso() {
		return precoIngresso;
	}

	public void setArtistas(ArrayList<String> artistas) {
		this.artistas = artistas;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setPrecoIngresso(double precoIngresso) throws NumeroNegativoException {
		if (precoIngresso < 0) {
			throw new NumeroNegativoException();
		}
		this.precoIngresso = precoIngresso;
	}
}
