package br.com.caelum.contas.modelo;

public class ContaPoupanca extends Conta{
	
	public String getTipo(){
		
		return "Conta Poupança";
	}

	public ContaPoupanca() {
		super();
		super.setTipo("Conta Pupança");
		// TODO Auto-generated constructor stub
	}

	public ContaPoupanca(int numero, String agencia) {
		super(numero, agencia);
		super.setTipo("Conta Pupança");
		// TODO Auto-generated constructor stub
	}

	public ContaPoupanca(String titular, float saldo, int numero, String agencia) {
		super(titular, saldo, numero, agencia);
		super.setTipo("Conta Poupança");
		// TODO Auto-generated constructor stub
	}

}
