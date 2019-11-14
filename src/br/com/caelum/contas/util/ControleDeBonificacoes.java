package br.com.caelum.contas.util;

import br.com.caelum.contas.modelo.Funcionario;

public class ControleDeBonificacoes {
	
	private double totaldeBonificacoes = 0;
	
	 public void registra(Funcionario funcionario)	 
	 {
		 this.totaldeBonificacoes += funcionario.getBonificacao();
		 
	 }
	 
	 public double getTotaldeBonificacoes()
	 {
		 return this.totaldeBonificacoes;
	 }
	 

}
