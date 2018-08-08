# Swagger-Implementation

## Spring Boot RESTful API Documentation With Swagger 2

Spring Boot makes developing RESTful services ridiculously easy and using Swagger makes documenting your RESTful services easy.

## Swagger 2 in Spring Boot

Swagger 2 is an open-source project used to describe and document RESTful APIs. Swagger 2 is language-agnostic 
and is extensible into new technologies and protocols beyond HTTP. 
The current version defines a set HTML, JavaScript, and CSS assets to dynamically generate documentation from a 
Swagger-compliant API. These files are bundled by the Swagger UI project to display the API on the browser. 
Besides rendering documentation, Swagger UI allows other API developers or consumers to interact with the 
API’s resources without having any of the implementation logic in place.

## we need the following dependency declaration in our Maven POM.

~~~xml
<dependency>

    <groupId>io.springfox</groupId>

    <artifactId>springfox-swagger2</artifactId>

    <version>2.6.1</version>

    <scope>compile</scope>

</dependency>
~~~
In addition to Sprinfox, we also require Swagger UI. The code to include Swagger UI is this.

~~~xml
<dependency>

    <groupId>io.springfox</groupId>

    <artifactId>springfox-swagger-ui</artifactId>

    <version>2.6.1</version>

    <scope>compile</scope>

</dependency>
~~~
## Configuring Swagger 2 in the Application
The configuration of Swagger mainly centers around the Docket bean.

~~~java
@Configuration
@EnableSwagger2
public class SwaggerConfig {  
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())  
          .paths(PathSelectors.any())     
          .build();                                           
    }
}
~~~
we will create a Docket bean in a Spring Boot configuration to configure Swagger 2 for the application. 
A Springfox Docket instance provides the primary API configuration with sensible defaults and convenience 
methods for configuration. Our Spring Boot configuration class, SwaggerConfig is this.

~~~java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("contoller-package-name"))
                .paths(regex("/product.*"))
                .build();

    }
 }
~~~
In this configuration class: 

### @EnableSwagger2 :
        annotation enables Swagger support in the class. 
### The select() :
        method called on the Docket bean instance returns an ApiSelectorBuilder, 
which provides the apis() and paths() methods 
### the apis() and paths() :
        are used to filter the controllers and methods that are being documented using String predicates.

### The RequestHandlerSelectors.basePackage:
        predicate matches the base package to filter the API. 
### The regex parameter passed to paths()
        acts as an additional filter to generate documentation only for the path starting with /product.

At this point, you should be able to test the configuration by starting the app and pointing 
your browser to http://localhost:8080/v2/api-docs. This will give us a json reprsentation.

On pointing your browser to http://localhost:8080/swagger-ui.html, you will see the generated documentation rendered by Swagger UI, like this:
