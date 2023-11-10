package da20web.homologacao.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import da20web.homologacao.modelo.Estudante;
import da20web.homologacao.servico.EstudanteServico;

@Controller
public class EstudanteControle {

	@Autowired
	private EstudanteServico estudanteServico;
	
	@GetMapping("/")
	public String listarEstudantes() {
		return "/lista-estudantes";
	}
	
	@GetMapping("/novo")
	public String novoEstudante(Model model) {
		Estudante estudante = new Estudante();
		model.addAttribute("novoEstudante", estudante);
		return "/novo-estudante";
	}
	
	@PostMapping("/gravar")
	public String gravarEstudante(@ModelAttribute("novoEstudante") Estudante estudante,
			RedirectAttributes attributes) {
		estudanteServico.criarEstudante(estudante);
		attributes.addFlashAttribute("mensagem", "Estudante salvo com sucesso!");
		return "redirect:/novo";
	} 
}
