package com.testbanksystem.testapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbanksystem.testapi.DTO.BankUsers;
import com.testbanksystem.testapi.service.BankService;

@RestController
@RequestMapping("/transacao")
public class BankController {
	
	@Autowired
	BankService bankService;
	
	@PostMapping("/usuario")
	public BankUsers salvarUser(@RequestBody BankUsers user) {		
		return bankService.salvarUser(user);
	}
	
	@PostMapping("/pagamento")
	public String fazerPix(@RequestBody BankUsers userPagamento){
		return bankService.fazerPix(userPagamento.getSaldo(), userPagamento.getChavePix());
	}
	
	@GetMapping("/listagem")
	public List<BankUsers> listarUserBank(){
		return bankService.listarUserBank();
	}
	
}
