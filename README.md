# Code Orange Talk

## Migrating from MVC and Monolith to SPA and Microservices
This repo shows the beginnings of many monolithic applications in todays enterprises.  We will have an opportunity to discuss *why* certain choices are made, weight the Pro/Cons and understand at what point the Cons may outweigh our needs causing us to migrate towards a different type of architecture. 

### MVC Monolith
The classic monolith followed the architecture of having all services, frontend, backend coupled together typically storing off to an external DB through JDBC for persistence. Although only a single service in this instance, the frontend and backends are tied together using Thymeleaf templating following the MVC pattern.

#### Initialize an application with Spring Boot SDK
`brew install spring-boot`  
`spring init --build=gradle -g=com.codeorange -d=web,thymeleaf mvc-app`

#### TDD/Pair the MVC Monolith
1. Integration `contextLoads()` test
1. Test `isAnnotationPresent()`
1. Create helloWorld test and template
    1. Add `@AutoconfigureMockMvc` with `@SpringBootTest`
1. Show shortcut with Override `public void addViewControllers(ViewControllerRegistry registry)`
    1. Discuss MVC
    1. Use only `@WebMvcTest`
1. Create test and template for `/form` endpoint
    1. Test form Get endpoint exists
    1. Test Person object in Thymeleaf form (user, role) and fields `[th:object, th:action, th:field]`
        1. `.andExpect(content().string(containsString("<button type=\"submit\">Submit</button>"))`
1. Create test for posting to /form endpoint
    1. Test for `status().isFound()` [302] with `redirect:/success`
    1. Test for `flash().attribute("person", hasProperty("name",equalTo("userName")))`
        1. * Note RedirectAttributes needed as signature `method(@ModelAttributes("person") Person person, BindingResult br, Model model, RedirectAttrubutes ra)`
1. Discuss Testing Triangle
1. Test mockito verify delegation to PersonService
1. The story doesn't end here
    1. Security
    1. Model Validation
    1. Error Handling
    1. Persisting Data
    
### Going Headless - SPA's and Microservices
A common approach towards separating the frontend from leveraging a SPA approach introduces certain tradeoffs in session, content, and server side rendering for flexibility in deployment and devleopment alongside certain performance tradeoffs advantageous in certain situations. Modern Javascript frameworks such as React offer significant support in making SPA's high functioning services able to route requests and render in a performant (and highly reusable) manner.

#### TDD the SPA
1. Create React App
    1. Test Watcher in React
    1. Create Banner
    1. Create Title
        1. Align vs Justify with Flex

#### TDD the Backend REST Microservice
1. Spring Boot init with web,jpa,h2
1. Create RestController
    1. `@Controller` vs `@RestController`
    1. Test with isAnnotationPresent()
    1. Test `/user` endpoint
        1. Discuss RESTful 
    1. Builder vs Beans
        1. `@JsonDeserialize` && `@JsonPOJOBuilder` 
    1. Inject PersonService and verify
1. Test PersonService
    1. PersonEntity
    1. Discuss DTO / Entity  
1. Implement Repository
    1. data.sql && schema.sql
    1. Discuss Flyway and ORM

### Data as backing services (Unlikely due to time limitation)
Connect to a Redis Cache

### Controlling the Cache - Getting dirty with Hashtables (Highly Unlikely due to time limitation)
Implement our own Hashtable


## Parking Lot
* HA
* Blue / Green
* Migration Patterns - Strangler Pattern
