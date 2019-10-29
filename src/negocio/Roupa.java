package negocio;

import modelo.Produto;

public class Roupa extends Produto {

	private String tamanho;
	private String marca;
	private String tipo;
	private String faixaEtaria;

	public Roupa() {
		qtdeProduto++;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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

	public void exibir() {
		System.out.println("Roupa: ");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Roupa [tamanho=" + tamanho + ", marca=" + marca + ", tipo=" + tipo + ", faixaEtaria=" + faixaEtaria
				+ "]";
	}

}
