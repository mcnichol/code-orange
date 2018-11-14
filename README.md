# Code Orange Talk

## MVC Monoliths
This will show the classic way in some of the beginnings of monolithic apps and some of the *why* in migrating them over to microservices.

## MVC Monoliths to Microservices
The classic monolith followed the architecture of having all services, frontend, backend coupled together typically attached to an external DB for persistence. Although only a single service in this instance, the frontend and backends were often tied together using a type of MVC pattern.

### Initialize an application with Spring Boot SDK
`brew install spring-boot`
`spring init --build=gradle -g=com.codeorange -d=web,thymeleaf mvc-app`

### TDD/Pair the MVC Monolith
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
        1. `.andExpect(content().string().containsString("<button type=\"submit\">Submit</button>"))`
1. Create test for posting to /form endpoint
    1. Test for `status().isFound()` [302] with `redirect:/success`
    1. Test for `flash().attribute("person", hasProperty("name",equalTo("userName")))`
        1. * Note RedirectAttributes needed as signature `method(@ModelAttributes("person") Person person, BindingResult br, Model model, RedirectAttrubutes ra)`
1. Discuss Testing Triangle
1. Test mockito verify delegation to PersonService

## Going Headless
1. Create React App
    1. Test Watcher in React
    1. Create Banner
    1. Create Title
        1. Align vs Justify with Flex
1. Spring Boot init with web,jpa,h2
1. Create RestController
    1. `@Controller` vs `@RestController`
    1. Test with isAnnotationPresent()
    1. Test `/user` endpoint
    1. Builder vs Beans
        1. `@JsonDeserialize` && `@JsonPOJOBuilder` 
    1. Inject PersonService and verify
1. Test PersonService
    1. PersonEntity
    1. Discuss DTO / Entity  
    1. Implement Repository
    1. data.sql && schema.sql
     

## Data as backing services (Unlikely due to time limitation)
Connect to a Redis Cache

## Controlling the Cache - Getting dirty with Hashtables (Highly Unlikely due to time limitation)
Implement our own Hashtable


## Parking Lot
* HA
* Blue / Green
* Migration Patterns - Strangler Pattern
