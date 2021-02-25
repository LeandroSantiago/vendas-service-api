package br.com.vendas.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vendas.api.models.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	

}
