package modelo;

import java.util.List;

public abstract class Produto {

	private int id;
	private String nome;
	private Float quantidade;
	private boolean isNovo;
	private List<String> imagens;
	public static int qtdeProduto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isNovo() {
		return isNovo;
	}

	public void setNovo(boolean isNovo) {
		this.isNovo = isNovo;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

	public static int obterQtdeProduto() {
		return qtdeProduto;
	}

	public abstract void exibir();

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", quantidade=" + quantidade + ", isNovo=" + isNovo + ", imagens=" + imagens
				+ "]";
	}

}
