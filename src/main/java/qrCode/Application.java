package qrCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * springboot的启动类
 * @author mayn
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "qrCode")
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
