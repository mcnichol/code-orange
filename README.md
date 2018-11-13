# Code Orange Talk

## MVC Monoliths
This will show the classic way in how we built monolithic applications.

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
1. Spring Boot init with web,jpa,h2
    1. `@Controller` vs `@RestController`

## Data as backing services
Connect to a Redis Cache

## Controlling the Cache - Getting dirty with Hashtables
Implement our own Hashtable


## Parking Lot
* HA
* Blue / Green
* Migration Patterns - Strangler Pattern
