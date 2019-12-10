package com.neoway.springcloud.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 20190712713
 * @date 2019/12/9 20:41
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ZUUL集成Swagger2")
                .contact(new Contact("Baron", null, "15619031887@163.com"))
                .version("1.0")
                .build();
    }

    @Bean
    public Docket init() {
        return new Docket(DocumentationType.SWAGGER_2)
                //*** 注意：此处groupName不能配置，否则举合失败
//                .groupName("api首页")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.neoway.springcloud.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
