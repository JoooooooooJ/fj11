package br.com.caelum.Pessoas;

import br.com.caelum.contas.modelo.Autenticavel;
import br.com.caelum.contas.modelo.Funcionario;

public class Gerente extends Funcionario implements Autenticavel{
	
	private String senha;
	private int numeroDeFuncionariosGerenciados;

	public int getNumeroDeFuncionariosGerenciados() {
		return numeroDeFuncionariosGerenciados;
	}

	public void setNumeroDeFuncionariosGerenciados(int numeroDeFuncionariosGerenciados) {
		this.numeroDeFuncionariosGerenciados = numeroDeFuncionariosGerenciados;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean autentica(String senha)
	{
		if (this.senha == senha)
			return true;
		else
			return false;
	}
	
	public double getBonificacao() {
		return this.salario * 1.4 + 1000;
	}
	

}
