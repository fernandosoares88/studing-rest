package com.exemplo.produtos.services;

import java.util.List;

import com.exemplo.produtos.models.Produto;

public interface ProdutoService {
	
	Produto add(Produto produto);
	
	List<Produto> findAll();
	
	Produto findById(Long id);
	
	Produto update(Produto produto);
	
	void remove(Produto produto);

}
