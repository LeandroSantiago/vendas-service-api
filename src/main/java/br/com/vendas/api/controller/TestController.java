package br.com.vendas.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vendas.api.models.Usuario;
import br.com.vendas.api.service.UsuarioService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "testar")
	public List<Usuario> test() {
		//Testando o git
		return service.findAll();
	}
}
