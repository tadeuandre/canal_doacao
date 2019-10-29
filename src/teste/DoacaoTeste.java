package teste;

import static auxiliar.Constante.TIPO_PESSOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import auxiliar.Constante;
import negocio.Beneficiario;
import negocio.Brinquedo;
import negocio.Doacao;

public class DoacaoTeste {
	public static void main(String[] args) {
		Doacao doacao = new Doacao();
		doacao.setDataDivulgacao(new Date());
		
		doacao.setBeneficiario(new Beneficiario());
		doacao.getBeneficiario().setNome("Maria");
		doacao.getBeneficiario().setTipo(TIPO_PESSOA[0]);
		doacao.getBeneficiario().setEndereco("Rua Pedro II, 123");
		
		Brinquedo brinquedo = new Brinquedo();
		brinquedo.setFaixaEtaria("2-5");
		brinquedo.setGenero(Constante.GENEROS[2]);
		brinquedo.setNome("Quebra cabeças da galinha pintandinha");
		brinquedo.setNovo(true);
		brinquedo.setQuantidade(1f);
		brinquedo.setTipo("Jogo de mesa");
		brinquedo.setImagens(Arrays.asList("foto_frontal.png", "foto_de_cima.png", "foto_lateral.png"));
		
		doacao.setProdutos(new ArrayList<>());
		doacao.getProdutos().add(brinquedo);
		doacao.exibir();
	}
}
