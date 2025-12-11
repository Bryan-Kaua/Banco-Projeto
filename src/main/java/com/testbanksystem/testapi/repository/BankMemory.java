package com.testbanksystem.testapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.testbanksystem.testapi.DTO.BankUsers;

@Repository
public class BankMemory {

	private final List<BankUsers> usuarioBank = new ArrayList<>();
	
	public BankUsers salvarUser(BankUsers user) {
		usuarioBank.add(user);
		return user;
	}
	
	public List<BankUsers> listarUserBank(){
		return usuarioBank;
	}
	
}
