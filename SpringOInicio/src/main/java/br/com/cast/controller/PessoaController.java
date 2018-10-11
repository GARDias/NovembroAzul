package br.com.cast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.Business.PessoaBusiness;
import br.com.cast.DTO.PessoaDTO;
import br.com.cast.entidade.Pessoa;

@RestController
@RequestMapping(path="/pessoa")
public class PessoaController {
	
	@Autowired
	PessoaBusiness pbus;
	
	@RequestMapping(path="/inserir", method=RequestMethod.POST)
	public void Inserir(@RequestBody PessoaDTO dto) {
		System.out.println(dto.getNome());
		pbus.inserir(dto);		
	}
	@RequestMapping(path="/alterar", method=RequestMethod.POST)
	public void alterar(@RequestBody PessoaDTO dto) {
		System.out.println(dto);
		pbus.alterar(dto);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<PessoaDTO> buscar() {		
		List<PessoaDTO> dtos = pbus.buscarTodos();
		return dtos;
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.GET)
	public PessoaDTO buscarporID(String cpf) {
		PessoaDTO dto = new PessoaDTO();
		dto = pbus.buscarporID(cpf);
		return dto;
	}
	@RequestMapping(path="/{cpf}", method=RequestMethod.DELETE)
	public void deletar(@PathVariable("cpf")String cpf) {
		pbus.Excluir(cpf);
	}
}
