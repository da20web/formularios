package da20web.homologacao.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import da20web.homologacao.modelo.Estudante;

public interface EstudanteRepositorio extends JpaRepository<Estudante, Long> {

	List<Estudante> findByNomeContainingIgnoreCase(String nome);
}
