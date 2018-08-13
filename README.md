# Grade-one-entrance evauating system for ministry of Education
Database systems project - semester 03 - Departmant of Computer Science and Engineering, University of Moratuwa, Sri Lanka.

[<img src='https://spring.io/img/homepage/icon-spring-framework.svg' width=50>](https://spring.io/)
[<img src='http://www.mslc.in/documents/213220/214533/spring-security.png' width=70>](https://spring.io/projects/spring-security)
[<img src='https://upload.wikimedia.org/wikipedia/en/thumb/6/62/MySQL.svg/125px-MySQL.svg.png' width=70>](https://www.mysql.com/)
[<img src='http://www.howcsharp.com/img/0/52/hibernate-orm-300x223.jpg' width=50>](http://hibernate.org/)
[<img src='https://junit.org/junit4/images/junit-logo.png' width=70>](hhttps://junit.org/junit4/)
[<img src='https://cdn.javacodeexamples.com/wp-content/uploads/Jsoup.png' width=70>](https://jsoup.org/)
[<img src='https://d2j3q9yua85jt3.cloudfront.net/img/56a5316af9a2f1eccace40a79c06373f' width=50>](https://mvnrepository.com/artifact/org.xhtmlrenderer/flying-saucer-pdf)
[<img src='http://www.mkyong.com/wp-content/uploads/2015/06/jetty-big-logo.png' width=70>](https://www.eclipse.org/jetty/)
[<img src='https://s25037.pcdn.co/wp-content/uploads/validate.png' width=70>](https://jqueryvalidation.org/)

# Runing instructions
## Edit configurations

1. Copy **resources/application.properties.sample** as **resources/application.properties**.
2. Add database credentials to the file and save.
3. Copy **resources/mail.properties.sample** as **resources/mail.properties**.
4. Add e-mail credentials to the file and save.
5. Run **resources/db.sql** on your database server console.
6. Go to https://myaccount.google.com/lesssecureapps if you use **GMAIL** to development and enable service.

## Run by source code
Browse the root directory that contains pom.xml and run:
```sh
mvn clean install
mvn jetty:run
```
## Run by War executable
Browse the root directory that contains pom.xml and run:
```sh
mvn clean install
```
move **target/GradeOneSys-1.0-SNAPSHOT.war** to servers webapp folder or upload it by admin view.

- First login for adding new users is **username : user001** using **password : password1**

# Features
1. Role based authentiacation that loads dinamic views and handles functionalities over contollers.
2. Forced password change in initial login.
3. Database functions and triggers to improve perfomance.
4. Html formatted Email sending.
5. Html formatted PDF creation.
6. Live validations for all data entry forms.


