package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel{
	
	public String getTipo(){
		return "Conta Corrente";			
	}	
	
	public ContaCorrente() {
		super();	
		super.setTipo("Conta Corrente");
	}

	public ContaCorrente(int numero, String agencia) {
		super(numero, agencia);
		super.setTipo("Conta Corrente");
	}

	public ContaCorrente(String titular, float saldo, int numero, String agencia) {
		super(titular, saldo, numero, agencia);
		super.setTipo("Conta Pupança");
	}

	public void saca(float valor) {
		
		super.saca(valor + 0.10);
	}
	
	public double getValorImposto() {
		
		return this.getSaldo() * 0.01;
	}

}
