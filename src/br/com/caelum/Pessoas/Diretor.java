package br.com.caelum.Pessoas;

import br.com.caelum.contas.modelo.Autenticavel;
import br.com.caelum.contas.modelo.Funcionario;

public class Diretor extends Funcionario implements Autenticavel {
	
	private String senha;

	
	public boolean autentica(String senha) {
		
		if(this.senha!= senha) {
			return false;
		}
		else
		{
			return true;
		}
		
	}

	public double getBonificacao() {
		
		return this.salario * 1.4 + 1500;
	}
	
	

}
