package br.edu.ifrn.sys.domain.consulta;

import java.time.LocalDate;

import br.edu.ifrn.sys.domain.medico.Medico;
import br.edu.ifrn.sys.domain.paciente.Paciente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "consulta")    //JPQL
@Table(name = "consulta")     //SQL
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_consulta")
    private LocalDate data_consulta;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "prescricao")
    private String prescricao;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
}

