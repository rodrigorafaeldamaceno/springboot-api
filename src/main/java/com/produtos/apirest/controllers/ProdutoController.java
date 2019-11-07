package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.iProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
// permite que a api possa ser acessado por qualquer dominio
@CrossOrigin(origins = "*")
public class ProdutoController {
	@Autowired
	iProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista com todos os produtos")
	public List<Produto> index() {

		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	@ApiOperation(value = "Retorna um produto especifico com base no ID")
	public Produto show(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produtos")
	@ApiOperation(value = "Registra um produto")
	public Produto store(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produtos")
	@ApiOperation(value = "Exclui um registro de produto")
	public Produto delete(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
		return produto;
	}

	@PutMapping("/produtos")
	@ApiOperation(value = "Atualiza o registro de um produto")
	public Produto update(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
