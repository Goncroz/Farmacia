 package com.farmacia.exc_farma.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.exc_farma.Model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>
{
	public List<Categoria> findAllByNomeContainingIgnoreCase (String nome);
	public List<Categoria> findAllByDescricaoCategoriaContainingIgnoreCase (String descricaoCategoria);

}
