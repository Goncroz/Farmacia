package com.farmacia.exc_farma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.farmacia.exc_farma.Model.Produto;
import com.farmacia.exc_farma.Repository.ProdutoRepository;

@RequestMapping("/produtofarma")
public class ProdutoController 
{
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public <Produto> ResponseEntity<List<com.farmacia.exc_farma.Model.Produto>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> GetbyId (@PathVariable Long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping
	public ResponseEntity<Produto> GetbyFabricante (@PathVariable String fabricante)
	{
		return (ResponseEntity<Produto>) repository.findAllByFabricanteContainingIgnoreCase(fabricante);
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	
	@DeleteMapping("/id/{id}")
	public void delete (@PathVariable Long id)
	{
		repository.deleteById(id);
	}
}
