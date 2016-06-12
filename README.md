# spring-boot-tutorial
spring boot tutorial


# step 1




# step 10
deploying spring boot app
spring boot has the capability to run the jar as a script - to be able to run as a service.
you can pass arguments to it like JAVA_HOME, JAVA_OPTS and many nore.
more details here:
http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/html/deployment-install.html#deployment-service


add this snippet to your deplyment app:

file {'/etc/rc.d/init.d/LPBootApp':
    ensure => 'link',
    target => "/liveperson/code/myBootApp/myBootApp-1.0.0.0.jar",
  }
  
  
this will create a service that can get commands like start stop status & restart


