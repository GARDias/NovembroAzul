package br.com.cast.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cast.entidade.Endereco;

@Repository
public class EnderecoServices {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Endereco buscarporid(String cep) {
		return entityManager.find(Endereco.class, cep);
	}
	
	public void excluir(Endereco end) {
		entityManager.remove(end);
	}
	
	public void inserir(Endereco endereco) {
		entityManager.persist(endereco);
	}
}
