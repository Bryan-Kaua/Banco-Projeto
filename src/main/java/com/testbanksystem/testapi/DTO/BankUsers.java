package com.testbanksystem.testapi.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankUsers {
	int id;
	String nome;
	Long saldo;
	String chavePix;
	public BankUsers() {
		this.saldo = (long) 0L;
		
	}
	
	
}
