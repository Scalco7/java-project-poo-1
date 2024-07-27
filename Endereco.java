//Felipe Maciel Scalco
//RA: 25658388

public class Endereco {
	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String complemento;
	private String cep;

	public Endereco() {
		pais = "";
		estado = "";
		cidade = "";
		bairro = "";
		rua = "";
		numero = 0;
		complemento = "";
		cep = "000000000";
	}

	// Polimorfismo por Sobrecarga
	public Endereco(
			String pais,
			String estado,
			String cidade,
			String bairro,
			String rua,
			int numero,
			String complemento,
			String cep) {

		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setPais(String pais) throws TextoSemNadaException {
		if (pais.isEmpty() || pais.isBlank()) {
			throw new TextoSemNadaException();
		}
		this.pais = pais;
	}

	public void setEstado(String estado) throws TextoSemNadaException {
		if (estado.isEmpty() || estado.isBlank()) {
			throw new TextoSemNadaException();
		}
		this.estado = estado;
	}

	public void setCidade(String cidade) throws TextoSemNadaException {
		if (cidade.isEmpty() || cidade.isBlank()) {
			throw new TextoSemNadaException();
		}
		this.cidade = cidade;
	}

	public void setBairro(String bairro) throws TextoSemNadaException {
		if (bairro.isEmpty() || bairro.isBlank()) {
			throw new TextoSemNadaException();
		}
		this.bairro = bairro;
	}

	public void setRua(String rua) throws TextoSemNadaException {
		if (rua.isEmpty() || rua.isBlank()) {
			throw new TextoSemNadaException();
		}
		this.rua = rua;
	}

	public void setNumero(int numero) throws NumeroNegativoException {
		if (numero < 0) {
			throw new NumeroNegativoException();
		}
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCep(String cep) throws CepInvalidoException {
		if (cep.length() != 8) {
			throw new CepInvalidoException();
		}
		this.cep = cep;
	}
}