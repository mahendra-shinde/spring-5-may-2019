# Spring REST and DATA-JPA Demo with MySQL Database

## JPA Configuration (from application.properties file)

```ini
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:mysql://localhost:3306/mydata
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#Overriding default JPA settings
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Enable JPA Repositories (Default: true)
spring.data.jpa.repositories.enabled=true
```



## Database Creation

```sql
CREATE Schema mydata;

Use mydata;

CREATE table employees(
  emp_id int primary key,
  first_name varchar(20),
  last_name varchar(20),
  designation varchar(20),
  salary double
);

INSERT into employees
values(102,'Tammanah','Bhatia','Manager',7600);

INSERT into employees
values(101,'Rajiv','Bhatia','Clerk',2300);
```