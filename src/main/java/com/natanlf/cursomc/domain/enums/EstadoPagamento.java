package com.natanlf.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"), 
	CANCELADO(3, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) { //construtor de enum é private
		this.cod = cod;
		this.descricao = descricao;
	} 
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer cod) { //Devolvo um tipo cliete a partir de um cod
		if(cod==null) {
			return null;
		}
		
		for(EstadoPagamento x : EstadoPagamento.values()) { //percorre todos os valores possíveis do meu tipo cliente
			if(cod.equals(x.getCod())) { //se o que passei for igual ao da lista
				return x;
			}
		}
		
		//Se entrar no for e não achar, quer dizer que deu exception
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
}
