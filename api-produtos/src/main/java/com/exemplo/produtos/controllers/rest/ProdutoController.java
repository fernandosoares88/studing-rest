package com.exemplo.produtos.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.produtos.models.Produto;
import com.exemplo.produtos.services.ProdutoService;

@RestController
@RequestMapping("/rest/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> findAll() {
		return produtoService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}

	@PostMapping
	public Produto addProduto(@RequestBody @Valid Produto produto) {
		System.out.println(produto);
		return produtoService.add(produto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody @Valid Produto produto) {
		Produto existente = produtoService.findById(id);
		if (existente == null)
			return ResponseEntity.notFound().build();
		BeanUtils.copyProperties(produto, existente, "id");
		existente = produtoService.update(existente);
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		if (produto == null)
			return ResponseEntity.notFound().build();
		produtoService.remove(produto);
		return ResponseEntity.noContent().build();
	}

}
