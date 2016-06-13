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
```  
<include resource="org/springframework/boot/logging/logback/defaults.xml" />
<property name="LOG_FILE" value="${LOG_FILE:-${LOG_PATH:-${LOG_TEMP:-${java.io.tmpdir:-/tmp}}/}spring.log}"/>
<include resource="org/springframework/boot/logging/logback/console-appender.xml" />
<include resource="org/springframework/boot/logging/logback/file-appender.xml" />
```
# Step 7
JDBC
```
git checkout step7
```
this will enable us to access a DB (fully preconfigured by spring boot)
by creating a pojo as an Entity, and creating an interface of Repository (no implementation class needed!) 

add dependency for the JPA starter:
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

```

and for H2 db:
```
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
```
have a look at Person pojo & PersonRepository interace

custom health check: have a look at H2Health - it implements a HealthIndicator and can tell the service when this component is UP or DOWN
http://localhost:8090/health

Task 1:
implement GET by id as a rest operation in PersonController

Task 2: implement all CRUD operations, paging,  page size , search by name ,add links - self , prev , next.
what??? how is anyone supposed to implement all that in 1 hour tutorial?? 
lets wait with this task for the next step...

# Step 8
JPA REST 
Spring boot has built in support to "Restify" the repository

add this dependency:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-rest</artifactId>
</dependency>
```
add @RepositoryRestResource to our PersonRepository
and @Param("name") to the name parameter in method findPersonByName

have a look at all the available REST operations:
http://localhost:8090/persons/

#Step 9
custom metric

when we looked at the rest resources - we saw we have metrics for every request, but what about a metric for websocket?
lets try to add a custom metric for messages count.


# step 10
deploying spring boot app
spring boot has the capability to run the jar as a script - to be able to run as a service.
you can pass arguments to it like JAVA_HOME, JAVA_OPTS and many more.
more details here:
http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/deployment-install.html#deployment-service


add this snippet to your deployment app:
```
file {'/etc/rc.d/init.d/LPBootApp':
    ensure => 'link',
    target => "/liveperson/code/<myBootApp>/<myBootApp-1.0.0.0.jar>",
  }
```  
  
this will create a service that can get commands like start stop status & restart


