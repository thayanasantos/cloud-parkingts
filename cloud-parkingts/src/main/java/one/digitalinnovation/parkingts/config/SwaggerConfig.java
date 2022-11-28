package one.digitalinnovation.parkingts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
@Configuration

    public class SwaggerConfig  {
        @Bean
        public Docket api(){
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("one.digitalinnovation.parkingts"))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(getApiInfo());
        }

        private ApiInfo getApiInfo() {
            return new ApiInfoBuilder()
                    .title("PARKINGTS")
                    .description("ESTACIONAMENTO DA THAY")
                    .version("1.0.0")
                    .build();
        }




    }
