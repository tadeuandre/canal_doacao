package negocio;

import java.util.Date;
import java.util.List;

import modelo.Produto;

public class Doacao {

	private int id;

	private List<Produto> produtos;

	private Beneficiario beneficiario;

	private Date dataDivulgacao;
	
	private int[] qtdeProdutos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Date getDataDivulgacao() {
		return dataDivulgacao;
	}

	public void setDataDivulgacao(Date dataDivulgacao) {
		this.dataDivulgacao = dataDivulgacao;
	}

	public int[] getQtdeProdutos() {
		return qtdeProdutos;
	}

	public void setQtdeProdutos(int[] qtdeProdutos) {
		this.qtdeProdutos = qtdeProdutos;
	}

	public void exibir() {
		if (this.validar()) {
			System.out.println("Doa��o: ");
			System.out.println(this);
		} else {
			System.out.println("Inv�lido!");
		}
	}

	@Override
	public String toString() {
		return String.format("[produtos=" + produtos + ", beneficiario=" + beneficiario + ", dataDivulgacao="
				+ dataDivulgacao + "]");
	}

	private boolean validar() {
		return this.getProdutos().size() == Produto.obterQtdeProduto();
	}

//	private void contabiliza
}
