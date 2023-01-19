package com.ApiClientes.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiClientes.dtos.ClienteDto;
import com.ApiClientes.sevicos.ClienteServico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteControlador {
	
	
	private ClienteServico servico;
	
	public ClienteControlador(ClienteServico Servico) {
        this.servico = Servico;
    }
	
	
	////////////Requisições \\\\\\\\\
	
	@GetMapping
	public List<ClienteDto> listarClientes(){
		
		return servico.listarClientes();
	}
	
	
	@GetMapping("/nome/{nome}")
	public List<ClienteDto> listarClientesPorNome(@PathVariable String nome){
		
		return servico.listarClientesPorNome(nome);
	}

	
	
	@GetMapping("/{id}")
	public ClienteDto AcharClientePorId(@PathVariable long id) {
		
		return servico.AcharClientePorId(id);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDto> CadastrarCliente(@RequestBody @Valid ClienteDto clienteDto){
		
		return servico.CadastrarCliente(clienteDto);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> AtulizarCliente(@RequestBody ClienteDto clienteDto, @PathVariable long id){
		
		
		return servico.AtulizarCliente(clienteDto, id);
	}
	 
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> apagar(@PathVariable Long id){
		
		return servico.apagar(id);
	}
	
}
