package br.edu.ifrn.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.sys.domain.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    boolean existsByCpf(int cpf);
}