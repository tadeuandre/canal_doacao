package teste;

import java.util.ArrayList;
import java.util.List;

import negocio.Descartavel;

public class DescartavelTeste {
	public static void main(String[] args) {
		Descartavel descartavel = new Descartavel();
		List<String> imagens = new ArrayList<String>();
		imagens.add("Foto1.png");
		imagens.add("Foto2.png");
		imagens.add("Foto3.png");
		descartavel.setImagens(imagens);
	}
}
