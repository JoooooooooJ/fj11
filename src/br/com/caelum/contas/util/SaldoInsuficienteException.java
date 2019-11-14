package br.com.caelum.contas.util;

import java.util.Random;

public class SaldoInsuficienteException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = new Random().nextInt();

	public SaldoInsuficienteException(double valor) {
		
		super("\nSaldo Insuficiente, voc� tentou sacar o valor de: " + valor);
	}

}
