package teste;

import java.util.ArrayList;
import java.util.List;

import negocio.Roupa;

public class RoupaTeste {
	public static void main(String[] args) {
		Roupa roupa = new Roupa();
		List<String> imagens = new ArrayList<String>();
		imagens.add("Foto1.png");
		imagens.add("Foto2.png");
		imagens.add("Foto3.png");
		roupa.setImagens(imagens);
	}
}
