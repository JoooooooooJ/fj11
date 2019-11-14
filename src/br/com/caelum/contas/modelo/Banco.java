package br.com.caelum.contas.modelo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private String nome;
	private int numero;
	private List<Conta> contas = new ArrayList<Conta>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Banco(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;		
	}
	
	public void adiciona(Conta acc)
	{
		this.contas.add(acc);
	}
	
	public Conta pega(int x) {
		return this.contas.get(x);
	}
	
	public void ExibirConta(Conta conta) {
		contas.forEach(acc ->{
			if(contas.contains(conta))
			{
				acc.dadosParaImpressao();
			}
		});
	}
	public int pegaQuantidadeDeContas()
	{
		return contas.size();		
	}

	public boolean pertence(Conta conta)
	{
		if(contas.contains(conta))
			return true;
		 
		return false;
		
	}
	
	public Conta buscaPorTitular(String nome)
	{
		for (Conta conta : contas) {
			if(conta.getTitular().equals(nome)) {
				return conta;
			}
		}		
		throw new NullPointerException();
	}
}
