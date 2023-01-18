package com.ApiClientes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiClientes.entidades.Cliente;



public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	Cliente findByCpf(String cpf);
	Cliente getReferenceById(long id);

}
