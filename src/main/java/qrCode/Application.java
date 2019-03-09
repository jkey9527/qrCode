package qrCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * springboot的启动类
 * @author mayn
 *
 */

@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = "qrCode")
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
