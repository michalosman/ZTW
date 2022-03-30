package pl.eud.pwr.ztw.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan({"pl.eud.pwr.ztw.books"})
//@EntityScan("com.delivery.domain")
@EnableSwagger2
//@EnableJpaRepositories("com.delivery.repository")
public class BooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksApplication.class, args);
    }

}
