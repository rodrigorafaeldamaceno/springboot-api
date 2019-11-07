package com.produtos.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {
	@Autowired
	iProdutoRepository produtoRepository;

	@GetMapping("/produtos")
	public List<Produto> index() {

		return produtoRepository.findAll();
	}

	@GetMapping("/produtos/{id}")
	public Produto show(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	@PostMapping("/produtos")
	public Produto store(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produtos")
	public Produto delete(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
		return produto;
	}

	@PutMapping("/produtos")
	public Produto update(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
