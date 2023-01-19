package com.ApiClientes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiClientes.entidades.Cliente;



public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	Cliente findByCpf(String cpf);
	Cliente getReferenceById(long id);
	public List<Cliente> findByNomeContaining(String nome);

}
