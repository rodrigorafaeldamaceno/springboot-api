package com.produtos.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Produto;

//JpaRepository possui metodos prontos para fazer persintencia
public interface iProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findById(long id);

	Produto deleteById(long id);
}
