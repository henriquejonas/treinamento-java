package br.com.treinamento.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.treinamento.entity.Modelo;

@Controller
public class ModeloController {
	
	@RequestMapping("/welcome")
	public List<Modelo> getModelos()
	{
		return null;
	}

}

		