//Felipe Maciel Scalco
//RA: 25658388

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Reader {
	public String readData(String preText) {
		InputStreamReader keyboard = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(keyboard);
		String txt = "";

		System.out.print(preText);

		try {
			txt = buff.readLine();
		} catch (IOException e) {
			System.out.println("Erro ao ler dados");
		}

		return txt;
	}
}