package com.ApiClientes.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name="clientes")

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@NotNull(message = "O nome não pode ser nulo")
	@NotBlank(message = "O nome não pode ser vazio")
	@Column(name="Nome", nullable=false)
	String nome;
	
	@NotNull(message = "O Cpf não pode ser nulo")
	@NotBlank(message = "O Cpf não pode ser vazio")
	@Column(name="CPF", nullable=false)
	String cpf;
	
	@Column(name="Telefone", nullable=false)
	String telefone;
	
	@NotNull(message = "O email não pode ser nulo")
	@NotBlank(message = "O email não pode ser vazio")
	@Column(name="Email", nullable=false)
	String email;
	
	//Getters e Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
