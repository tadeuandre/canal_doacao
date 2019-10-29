package negocio;

import java.util.Date;

import modelo.Produto;

public class Descartavel extends Produto {

	private Date validade;
	private String unidadeMedida;
	private boolean isRemedio;
	private boolean isAberto;

	public Descartavel() {
//		qtdeProduto++;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public boolean isRemedio() {
		return isRemedio;
	}

	public void setRemedio(boolean isRemedio) {
		this.isRemedio = isRemedio;
	}

	public boolean isAberto() {
		return isAberto;
	}

	public void setAberto(boolean isAberto) {
		this.isAberto = isAberto;
	}

	public void exibir() {
		System.out.println("Descartavel: ");
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Descartavel [validade=" + validade + ", unidadeMedida=" + unidadeMedida + ", isRemedio=" + isRemedio
				+ ", isAberto=" + isAberto + "]";
	}

}
