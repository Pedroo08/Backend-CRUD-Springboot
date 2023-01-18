package com.ApiClientes.dtos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.ApiClientes.entidades.Cliente;
import com.ApiClientes.repositorios.ClienteRepositorio;

public class ClienteDto {
	
	long id;
	
	String nome;
	String cpf;
	String telefone;
	String email;
	
	@Autowired
	private ClienteRepositorio repositorio;
	
	
	public ClienteDto() {}
	
	public ClienteDto(long id, String nome, String cpf, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}
	
	public ClienteDto(Cliente cliente) {
	    this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
	}
	
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
	
	
	//converte uma lista Cliente para liasta ClienteDto
		public static List<ClienteDto> converte(List<Cliente> lista) {
			 return lista.stream().map(ClienteDto::new).collect(Collectors.toList());
		}

		
		public static ClienteDto Converte1Cliente(Cliente cliente) {
			
			ClienteDto clienteDto =new ClienteDto();
			clienteDto.setCpf(cliente.getCpf());;
			clienteDto.setEmail(cliente.getEmail());
			clienteDto.setId(cliente.getId());
			clienteDto.setNome(cliente.getNome());
			clienteDto.setTelefone(cliente.getTelefone());
			return clienteDto;
	
	}
		
	public Cliente ConverteParaCliente() {
		Cliente cliente  = new Cliente();
		cliente.setNome(this.nome);
		cliente.setEmail(this.email);
		cliente.setTelefone(this.telefone);
		cliente.setCpf(this.cpf);
		
		
		
		return cliente;
	}	
	
	
	public  Cliente Atualizar(ClienteRepositorio repositorio,long id) {
		Cliente cliente = repositorio.getReferenceById(id);
		 if(this.cpf != null)
			 cliente.setCpf(this.cpf);
		 
		 if(this.email != null)
		 cliente.setEmail(this.email);
		 
		 if(this.nome != null)
			 cliente.setNome(this.nome);	
		 
		 //cliente.setTelefone(this.telefone);
		 if(this.telefone != null)
			 cliente.setTelefone(this.telefone);
	    	
	    	return cliente; 
		
	}
}

