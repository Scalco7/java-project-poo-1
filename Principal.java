//Felipe Maciel Scalco
//RA: 25658388

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Principal {
	static Reader r = new Reader();
	static ArrayList<Evento> calendario = new ArrayList<Evento>();

	public static void main(String args[]) {
		System.out.println("\n\nBem vindo ao seu calendario");
		System.out.println("Aqui voce pode marcar todos os seus compromissos e ");
		System.out.println("acessa-los de maneira facil, rapida e eficiente.\n");

		loop: while (true) {
			System.out.println("\n == O que voce deseja fazer? == ");
			System.out.println(" 1 - Cadastrar um evento");
			System.out.println(" 2 - Ver meu calendario");
			System.out.println(" 0 - Sair");
			String opcao = r.readData("\nEscolha: ");

			switch (opcao) {
				case "0":
					break loop;
				case "1":
					criarEvento();
					break;
				case "2":
					verCalendario();
					break;
				default:
					System.out.println("Opcao invalida");
					break;
			}
		}
	}

	public static void criarEvento() {
		Evento novoEvento = new Evento();
		System.out.println(" == CADASTRO DE EVENTO == ");
		System.out.println("Selecione o tipo do seu evento: ");
		System.out.println(" 1 - Reuniao");
		System.out.println(" 2 - Aniversario");
		System.out.println(" 3 - Esporte");
		System.out.println(" 4 - Show");
		System.out.println(" 0 - Voltar");
		String opcao = r.readData("\nEscolha: ");

		switch (opcao) {
			case "1":
			case "2":
			case "3":
			case "4":
				break;

			case "0":
				return;
			default:
				System.out.println("Opcao invalida");
				return;
		}

		String titulo = r.readData("Titulo: ");

		try {
			novoEvento.setTitulo(titulo);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("titulo");
			criarEvento(opcao);
			return;
		}

		String descricao = r.readData("Descricao do evento: ");

		try {
			novoEvento.setDescricao(descricao);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("descricao");
			criarEvento(opcao, titulo);
			return;
		}

		switch (opcao) {
			case "1":
				novoEvento = criarReuniao();
				break;
			case "2":
				novoEvento = criarAniversario();
				break;
			case "3":
				novoEvento = criarEsporte();
				break;
			case "4":
				novoEvento = criarShow();
				break;
			default:
				return;
		}

		novoEvento.setData(criarData());
		novoEvento.setEstadoDoEvento(selecionarEstadoDoEvento());
		novoEvento.setEndereco(criarEndereco());

		calendario.add(novoEvento);
	}

	public static void criarEvento(String opcao) {
		Evento novoEvento = new Evento();

		String titulo = r.readData("Titulo: ");

		try {
			novoEvento.setTitulo(titulo);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("titulo");
			criarEvento(opcao);
			return;
		}

		String descricao = r.readData("Descricao do evento: ");

		try {
			novoEvento.setDescricao(descricao);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("descricao");
			criarEvento(opcao, titulo);
			return;
		}

		switch (opcao) {
			case "1":
				novoEvento = criarReuniao();
				break;
			case "2":
				novoEvento = criarAniversario();
				break;
			case "3":
				novoEvento = criarEsporte();
				break;
			case "4":
				novoEvento = criarShow();
				break;
			default:
				return;
		}

		try {
			novoEvento.setTitulo(titulo);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("titulo");
		}

		novoEvento.setData(criarData());
		novoEvento.setEstadoDoEvento(selecionarEstadoDoEvento());
		novoEvento.setEndereco(criarEndereco());

		calendario.add(novoEvento);
	}

	public static void criarEvento(String opcao, String titulo) {
		Evento novoEvento = new Evento();

		try {
			novoEvento.setTitulo(titulo);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("titulo");
			criarEvento(opcao);
			return;
		}

		String descricao = r.readData("Descricao do evento: ");

		try {
			novoEvento.setDescricao(descricao);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("descricao");
			criarEvento(opcao, titulo);
		}

		switch (opcao) {
			case "1":
				novoEvento = criarReuniao();
				break;
			case "2":
				novoEvento = criarAniversario();
				break;
			case "3":
				novoEvento = criarEsporte();
				break;
			case "4":
				novoEvento = criarShow();
				break;
			default:
				return;
		}

		try {
			novoEvento.setTitulo(titulo);
		} catch (TextoSemNadaException exc) {
			exc.showMessage("titulo");
		}

		novoEvento.setData(criarData());
		novoEvento.setEstadoDoEvento(selecionarEstadoDoEvento());
		novoEvento.setEndereco(criarEndereco());

		calendario.add(novoEvento);
	}

	public static void verCalendario() {
		System.out.println(" == Seu calendario == ");
		if (calendario.size() == 0) {
			System.out.println("Calendario vazio, cadastre um evento!!\n");
			return;
		}

		for (int i = 0; i < calendario.size(); i++) {
			System.out.println("\n");
			verEvento(calendario.get(i));
		}
	}

	public static Endereco criarEndereco() {
		Endereco end = new Endereco();
		System.out.println("Vamos colocar o endereco do evento: ");

		try {
			end.setPais(r.readData("Pais: "));
			end.setEstado(r.readData("Estado: "));
			end.setCidade(r.readData("Cidade: "));
			end.setBairro(r.readData("Bairro: "));
			end.setRua(r.readData("Rua: "));
			end.setNumero(Integer.parseInt(r.readData("Numero: ")));
			end.setComplemento(r.readData("Complemento: "));
			end.setCep(r.readData("Cep: "));
		} catch (TextoSemNadaException exc) {
			// implementar ###
			exc.showMessage("campo implements");
		} catch (NumeroNegativoException exc) {
			exc.showMessage("numero implements");
		} catch (CepInvalidoException exc) {
			exc.showMessage();
		}

		return end;
	}

	public static Date criarData() {
		Date data = new Date();
		boolean controle = true;

		do {
			controle = true;
			String dia = String.format("%02d", Integer.parseInt(r.readData("Dia do mes[01-31]: ")));
			String mes = String.format("%02d", Integer.parseInt(r.readData("Mes[01-12]: ")));
			String ano = String.format("%04d", Integer.parseInt(r.readData("Ano[2015]: ")));
			String hora = String.format("%02d", Integer.parseInt(r.readData("Hora[00-24]: ")));
			String minuto = String.format("%02d", Integer.parseInt(r.readData("Minuto[00-59]: ")));

			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
			String dataTxt = dia + "/" + mes + "/" + ano + "-" + hora + ":" + minuto;

			try {
				data = formato.parse(dataTxt);
			} catch (ParseException exp) {
				System.out.println("Erro na data");
				controle = false;
			}
		} while (!controle);

		return data;
	}

	public static String selecionarEstadoDoEvento() {
		while (true) {
			String opcao = r.readData(
					"Estado [1 - Confirmado, 2 - Cancelado, 3 - Em andamento, 4 - Concluido, 5 - Finalizado]: ");

			switch (opcao) {
				case "1":
					return "Confirmado";
				case "2":
					return "Cancelado";
				case "3":
					return "Em andamento";
				case "4":
					return "Concluido";
				case "5":
					return "Finalizado";
				default:
					System.out.println("Opcao invalida");
			}

		}
	}

	public static Reuniao criarReuniao() {
		Reuniao reuniao = new Reuniao();
		try {
			reuniao.setTema(r.readData("Tema da reuniao: "));
		} catch (TextoSemNadaException exc) {
			// implementar direito depois ###
			exc.showMessage("tema");
		}

		ArrayList<String> participantes = new ArrayList<String>();
		int quantidade = Integer.parseInt(r.readData("Quantidade de participantes da reuniao: "));

		for (int i = 0; i < quantidade; i++) {
			String nome = r.readData("Participante " + (i + 1) + ": ");
			participantes.add(nome);
		}

		reuniao.setParticipantes(participantes);
		return reuniao;
	}

	public static Aniversario criarAniversario() {
		Aniversario aniversario = new Aniversario();

		try {
			aniversario.setAniversariante(r.readData("Aniversariante: "));
			aniversario.setTipoDeRoupa(r.readData("Tipo de roupa: "));
		} catch (TextoSemNadaException exc) {
			// Implementar ###
			exc.showMessage("implemnetar");
		}

		return aniversario;
	}

	public static Esporte criarEsporte() {
		Esporte esporte = new Esporte();

		try {
			esporte.setEsporte(r.readData("Esporte: "));
		} catch (TextoSemNadaException exc) {
			// implementar ###
			exc.showMessage("implements");
		}

		int quantidadeTimes = Integer.parseInt(r.readData("Quantidade de times: "));
		ArrayList<String> times = new ArrayList<String>();

		for (int i = 0; i < quantidadeTimes; i++) {
			String time = r.readData("Time " + (i + 1) + ": ");
			times.add(time);
		}

		esporte.setTimes(times);
		return esporte;
	}

	public static Show criarShow() {
		Show show = new Show();
		show.setTipo(r.readData("Tipo de show: "));

		int quatidadeArtistas = Integer.parseInt(r.readData("Quantidade de artistas: "));
		ArrayList<String> artistas = new ArrayList<String>();

		for (int i = 0; i < quatidadeArtistas; i++) {
			String artista = r.readData("Artista " + (i + 1) + ": ");
			artistas.add(artista);
		}
		show.setArtistas(artistas);

		try {
			show.setPrecoIngresso(Double.parseDouble(r.readData("Preco do ingresso[0.00]: ")));
		} catch (NumeroNegativoException exc) {
			// implementar ###
			exc.showMessage("preço");
		}

		return show;
	}

	public static void verEvento(Evento evento) {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		System.out
				.println(" ==== " + evento.getTitulo() + " - " + formatoData.format(evento.getData()) + " ====");
		System.out.println(evento.getDescricao());
		verEndereco(evento.getEndereco());

		switch (evento.getClass().getName()) {
			case "Reuniao":
				verReuniao((Reuniao) evento);
				break;
			case "Aniversario":
				verAniversario((Aniversario) evento);
				break;
			case "Esporte":
				verEsporte((Esporte) evento);
				break;
			case "Show":
				verShow((Show) evento);
				break;

			default:
				break;
		}

		System.out.println("Estado: " + evento.getEstadoDoEvento());
	}

	public static void verEndereco(Endereco endereco) {
		System.out.println("CEP: " + endereco.getCep());
		System.out.println(endereco.getCidade() + " - " + endereco.getEstado() + ", " + endereco.getPais());
		System.out.println("Rua: " + endereco.getRua() + ", " + endereco.getNumero() + " - " + endereco.getBairro());
		if (endereco.getComplemento().length() > 0) {
			System.out.println(endereco.getComplemento());
		}
	}

	public static void verReuniao(Reuniao reuniao) {
		System.out.println("Tema da reuniao - " + reuniao.getTema());
		ArrayList<String> participantes = reuniao.getParticipantes();
		if (participantes.size() < 1) {
			return;
		}

		System.out.print("Participantes: ");
		for (int i = 0; i < participantes.size(); i++) {
			if (i == participantes.size() - 1) {
				System.out.println(participantes.get(i));
			} else {
				System.out.print(participantes.get(i) + ", ");
			}
		}
	}

	public static void verAniversario(Aniversario aniversario) {
		System.out.println("Aniversariante: " + aniversario.getAniversariante());
		System.out.println("Tipo de roupa: " + aniversario.getTipoDeRoupa());
	}

	public static void verEsporte(Esporte esporte) {
		ArrayList<String> jogos = esporte.getJogos();

		System.out.println("Esporte: " + esporte.getEsporte());
		ArrayList<String> times = esporte.getTimes();
		if (times.size() < 1) {
			return;
		}

		System.out.print("Times: ");
		for (int i = 0; i < times.size(); i++) {
			if (i == times.size() - 1) {
				System.out.println(times.get(i));
			} else {
				System.out.print(times.get(i) + ", ");
			}
		}

		System.out.println("Jogos: ");
		for (int i = 0; i < jogos.size(); i++) {
			System.out.println(i + ": " + jogos.get(i));
		}
	}

	public static void verShow(Show show) {
		System.out.println("Tipo: " + show.getTipo());
		System.out.println("Preco do ingresso: " + show.getPrecoIngresso());
		ArrayList<String> artistas = show.getArtistas();
		if (artistas.size() < 1) {
			return;
		}

		System.out.print("Artistas: ");
		for (int i = 0; i < artistas.size(); i++) {
			if (i == artistas.size() - 1) {
				System.out.println(artistas.get(i));
			} else {
				System.out.print(artistas.get(i) + ", ");
			}
		}
	}
}
