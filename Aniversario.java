//Felipe Maciel Scalco
//RA: 25658388

public class Aniversario extends Evento {
	private String aniversariante;
	private String tipoDeRoupa;

	public Aniversario() {
		aniversariante = "";
		tipoDeRoupa = "";
	}

	// Polimorfismo por Sobrecarga
	public Aniversario(String aniversariante, String tipoDeRoupa) {
		this.aniversariante = aniversariante;
		this.tipoDeRoupa = tipoDeRoupa;
	}

	public String getAniversariante() {
		return aniversariante;
	}

	public String getTipoDeRoupa() {
		return tipoDeRoupa;
	}

	public void setAniversariante(String aniversariante) throws TextoSemNadaException {
		if (aniversariante.isBlank() || aniversariante.isEmpty()) {
			throw new TextoSemNadaException();
		}

		this.aniversariante = aniversariante;
	}

	public void setTipoDeRoupa(String tipoDeRoupa) throws TextoSemNadaException {
		if (tipoDeRoupa.isBlank() || tipoDeRoupa.isEmpty()) {
			throw new TextoSemNadaException();
		}

		this.tipoDeRoupa = tipoDeRoupa;
	}
}
