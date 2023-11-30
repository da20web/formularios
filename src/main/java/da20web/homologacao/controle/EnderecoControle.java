package da20web.homologacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import da20web.homologacao.excecao.EstudanteNotFoundException;
import da20web.homologacao.modelo.Endereco;
import da20web.homologacao.modelo.Estudante;
import da20web.homologacao.servico.EnderecoServico;
import da20web.homologacao.servico.EstudanteServico;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/endereco")
public class EnderecoControle {

	@Autowired
	private EnderecoServico enderecoServico;
	
	@Autowired
	private EstudanteServico estudanteServico;
	
	@GetMapping("/buscar-endereco/{id}")
	public String novoEndereco(@PathVariable("id") long id, Model model) {
		String pagina = "";
		try {
			Estudante estudante = estudanteServico.buscarEstudantePorId(id);
			if (estudante.getEndereco() == null) {
				Endereco endereco = new Endereco();
				endereco.setEstudante(estudante);
				model.addAttribute("item", endereco);
				pagina = "/novo-endereco";
			} else {
				model.addAttribute("item", estudante.getEndereco());
				pagina = "/editar-endereco";
			}
		} catch (EstudanteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pagina;
	}
	
	@PostMapping("/gravar-endereco/{idEstudante}")
	public String gravarEndereco(@PathVariable("idEstudante") long idEstudante, 
			@ModelAttribute("item") @Valid Endereco endereco,
			BindingResult result,
			RedirectAttributes attributes) {
		try {
			Estudante estudante = estudanteServico.buscarEstudantePorId(idEstudante);
			endereco.setEstudante(estudante);
		} catch (EstudanteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result.hasErrors()) {
			return "/novo-endereco";
		}
		enderecoServico.salvar(endereco);
		attributes.addFlashAttribute("mensagem", "Endereço salvo com sucesso!");
		return "redirect:/endereco/buscar-endereco/" + idEstudante;
	}
	
	@PostMapping("/editar-endereco/{idEstudante}/{idEndereco}")
	public String editarEndereco(@PathVariable("idEstudante") long idEstudante, 
			@PathVariable("idEndereco") long idEndereco,
			@ModelAttribute("item") @Valid Endereco endereco,
			BindingResult result,
			RedirectAttributes attributes) {
		try {
			Estudante estudante = estudanteServico.buscarEstudantePorId(idEstudante);
			endereco.setEstudante(estudante);
			endereco.setId(idEndereco);
		} catch (EstudanteNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result.hasErrors()) {
			return "/editar-endereco";
		}
		enderecoServico.salvar(endereco);
		attributes.addFlashAttribute("mensagem", "Endereço alterado com sucesso!");
		return "redirect:/endereco/buscar-endereco/" + idEstudante;
	}
}
