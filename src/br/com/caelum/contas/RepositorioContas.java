package br.com.caelum.contas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

public class RepositorioContas {
	
	public void salva(List<Conta> contas) throws RuntimeException {
		PrintStream ps;
		try {
			ps = new PrintStream("contas.txt");

			
			for (Conta conta : contas) {
				ps.println(conta.getNumero() + ","
			               + conta.getAgencia() + "," + conta.getTitular() + ","
			               + conta.getSaldo() + "," + conta.getTipo());
			}
			ps.close();
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public List<Conta> carrega() throws IOException {
		InputStream is = new FileInputStream("contas.txt");		
		String titular;	
		float saldo;
		int numero;
		String agencia;	
		String tipo;
		List<Conta> contas = new ArrayList<Conta>();
		
		Scanner leitura = new Scanner(is);
		while(leitura.hasNext())
		{
			String valores[] = leitura.nextLine().split(",");
			titular = valores[0];
			agencia = valores[1];			
			numero = Integer.parseInt(valores[2]);
			saldo  = Float.parseFloat(valores[3]);			
			tipo = valores[4];
			
			if(tipo.equals("Conta Corrente"))
				contas.add(new ContaCorrente(titular, saldo, numero, agencia));
			
			else
				contas.add(new ContaPoupanca(titular, saldo, numero, agencia));
			
		}
		leitura.close();
		return contas;
		
	}

}
