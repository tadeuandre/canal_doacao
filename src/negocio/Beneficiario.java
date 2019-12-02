package negocio;

import auxiliar.IExibicao;

public class Beneficiario implements IExibicao {

	private int id;
	private String nome;
	private String endereco;
	private String tipo;

	public Beneficiario(Integer id) {
		this.id = id;
	}

	public Beneficiario() {}

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void exibir() {
		System.out.println("Beneficiario: ");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Beneficiario [nome=" + nome + ", endereco=" + endereco + ", tipo=" + tipo + "]";
	}

}
