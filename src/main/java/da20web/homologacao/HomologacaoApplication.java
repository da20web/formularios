package da20web.homologacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomologacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomologacaoApplication.class, args);
		
		System.out.println(""
				+ "________       _____________               ______  \r\n"
				+ "___  __ \\_____ __|__ \\_  __ \\__      _________  /_ \r\n"
				+ "__  / / /  __ `/___/ /  / / /_ | /| / /  _ \\_  __ \\\r\n"
				+ "_  /_/ // /_/ /_  __// /_/ /__ |/ |/ //  __/  /_/ /\r\n"
				+ "/_____/ \\__,_/ /____/\\____/ ____/|__/ \\___//_.___/ is running.\r\n"
				+ "");
	}

}
