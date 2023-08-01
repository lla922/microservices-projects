package zenith.codes.projects;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@OpenAPIDefinition(
        info = @Info(
                description = "Order Service API of Shopping App",
                version = "v1",
                title ="Order Service API"
        )
)

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = {"zenith.codes"})
@EntityScan(basePackages = {"zenith.codes"})
@ComponentScan(basePackages = {"zenith.codes"})
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class,args);
    }
}