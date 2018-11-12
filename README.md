# Code Orange Talk

## MVC Monoliths
This will show the classic way in how we built monolithic applications.

### Initialize an application with Spring Boot SDK
`brew install spring-boot`
`spring init --build=gradle -g=com.codeorange -d=web,thymeleaf mvc-app`

1. Integration contextLoads() test
1. Test annotation isPresent
1. Create helloWorld test and template
    1. Add @AutoconfigureMockMvc with @SpringBootTest
1. Show shortcut with Override `public void addViewControllers(ViewControllerRegistry registry)`
    1. Discuss MVC
    1. Use only @WebMvcTest
1. Create test and template for /form endpoint
    1. Test form endpoint
    1. Test Person object in Thymeleaf form (user, role) and fields [th:object, th:action, th:field]
        1. `.andExpect(content().string().containsString("<button type=\"submit\">Submit</button>"))`
1. Create test for posting to /form endpoint
    1. Test for status().isFound [302] with redirect:/user
    1. Test for `flash().attribute("person", hasProperty("name",equalTo("userName")))`
    1. Discuss Testing Triangle

## Going Headless
Create React App
Spring Boot init with Web and JPA

CORS


## Data as backing services
Connect to a Redis Cache

## Controlling the Cache - Getting dirty with Hashtables
Implement our own Hashtable
