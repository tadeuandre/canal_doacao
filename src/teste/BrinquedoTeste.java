package teste;

import static auxiliar.Constante.GENEROS;

import java.util.ArrayList;
import java.util.List;

import negocio.Brinquedo;

public class BrinquedoTeste {
	public static void main(String[] args) {
		Brinquedo brinquedo = new Brinquedo();
		brinquedo.setNovo(false);
		brinquedo.setFaixaEtaria("2-4");
		brinquedo.setGenero(GENEROS[2]);
		brinquedo.setNome("Andador Zebra");
		brinquedo.setQuantidade(1f);
		brinquedo.setTipo("Andador");

		List<String> imagens = new ArrayList<String>();
		imagens.add("Foto1.png");
		imagens.add("Foto2.png");
		imagens.add("Foto3.png");
		brinquedo.setImagens(imagens);
		brinquedo.exibir();
	}
}
