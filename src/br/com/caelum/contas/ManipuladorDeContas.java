package br.com.caelum.contas;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.caelum.contas.modelo.*;
import br.com.caelum.contas.util.SaldoInsuficienteException;
import br.com.caelum.javafx.api.util.Evento;

public class ManipuladorDeContas {
	
	private Conta conta;
	private Banco banco = new Banco("Banco", 1);
	
	public void criaConta(Evento evento) {		
		
		String tipo = evento.getSelecionadoNoRadio("tipo");
		if(tipo.equals("Conta Corrente"))
			this.conta = new ContaCorrente();
		else
			this.conta = new ContaPoupanca();
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));
		this.conta.setTitular(evento.getString("titular"));
		this.banco.adiciona(this.conta);
		
	}
	
	public void deposita(Evento evento){
		double valor = evento.getDouble("valorOperacao");
		try {
			if(!evento.getString("valorOperacao").equals("") && !evento.getString("valorOperacao").trim().equals(""))
			{
				this.conta.deposita(valor);
			}
			else
				throw new IllegalArgumentException("Campo Vazio");
		} catch (IllegalArgumentException e) {
			
			JOptionPane.showMessageDialog(null, e.getMessage());			
		}
	}
	
	public void saca(Evento evento){
		double valor = evento.getDouble("valorOperacao");
		try {
			this.conta.saca(valor);
		} catch (SaldoInsuficienteException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void transfere(Evento evento){
		Conta destino = (Conta)evento.getSelecionadoNoCombo("destino");
		try {
			conta.transfere(evento.getDouble("valorTransferencia"), destino);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (SaldoInsuficienteException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void ordenaLista(Evento evento){
		List<Conta> contas = evento.getLista("destino");
		Collections.sort(contas);
		
	}
	public void salvaDados(Evento evento){
		
		List<Conta> contas = evento.getLista("listaContas");
		
		RepositorioContas repositorio = new RepositorioContas();		
		repositorio.salva(contas);
	}
	public List<Conta> carregaDados(){
		RepositorioContas repositorio = new RepositorioContas();
		List<Conta> contas = null;
		try {
			contas = repositorio.carrega();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return contas;
	}
}
