package da20web.homologacao.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import da20web.homologacao.modelo.Estudante;

public interface EstudanteRepositorio extends JpaRepository<Estudante, Long> {

}
