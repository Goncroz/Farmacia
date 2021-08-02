package com.farmacia.exc_farma.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.exc_farma.Model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>
{
	public List<Produto> findAllByFabricanteContainingIgnoreCase (String Fabricante);
	

}
