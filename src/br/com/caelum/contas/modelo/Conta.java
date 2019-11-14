package br.com.caelum.contas.modelo;

import javax.swing.JOptionPane;

import br.com.caelum.contas.util.SaldoInsuficienteException;


public class Conta implements Comparable<Conta> {
	
	private String titular;	
	private float saldo;
	private int numero;
	private String agencia;
	private String tipo;
	
	public Conta() {
		
	}
	public Conta(int numero, String agencia) {
		this.numero = numero;
		this.agencia = agencia;
	}
	
	

	public Conta(String titular, float saldo, int numero, String agencia ) {
		super();
		this.titular = titular;
		this.saldo = saldo;
		this.numero = numero;
		this.agencia = agencia;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public void deposita(double valor) {
		if(valor > 0)
		{
			this.saldo += valor;
		}
		else
			throw new IllegalArgumentException();
	}
	
	public void saca(double valor) {
		
		if(valor<=this.saldo) {		
			if(valor >0)
			{
				this.saldo -= valor;
			}
			else
				throw new IllegalArgumentException("\nNão é possivel sacar um valor negativo");
		}		
		else		
			throw new SaldoInsuficienteException(valor);
		
	}
	
	public void transfere(double valor, Conta conta) {		
		try {
			this.saca(valor);
			conta.deposita(valor);
		} catch (SaldoInsuficienteException e) {			
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
				
	}
	
	public String dadosParaImpressao() {
		   String dados = "Titular: " + this.titular;
		   dados += "\n|Número: " + this.numero;
		   dados += "\n|Agência: " + this.agencia;
		   dados += "\n|Saldo: R$" + this.saldo;
		   dados += "\n|Tipo:" + this.getTipo();
		   return dados;
	}
	
	@Override
	public String toString()
	{
		return "[Titular: " + this.titular.toUpperCase() +", Numero: " + this.numero + ", Agencia:" + this.agencia +"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + numero;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Conta conta)
	{
		return this.titular.compareTo(conta.titular);
	}
	
	
	
	

}
