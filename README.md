# mitbook-kunlun
Implement high performance netty server based on netty to replace traditional Tomcat

# logo
<center>  <!--Start center alignment-->

![kunlun](http://120.77.168.166/kunlun.jpeg "kunlun")
</center> <!--End center alignment-->

# Introduction to the framework

> 1.This framework is to replace the built-in Tomcat container of springboot. It can be written by netty framework, which can connect with springboot seamlessly. In the future, it can support cluster. Secondly, the programming mode is no different from the traditional programming mode, and it is not as difficult to understand as responsive programming. The framework has the advantages of low learning cost and standard coding.

# Framework instructions:
> 1.Introducing engineering dependencies:
>>  
```
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-web</artifactId>
     <exclusions>
         <exclusion>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-starter-tomcat</artifactId>
         </exclusion>
     </exclusions>
 </dependency>
 <dependency>
     <groupId>io.netty</groupId>
     <artifactId>netty-all</artifactId>
     <version>4.1.49.Final</version>
 </dependency>
 <dependency>
     <groupId>org.apache.commons</groupId>
     <artifactId>commons-lang3</artifactId>
     <version>3.10</version>
 </dependency>
 <dependency>
     <groupId>com.google.guava</groupId>
     <artifactId>guava</artifactId>
     <version>23.0</version>
 </dependency>
 <dependency>
     <groupId>com.google.code.gson</groupId>
     <artifactId>gson</artifactId>
     <version>2.8.6</version>
 </dependency>
 <dependency>
     <groupId>org.projectlombok</groupId>
     <artifactId>lombok</artifactId>
     <optional>true</optional>
 </dependency>
 <dependency>
     <groupId>mysql</groupId>
     <artifactId>mysql-connector-java</artifactId>
     <scope>runtime</scope>
 </dependency>
```


# Official link
Welcome to read [Official document](https://www.yuque.com/mryuji/kb/ih222h "Official document")
