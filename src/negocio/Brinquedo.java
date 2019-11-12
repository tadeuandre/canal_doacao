package negocio;

import auxiliar.IExibicao;
import modelo.Produto;

public class Brinquedo extends Produto implements IExibicao {

	private int id;
	private String tipo;
	private String faixaEtaria;
	private String genero;

	public Brinquedo() {
		qtdeProduto++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void exibir() {
		System.out.println("Brinquedo: ");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Brinquedo [tipo=" + tipo + ", faixaEtaria=" + faixaEtaria + ", genero=" + genero + "]";
	}

}
