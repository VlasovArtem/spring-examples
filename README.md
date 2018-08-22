# Spring Examples
Project contains all test for spring framework (Lifecycle, Scope, Properties, SpEL, etc.)
All content packages contains App.java with main class and test classes, that can be run, to see required information in console log.

## Project Content
* [Bean Qualifying](#bean-qualifying)
* [Condition Bean](#condition-bean)
* [Controller](#controller)
* [Bean Lifecycle](#bean-lifecycle)
* [Repository](#repository)
* [Bean Scope](#bean-scope)
* [SpEL](#spel-spring-expression-language)
* [Other](#other)
* [Spring 5 Examples](#spring-5-examples)

### Bean Qualifying
If system contains multiple bean with the same class, you need to qualify which bean you need to use some of the examples how to qualify bean:
* Annotation *@Qualifier("beanName")*
* Annotation *@Primary* for the class, that should be primary. In this case if system have only one @Primary for one class type, then *@Qualifier* is not required.
 
Also package contains examples, how to use multiple qualifiers.

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/beanqualifying)

[To the top](#project-content)

### Condition Bean
Conditional bean all you to say spring what beans need to be registered by the Spring. Here is few examples:
* With custom annotation
* On verification if bean with name if registered in spring
* Based on environment properties

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/conditionbean)

[To the top](#project-content)

### Controller
Spring Web MVC controllers examples with different examples how to handle exceptions from requests. Possible solutions to handle exceptions in Spring MVC
* Method annotated with *@ExceptionHandler* under the method inside each controller. In this case @ExceptionHandler will work only for class in which he is declared
* Class annotated with *@ControllerAdvice* and methods with annotation *@ExceptionHandler*
* Class, that extends *HandlerExceptionResolver* (please, note this class should be declared as bean)

Developer notes: If you create method with annotation *@ExceptionHandler*, that catch exception with base class *Exception.class* all other methods with more specific exception classes will be ignored.

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/controller)

[To the top](#project-content)

### Bean Lifecycle

Package contains examples of bean lifecycle from their creation till destroy. All information about the steps of bean lifecycle is printing into the console. All beans contains *@PostConstruct* and *@PreDestroy* methods, implements next interfaces ([MainClass](https://github.com/VlasovArtem/spring-examples/blob/master/src/main/java/org/avlasov/springexamples/lifecycle/entity/AbstractLifecycleEntity.java)):
* BeanNameAware
* InitializingBean 
* DisposableBean
* BeanFactoryAware
* ApplicationContextAware

The example has one registered *BeanPostProcessor*

Package contains next examples of bean lifecycle:
* Original Spring Bean (without autowiring)
* Spring Bean, that creates inside config class with help of *@Bean* with declared initMethod and destroyMethod.
* Spring Bean with autowiring
* Spring Bean with circle autowiring
    * With annotation @Lazy (you cannot use autowired inside constructor). Spring creates Proxy object, that will be available only after Spring Application Context will be ready.
    * With help of method with annotation *@PostConstruct*
    * With help of setter method    

For more information, please, refer to method *org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(java.lang.String, java.lang.Object, org.springframework.beans.factory.support.RootBeanDefinition)*

Activate DEBUG in log4j2.xml to see more information

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/lifecycle)

[To the top](#project-content)

### Repository 

Package contains examples how to create SQL and NoSQL configuration, repository interfaces with naming methods, custom repository that works with plain database manages (EntityManager for SQL and MongoTemplate for MongoDB)

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/repository)

[To the top](#project-content)

### Bean Scope 

Example of the next bean scopes - *Singleton* (spring default), *Prototype*. *Request*, *Session* and *Global Session* scopes are not represent.

Singleton beans contains next examples:
* Simple Singleton
* Singleton with autowired prototype. In this case prototype will always the same. 
* Singleton with autowired proxied prototype. Spring will create proxy over prototype and every time you call any method or field from proxied prototype Spring will create new instance of this class.

Prototype beans contains next example:
* Simple Prototype
* Prototype with autowired prototype. Autowired prototype will be different each time you get new instance of a main prototype.

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/scope)

[To the top](#project-content)

### SpEL (Spring Expression Language)

Example of using @Value annotation with simple mapping or with default value.

### Other

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/other)

#### Required
Example of how to user *@Required*. Annotation can be use only with help of @Bean annotation. And said Spring, that inject value is required. Usually this annotation is use for setter methods. Will work only for XML configuration

### Spring 5 Examples

Spring 5 examples

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/spring5)

* [Spring 5 Repository with Reactive](#spring-5-nosql-with-reactive)

#### Spring 5 NoSQL with Reactive

*NOT COMPLETED*

Example of how to use Mono and Flux in NoSQL repository

[Package](https://github.com/VlasovArtem/spring-examples/tree/master/src/main/java/org/avlasov/springexamples/spring5/repository/nosql)

[To the top](#spring-5-examples)

# TODO

* Spring Security
* Spring AOP