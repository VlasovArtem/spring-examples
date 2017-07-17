# Spring Examples
Project contains all test for spring framework (Lifecycle, Scope, Properties, SpEL, etc.)
All content packages contains App.java with main class, that can be run, to see required information in console log.
## Project Content
### Lifecycle
#### Bean Life Cycle
will show full bean life cycles, all steps steps that passed bean before creating till destroy

Run class - **org.avlasov.springexamples.lifecycle.LifecycleApp**

Activate DEBUG in log4j2.xml to see more information
### Scope
#### Singleton
Singleton is default scope for all beans created in Spring. If bean is not marked with annotation *@Scope* or not set in annotation *@Bean*, then Singleton will be created.

Run class - **org.avlasov.springexamples.scope.singleton.SingletonApp**