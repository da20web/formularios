package da20web.homologacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomologacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomologacaoApplication.class, args);
		
		System.out.println(""
				+ "________________________________________\r\n"
				+ "__  ____/_  __ \\__  __ \\__  ____/_  ___/\r\n"
				+ "_  /    _  / / /_  / / /_  __/  _____ \\ \r\n"
				+ "/ /___  / /_/ /_  /_/ /_  /___  ____/ / \r\n"
				+ "\\____/  \\____/ /_____/ /_____/  /____/  \r\n"
				+ "                                        ");
	}

}
