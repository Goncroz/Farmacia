package com.farmacia.exc_farma.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Produto")
public class Produto 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome_produto;
	
	@NotNull
	private String fabricante;
	
	@NotNull
	private float preco;
	
	@NotNull
	public enum Vendedor {Farmaceutico,Balconista,Perfumista,Caixa}
	
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List<Categoria> categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}	
	

}
