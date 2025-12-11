package com.testbanksystem.testapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbanksystem.testapi.DTO.BankUsers;
import com.testbanksystem.testapi.application.BankResources;
import com.testbanksystem.testapi.repository.BankMemory;

@Service
public class BankService implements BankResources{

	@Autowired
	BankMemory bankMemory;

	private int contador = 1;
	
	public BankUsers salvarUser(BankUsers user){
		BankUsers userBank = new BankUsers();
		userBank.setId(contador++);
		userBank.setNome(user.getNome());
		userBank.setChavePix(user.getChavePix());
		return bankMemory.salvarUser(userBank);
	} 
	
	
	@Override
	public String fazerPix(Long valor, String chavePix) {
		
		if ((valor > 0L && valor != null) && (!chavePix.trim().isBlank() || chavePix != null)) {
			
			for (BankUsers bankEach : bankMemory.listarUserBank()) {
				if(bankEach.getChavePix().equals(chavePix)){
						bankEach.setSaldo(valor);
						return "Pagamento feito com sucesso para" + bankEach.getNome().toUpperCase();
				}else{
						return "Chave não encontrada!";
				}
			}
		}else{
			return "Valor invalido ou campo de chave vazio";
		}
		return null;
	} 


	@Override
	public Long versaldo() {
		for (BankUsers bankEach : bankMemory.listarUserBank()) {
			return bankEach.getSaldo();
		}
		return null;
	}
	
	public List<BankUsers> listarUserBank() {
		return bankMemory.listarUserBank();
	}

}
