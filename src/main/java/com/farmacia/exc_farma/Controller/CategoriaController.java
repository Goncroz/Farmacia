package com.farmacia.exc_farma.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.exc_farma.Model.Categoria;
import com.farmacia.exc_farma.Repository.CategoriaRepository;

@RequestMapping("/farmacia")
@RestController
@CrossOrigin("*")
public class CategoriaController 
{
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public <Categoria> ResponseEntity<List<com.farmacia.exc_farma.Model.Categoria>> GetAll() 
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> GetbyId (@PathVariable Long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descreve/{descricaoCategoria")
	public ResponseEntity<Categoria> GetbyDescricaoCategoria (@PathVariable String descricaoCategoria)
	{
		return (ResponseEntity<Categoria>) repository.findAllByDescricaoCategoriaContainingIgnoreCase(descricaoCategoria);
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/id/{id}")
	public void delete (@PathVariable Long id)
	{
		repository.deleteById(id);
	}

}
