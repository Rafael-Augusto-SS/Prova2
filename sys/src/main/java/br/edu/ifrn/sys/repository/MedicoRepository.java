package br.edu.ifrn.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.sys.domain.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
  
}