package com.ApiClientes.sevicos;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ApiClientes.dtos.ClienteDto;
import com.ApiClientes.entidades.Cliente;
import com.ApiClientes.repositorios.ClienteRepositorio;

@Service
public class ClienteServico {
	
	
	
	private ClienteRepositorio repositorio;
	
	ClienteServico (ClienteRepositorio repositorio){
		this.repositorio = repositorio;
	}
	
	
	//Get
	public List<ClienteDto> listarClientes(){
		
		List<Cliente> lista = repositorio.findAll();
		
		return  ClienteDto.converte(lista);
	}
	
	//Get
	public List<ClienteDto> listarClientesPorNome(String nome){
			
			List<Cliente> lista = repositorio.findByNomeContaining(nome);
			
			return  ClienteDto.converte(lista);
		}
	
	
	//Get
	public ClienteDto AcharClientePorId( long id) {
			
			
			return ClienteDto.Converte1Cliente(repositorio.getReferenceById(id));
		}

	
	//Post
	public ResponseEntity<ClienteDto> CadastrarCliente(@RequestBody ClienteDto clienteDto){
		Cliente cliente = clienteDto.ConverteParaCliente();
		
		repositorio.save(cliente);
		return new ResponseEntity<ClienteDto>(clienteDto,HttpStatus.CREATED);
		
	}
	
	//Put
	public ResponseEntity<ClienteDto> AtulizarCliente(@RequestBody ClienteDto clienteDto, @PathVariable long id){
			
			Cliente cliente = clienteDto.Atualizar(repositorio,id);
			repositorio.save(cliente);
			
			return new ResponseEntity<ClienteDto>(clienteDto,HttpStatus.OK);
		}
	
	
	//Delete
	public ResponseEntity<?> apagar(@PathVariable Long id){
		repositorio.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
