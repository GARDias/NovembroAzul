package br.com.cast.Business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.DTO.EnderecoDTO;
import br.com.cast.DTO.PessoaDTO;
import br.com.cast.entidade.Endereco;
import br.com.cast.entidade.Pessoa;
import br.com.cast.services.EnderecoServices;
import br.com.cast.services.PessoaServices;
@Service
public class PessoaBusiness {
	@Autowired
	private PessoaServices service;	
	private EnderecoServices serv;
	public Pessoa dtoparapessoa(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(dto.getCpf());
		pessoa.setNome(dto.getNome());
		pessoa.setEmail(dto.getEmail());
		Endereco end = new Endereco();
		end.setCep(dto.getEndereco().getCep());
		end.setLogradouro(dto.getEndereco().getLogradouro());
		end.setNumero(dto.getEndereco().getNumero());
		end.setComplemento(dto.getEndereco().getComplemento());
		end.setBairro(dto.getEndereco().getBairro());
		end.setCidade(dto.getEndereco().getCidade());
		end.setUf(dto.getEndereco().getUf());
		pessoa.setEndereco(end);
		return pessoa;
	}
	
	public PessoaDTO pessoaparadto(Pessoa pessoa) {
		PessoaDTO dto = new PessoaDTO();
		dto.setCpf(pessoa.getCpf());
		dto.setNome(pessoa.getNome());
		dto.setEmail(pessoa.getEmail());
		EnderecoDTO end = new EnderecoDTO();
		end.setCep(pessoa.getEndereco().getCep());
		end.setLogradouro(pessoa.getEndereco().getLogradouro());
		end.setNumero(pessoa.getEndereco().getNumero());
		end.setComplemento(pessoa.getEndereco().getComplemento());
		end.setBairro(pessoa.getEndereco().getBairro());
		end.setCidade(pessoa.getEndereco().getCidade());
		end.setUf(pessoa.getEndereco().getUf());
		dto.setEndereco(end);
		return dto;
	}
	
	
	@Transactional
	public void inserir(PessoaDTO dto) {
		Pessoa pessoa = dtoparapessoa(dto);
		service.inserir(pessoa);
	}
	
	public List<PessoaDTO> buscarTodos(){
		List<PessoaDTO> dtos = new ArrayList<>();
		List<Pessoa> pessoas = service.buscarTodas();
		for(Pessoa p : pessoas) {
			PessoaDTO dto = new PessoaDTO();
			dto = pessoaparadto(p);
			dtos.add(dto);
		}
		return dtos;
	}
	
	public PessoaDTO buscarporID(String cpf) {
		Pessoa pessoa = service.buscarPorID(cpf);
		PessoaDTO dto = new PessoaDTO();
		dto = pessoaparadto(pessoa);
		return dto;
	}
	@Transactional
	public void alterar(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa();
		pessoa = dtoparapessoa(dto);
		service.alterar(pessoa);
	}
	@Transactional
	public void Excluir(String cpf) {
		service.Excluir(cpf);	
	}
}
