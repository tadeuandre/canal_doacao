package teste;
import static auxiliar.Constante.TIPO_PESSOA;
import negocio.Beneficiario;

public class BeneficiarioTeste {
	
	public static void main(String[] args) {
		Beneficiario beneficiario = new Beneficiario();
		beneficiario.setEndereco("Rua das Travessas 123");
		beneficiario.setNome("Joana da Silva");
		beneficiario.setTipo(TIPO_PESSOA[0]);
		beneficiario.exibir();
	}
}
