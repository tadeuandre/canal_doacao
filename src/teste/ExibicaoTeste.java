package teste;

import java.util.ArrayList;
import java.util.List;

import auxiliar.Exibicao;
import auxiliar.IExibicao;
import negocio.Beneficiario;
import negocio.Brinquedo;
import negocio.Descartavel;
import negocio.Roupa;

public class ExibicaoTeste {

	public static void main(String[] args) {
		Brinquedo brinquedo = new Brinquedo();
		Roupa roupa = new Roupa();
		Descartavel descartavel = new Descartavel();
		Beneficiario beneficiario = new Beneficiario();
		
		List<IExibicao> lista = new ArrayList<>();
		lista.add(brinquedo);
		lista.add(roupa);
		lista.add(descartavel);
		lista.add(beneficiario);
		
		for (IExibicao item : lista) {
			Exibicao.imprimir(item);
		}
	}
}
