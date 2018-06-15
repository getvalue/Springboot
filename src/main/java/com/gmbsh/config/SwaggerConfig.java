package com.gmbsh.config;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问接口地址：http://${host}:${port}/docs.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${SYSTEMNAME}")
    private String SYSTEMNAME;

    @Value("${SYSTEM.DESCRIPTION}")
    private String DESCRIPTION;

    @Value("${SYSTEM.VERSION}")
    private String VERSION;

    @Value("${SYSTEM.TERMSOFSERVICEURL}")
    private String TERMSOFSERVICEURL;

    @Value("${SYSTEM.CONTACTNAME}")
    private String CONTACTNAME;

    @Value("${SYSTEM.LICENSE}")
    private String LICENSE;

    @Value("${SYSTEM.LICENSEURL}")
    private String LICENSEURL;

    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo(SYSTEMNAME+"数据接口文档",
                DESCRIPTION,
                VERSION,
                TERMSOFSERVICEURL,
                CONTACTNAME,
                LICENSE,
                LICENSEURL);
        return apiInfo;
    }
}