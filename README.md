# Spring Boot Twitter clone web service  
## Description
Restful twitter clone backend api. Able to CRUD users/tweets (that belong to users). Complete with user/tweet controller and repository integration tests. Uses Spring MVC, Spring data JPA, H2 database, swagger for api documentation, and thyme leaf for landing page.

## App Running on AWS
[ ] Update link
http://localhost:8080/swagger-ui.html#/ 
Visit http://localhost:8080/swagger-ui.html#/ for swagger's rest client to test out the app

## How To Run Locally with Spring Tool Suite(STS)
* $git clone git@github.com:ryanzhou7/SpringTwitter.git
* Open STS -> File -> Import
* Maven -> Existing Maven Projects
* Choose SpringTwitter as root project
* Right click project -> Run as -> Junit Test

Tutorial (https://medium.com/@ryanzhou7/running-spring-boot-on-amazon-web-services-for-free-f3b0aeec809) on how to run this on AWS for free.

TODO
- [ ] Switch to MySql for database
- [ ] Configure MySql database on AWS and deploy
- [ ] Follow users feature
- [ ] Get following users feed feature
- [ ] Implement HATEOUS for Level 3 Richardson Restful maturity
