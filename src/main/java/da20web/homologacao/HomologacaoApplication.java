package da20web.homologacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomologacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomologacaoApplication.class, args);
		
		System.out.println("Tá nascendo o monstro!");
	}

}
