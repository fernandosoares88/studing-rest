package com.exemplo.rest.produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.rest.produtos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
