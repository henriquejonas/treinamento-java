package br.com.treinamento.service;

import java.util.List;

import br.com.treinamento.entity.Modelo;

public interface IModeloService {
	
	List<Modelo> visualizarModelos();
	void persistModelo(Modelo modelo);
	void deleteModelo(Modelo modelo);
}
