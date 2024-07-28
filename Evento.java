//Felipe Maciel Scalco
//RA: 25658388

import java.util.Date;

public abstract class Evento {
	private String titulo;
	private Date data;
	private Endereco endereco;
	private String descricao;
	protected String estadoDoEvento;

	public Evento() {
		titulo = "";
		data = new Date();
		endereco = new Endereco();
		descricao = "";
		estadoDoEvento = "Confirmado";
	}

	// Polimorfismo por Sobrecarga
	public Evento(String titulo, Date data, Endereco endereco, String descricao, String estadoDoEvento) {
		this.titulo = titulo;
		this.data = data;
		this.endereco = endereco;
		this.descricao = descricao;
		this.estadoDoEvento = estadoDoEvento;
	}

	public void concluirEvento() {
		estadoDoEvento = "Concluido";
	}

	public String getTitulo() {
		return titulo;
	}

	public Date getData() {
		return data;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getEstadoDoEvento() {
		return estadoDoEvento;
	}

	public void setTitulo(String titulo) throws TextoSemNadaException {
		if (titulo.isEmpty() || titulo.isBlank())
			throw new TextoSemNadaException();

		this.titulo = titulo;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setDescricao(String descricao) throws TextoSemNadaException {
		if (descricao.isEmpty() || descricao.isBlank())
			throw new TextoSemNadaException();

		this.descricao = descricao;
	}

	public void setEstadoDoEvento(String estadoDoEvento) {
		this.estadoDoEvento = estadoDoEvento;
	}
}
