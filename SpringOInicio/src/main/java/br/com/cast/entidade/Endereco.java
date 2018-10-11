package br.com.cast.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "endereco", schema = "endereco")
public class Endereco {

	@Id
	private String cep;

	@Column(name = "logradouro", length = 200, nullable = false)
	private String logradouro;

	@Column(name = "numero", length = 5, nullable = true)
	private String numero;

	@Column(name = "complemento", length = 20, nullable = true)
	private String complemento;

	@Column(name = "bairro", length = 200, nullable = false)
	private String bairro;

	@Column(name = "cidade", length = 200, nullable = false)
	private String cidade;

	@Column(name = "uf", length = 2, nullable = false)
	private String uf;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
