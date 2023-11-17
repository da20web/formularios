package da20web.homologacao.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O logradouro deve ser informado") // Anotações do Valid
	@Size(min = 2, message = "O logradouro deve ter no mínimo 2 caracteres")
	private String logradouro;

	@NotBlank(message = "O número deve ser informado") // Anotações do Valid
	@Size(min = 2, message = "O número deve ter no mínimo 2 caracteres")
	private String numero;

	@NotBlank(message = "O cep deve ser informado") // Anotações do Valid
	@Size(min = 8, message = "O cep deve ter no mínimo 8 caracteres")
	private String cep;

	@OneToOne
	public Estudante estudante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
}
