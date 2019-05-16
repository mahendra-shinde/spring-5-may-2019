## Spring Core & Spring Boot

This repository contains demos from my May-2019 batch.

## Setting up offline maven repository for all demos

Please use my other [Git Repository](https://github.com/mahendra-shinde/maven-repo-springboot) for downloading entire maven repository in local filesystem. 
I have included a ReadMe to describe all the steps on how to setup this repository.

NOTE: Spring framework version included in this offline repository are:
        
  1.  Spring-framework 5.1.6
  2.  Spring-Boot 2.1.4
  3.  Hibernate-core 5.3.9
  4.  Oracle JDBC Driver 6.0

      > NOTE:
      This repository includes maven compiler plugin 2.6 and 3.8 only.
      In case your IDE is using any different version of maven plugins, please 
      add maven-compiler-plugin version 2.6 or 3.8 in your pom.xml file.


## Demos / Walkthroughs

I have included few demos & their walkthroughs:

Demo | Directory | Walkthrough 
-----|-----------|------------
Spring MVC (XML Config) | [webdemo1](webdemo1/) | [Walkthrough](spring-mvc-steps1.md)
Spring MVC (Java Config)| [javaconfigwebdemo](javaconfigwebdemo/) | [Walkthrough](java-config-webmvc-steps.md)
Spring MVC Forms | [form-without-validation](form-without-validation/) | [Walkthrough](spring-mvc-forms-steps.md)
Spring MVC Form Validation | [form-with-validation](form-with-validation/) | [Walkthrough](mvc-validation-steps.md)
Spring ORM (JPA) | [jpademo1](jpademo1/) | [Walkthrough](spring-jpa-steps.md)
Spring Boot Web Basic | [bootdemo1](bootdemo1/) | [Walkthrough](spring-boot-web-steps.md)
Spring Boot data-jpa | [bootdemo2](bootdemo2/) | [Walkthrough](spring-boot-data-jpa-steps.md)
