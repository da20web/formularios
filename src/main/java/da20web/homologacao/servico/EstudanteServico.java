package da20web.homologacao.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import da20web.homologacao.modelo.Estudante;
import da20web.homologacao.repositorio.EstudanteRepositorio;

@Service
public class EstudanteServico {

	@Autowired
	private EstudanteRepositorio estudanteRepositorio;
	
	public Estudante criarEstudante(Estudante estudante) {
		return estudanteRepositorio.save(estudante);
	}

	public List<Estudante> buscarTodosEstudantes() {
		return estudanteRepositorio.findAll();
	}
}
