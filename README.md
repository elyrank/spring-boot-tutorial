# spring-boot-tutorial - "Bootiful" Applications with Spring Boot


# step 1
basic app with rest

checkout step 1:
```
git checkout step1
```

In this step we have a basic web application with a rest resource
run application.java and open your browser: 
http://localhost:8080/

note that the server runs automatically on port 8080 , and using embedded tomcat.
to change the port - uncomment the server.port property in applicaion.properties

unit test:
we have a unit test for this rest resource: HelloControllerTest
MockMvc is used to test the rest resources without loading the whole server

Integration test:
HelloControllerItTest
in this test we start the server with a random port:
```
@IntegrationTest({"server.port=0"}) //generate a random port
```
and we can use the random port with this property:

```
@Value("${local.server.port}") //get the generated port
private int port;
```

now by using Spring's Http Client - RestTemplate
we can send a request to our resuorce.

# step 2
actuator

checkout step 2:
```
git checkout step2
```

we added this dependency in the pom:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

The actuator provides production ready features to help you monitor and manage your application
for example, try running the following resources : /metrics /health /mappings /beans
all this data that is also available via JMX

# step 3
websocket

checkout step 3:
```
git checkout step3
```
two classes added: WsHandler & WsConfig
in WsConfig we define the handlers, and WsHandler is our handler.

task:
implement a welcome message when connecting.

- hint: implement method afterConnectionEstablished

# Step 4
```
git checkout step4
```
websocket - welcome message

# Step 5
change implementation to Jetty
```
git checkout step5
```
all we need to do to change to implementation is add the right dependency:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jetty</artifactId>
</dependency>
```

# Step 6
log configuration
by default - spring boot has its own logback configuration
```
git checkout step6
```
added logback.xml but still using spring defaults - by including them

# Step 7
JDBC
```
git checkout step7
```
have a look at the Person pojo - it is annotated as an Entity
have a look at the PersonRepository - it is an interface for working with Repositories (no implementation class needed! - spring boot does that for you)

Task 1:
implement Rest request get by ID in PersonController

Task 2:
implement CRUD , paging, limit, search by name.
what?!? how is anyone supposed to do all that in a 1 hour tutorial?? 
lets proceed to the next step to see...

# Step 8


# step 10
deploying spring boot app
spring boot has the capability to run the jar as a script - to be able to run as a service.
you can pass arguments to it like JAVA_HOME, JAVA_OPTS and many more.
more details here:
http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/deployment-install.html#deployment-service


add this snippet to your deplyment app:
```
file {'/etc/rc.d/init.d/LPBootApp':
    ensure => 'link',
    target => "/liveperson/code/myBootApp/myBootApp-1.0.0.0.jar",
  }
```  
  
  
this will create a service that can get commands like start stop status & restart


