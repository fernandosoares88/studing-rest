package com.exemplo.produtos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemplo.produtos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
