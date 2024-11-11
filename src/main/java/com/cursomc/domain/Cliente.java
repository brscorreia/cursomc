package com.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.cursomc.domain.enums.TipoCliente;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfoucnpj;
	private Integer tipocliente;

	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name="telefone")
	private Set<String> telefone = new HashSet<>();

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String email, String cpfoucnpj, TipoCliente tipocliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfoucnpj = cpfoucnpj;
		this.tipocliente = tipocliente.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfoucnpj() {
		return cpfoucnpj;
	}

	public void setCpfoucnpj(String cpfoucnpj) {
		this.cpfoucnpj = cpfoucnpj;
	}

	public TipoCliente getTipocliente() {
		return TipoCliente.toEnum(tipocliente);
	}

	public void setTipocliente(TipoCliente tipocliente) {
		this.tipocliente = tipocliente.getCod();
	}

	public Set<String> getTelefone() {
		return telefone;
	}

	public void setTelefones(Set<String> telefone) {
		this.telefone = telefone;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void setTipocliente(Integer tipocliente) {
		this.tipocliente = tipocliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

}
