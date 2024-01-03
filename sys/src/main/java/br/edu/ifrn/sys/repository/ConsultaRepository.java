package br.edu.ifrn.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.sys.domain.consulta.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
  
}