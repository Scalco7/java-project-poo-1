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
		System.out.println(ConsoleColors.WHITE_BOLD_BRIGHT + "\n\nBem vindo ao seu calendario" + ConsoleColors.RESET);
		System.out.println("Aqui voce pode marcar todos os seus compromissos e ");
		System.out.println("acessa-los de maneira facil, rapida e eficiente.\n");

		loop: while (true) {
			System.out.println("\n== O que voce deseja fazer? == ");
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
		Evento novoEvento;
		System.out.println("== CADASTRO DE EVENTO == ");
		System.out.println("Selecione o tipo do seu evento: ");
		System.out.println(" 1 - Reuniao");
		System.out.println(" 2 - Aniversario");
		System.out.println(" 3 - Esporte");
		System.out.println(" 4 - Show");
		System.out.println(" 0 - Voltar");
		String opcao = r.readData("\nEscolha: ");

		switch (opcao) {
			case "1":
				novoEvento = new Reuniao();
				break;
			case "2":
				novoEvento = new Aniversario();
				break;
			case "3":
				novoEvento = new Esporte();
				break;
			case "4":
				novoEvento = new Show();
				break;

			case "0":
				return;
			default:
				System.out.println("Opcao invalida");
				return;
		}

		boolean control;
		do {
			try {
				control = true;
				String titulo = r.readData("Titulo: ");
				novoEvento.setTitulo(titulo);
			} catch (TextoSemNadaException exc) {
				control = false;
				exc.showMessage("titulo");
			}
		} while (!control);

		do {
			try {
				control = true;
				String descricao = r.readData("Descricao do evento: ");
				novoEvento.setDescricao(descricao);
			} catch (TextoSemNadaException exc) {
				control = false;
				exc.showMessage("descricao");
			}
		} while (!control);

		switch (opcao) {
			case "1":
				novoEvento = criarReuniao((Reuniao) novoEvento);
				break;
			case "2":
				novoEvento = criarAniversario((Aniversario) novoEvento);
				break;
			case "3":
				novoEvento = criarEsporte((Esporte) novoEvento);
				break;
			case "4":
				novoEvento = criarShow((Show) novoEvento);
				break;
			default:
				return;
		}

		novoEvento.setData(criarData());
		novoEvento.setEstadoDoEvento(selecionarEstadoDoEvento());
		novoEvento.setEndereco(criarEndereco());

		calendario.add(novoEvento);
	}

	public static void verCalendario() {
		System.out.println("== Seu calendario == ");
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
			try {
				String dia = String.format("%02d", Integer.parseInt(r.readData("Dia do mes[01-31]: ")));
				String mes = String.format("%02d", Integer.parseInt(r.readData("Mes[01-12]: ")));
				String ano = String.format("%04d", Integer.parseInt(r.readData("Ano[2015]: ")));
				String hora = String.format("%02d", Integer.parseInt(r.readData("Hora[00-24]: ")));
				String minuto = String.format("%02d", Integer.parseInt(r.readData("Minuto[00-59]: ")));

				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
				String dataTxt = dia + "/" + mes + "/" + ano + "-" + hora + ":" + minuto;
				data = formato.parse(dataTxt);
			} catch (ParseException exp) {
				System.out.println("Erro na data.");
				controle = false;
			} catch (NumberFormatException exc) {
				System.out.println("A data deve ser um numero.");
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

	public static Reuniao criarReuniao(Reuniao reuniao) {
		boolean control = false;

		do {
			control = true;
			try {
				reuniao.setTema(r.readData("Tema da reuniao: "));
			} catch (TextoSemNadaException exc) {
				exc.showMessage("tema");
				control = false;
			}
		} while (!control);

		ArrayList<String> participantes = new ArrayList<String>();
		int quantidade = 0;

		do {
			try {
				control = true;
				quantidade = Integer.parseInt(r.readData("Quantidade de participantes da reuniao: "));
			} catch (NumberFormatException exc) {
				System.out.println("A quantidade deve ser um numero.");
				control = false;
			}
		} while (!control);

		for (int i = 0; i < quantidade; i++) {
			String nome = r.readData("Participante " + (i + 1) + ": ");
			participantes.add(nome);
		}

		reuniao.setParticipantes(participantes);
		return reuniao;
	}

	public static Aniversario criarAniversario(Aniversario aniversario) {
		boolean control = false;

		do {
			try {
				control = true;
				aniversario.setAniversariante(r.readData("Aniversariante: "));
			} catch (TextoSemNadaException exc) {
				exc.showMessage("aniversariante");
				control = false;
			}
		} while (!control);

		do {
			try {
				control = true;
				aniversario.setTipoDeRoupa(r.readData("Tipo de roupa: "));
			} catch (TextoSemNadaException exc) {
				exc.showMessage("tipo de roupa");
				control = false;
			}
		} while (!control);

		return aniversario;
	}

	public static Esporte criarEsporte(Esporte esporte) {
		boolean control = false;

		do {
			try {
				control = true;
				esporte.setEsporte(r.readData("Esporte: "));
			} catch (TextoSemNadaException exc) {
				exc.showMessage("esporte");
				control = false;
			}
		} while (!control);

		int quantidadeTimes = 0;

		do {
			try {
				control = true;
				quantidadeTimes = Integer.parseInt(r.readData("Quantidade de times: "));
			} catch (NumberFormatException exc) {
				System.out.println("A quantidade deve ser um numero");
				control = false;
			}
		} while (!control);

		ArrayList<String> times = new ArrayList<String>();

		for (int i = 0; i < quantidadeTimes; i++) {
			String time = r.readData("Time " + (i + 1) + ": ");
			times.add(time);
		}

		esporte.setTimes(times);
		return esporte;
	}

	public static Show criarShow(Show show) {
		show.setTipo(r.readData("Tipo de show: "));

		int quantidadeArtistas = 0;
		boolean control;

		do {
			try {
				control = true;
				quantidadeArtistas = Integer.parseInt(r.readData("Quantidade de artistas: "));
			} catch (NumberFormatException exc) {
				System.out.println("A quantidade deve ser um numero.");
				control = false;
			}
		} while (!control);

		ArrayList<String> artistas = new ArrayList<String>();

		for (int i = 0; i < quantidadeArtistas; i++) {
			String artista = r.readData("Artista " + (i + 1) + ": ");
			artistas.add(artista);
		}
		show.setArtistas(artistas);

		do {
			try {
				control = true;
				show.setPrecoIngresso(Double.parseDouble(r.readData("Preco do ingresso[0.00]: ")));
			} catch (NumeroNegativoException exc) {
				exc.showMessage("preco");
				control = false;
			} catch (NumberFormatException exc) {
				System.out.println("O preco deve ser um numero.");
				control = false;
			}
		} while (!control);

		return show;
	}

	public static void verEvento(Evento evento) {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		System.out
				.println("==== " + ConsoleColors.WHITE_BOLD_BRIGHT + evento.getTitulo() + ConsoleColors.RESET + " - "
						+ formatoData.format(evento.getData()) + " ====");
		System.out.println(evento.getDescricao() + '\n');
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

		String estadoDoEvento = evento.getEstadoDoEvento();
		String color = "";

		switch (estadoDoEvento) {
			case "Confirmado":
				color = ConsoleColors.GREEN_BOLD_BRIGHT;

				break;
			case "Em andamento":
				color = ConsoleColors.YELLOW_BOLD_BRIGHT;
				break;
			case "Concluido":
				color = ConsoleColors.BLUE_BOLD_BRIGHT;
				break;
			case "Finalizado":
			case "Cancelado":
				color = ConsoleColors.RED_BOLD_BRIGHT;
				break;

		}

		System.out.println("Estado: " + color + estadoDoEvento + ConsoleColors.RESET);
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
