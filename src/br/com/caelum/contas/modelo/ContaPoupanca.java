package br.com.caelum.contas.modelo;

public class ContaPoupanca extends Conta{
	
	public String getTipo(){
		
		return "Conta Poupan�a";
	}

	public ContaPoupanca() {
		super();
		super.setTipo("Conta Pupan�a");
		// TODO Auto-generated constructor stub
	}

	public ContaPoupanca(int numero, String agencia) {
		super(numero, agencia);
		super.setTipo("Conta Pupan�a");
		// TODO Auto-generated constructor stub
	}

	public ContaPoupanca(String titular, float saldo, int numero, String agencia) {
		super(titular, saldo, numero, agencia);
		super.setTipo("Conta Poupan�a");
		// TODO Auto-generated constructor stub
	}

}
