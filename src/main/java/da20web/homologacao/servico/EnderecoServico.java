package da20web.homologacao.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import da20web.homologacao.modelo.Endereco;
import da20web.homologacao.repositorio.EnderecoRepositorio;

@Service
public class EnderecoServico {

	@Autowired
	private EnderecoRepositorio enderecoRepositorio;
	
	public Endereco salvar(Endereco endereco) {
		return enderecoRepositorio.save(endereco);
	}
}
