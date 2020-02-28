package com.exemplo.rest.produtos.services.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.rest.produtos.models.Produto;
import com.exemplo.rest.produtos.repositories.ProdutoRepository;
import com.exemplo.rest.produtos.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto add(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto findById(Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Produto update(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Override
	public void remove(Produto produto) {
		produtoRepository.delete(produto);
	}

}
