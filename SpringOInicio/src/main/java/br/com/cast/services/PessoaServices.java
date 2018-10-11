package br.com.cast.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.entidade.Pessoa;



@Repository
public class PessoaServices {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pessoa> buscarTodas() {
		return entityManager.createQuery(
				  "SELECT p "
				+ "FROM Pessoa p "
				+ "join fetch p.endereco")
			.getResultList();
	}
	
	public void inserir(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}
	
	public void alterar(Pessoa pessoa) {
		entityManager.merge(pessoa);
	}
	
	@Transactional
	public Pessoa buscarPorID(String cpf) {
		return entityManager.find(Pessoa.class, cpf);
	}
	
	@Transactional
	public void Excluir(String cpf) {
			entityManager.remove(buscarPorID(cpf));
	}
}
