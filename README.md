# Spring Boot Twitter clone web service  
## Description
Restful twitter clone backend api. Able to CRUD users/tweets (that belong to users). Test Driven Development, complete with user/tweet controller and repository integration tests. Uses Spring Web, Spring data JPA, H2 database, Swagger for api documentation, and Thyme leaf for landing page.

Add "/swagger-ui.html#/" to end of url for swagger's rest client to test out the app

## How To Run Locally with Spring Tool Suite(STS)
* $git clone [git@github.com:ryanzhou7/SpringTwitter.git](git@github.com:ryanzhou7/SpringTwitter.git)
* Open STS -> File -> Import
* Maven -> Existing Maven Projects
* Choose SpringTwitter as root project
* Right click project -> Run as -> Junit Test

[Tutorial: How to run this on AWS for free](https://medium.com/@ryanzhou7/running-spring-boot-on-amazon-web-services-for-free-f3b0aeec809)

[Tutorial: Connect MySQL workbench to AWS RDS DB](https://medium.com/@ryanzhou7/connecting-a-mysql-workbench-to-amazon-web-services-relational-database-service-36ae1f23d424)

[Tutorial: Amazon Web Services Relational Database Service for your Spring Boot App](https://medium.com/@ryanzhou7/using-aws-rds-for-your-spring-boot-app-ca8f4b09c9b8)

TODO
- [ ] Follow users feature
- [ ] Get following users feed feature
- [ ] Retweet feature
- [ ] Comment on tweet feature 
- [ ] Add timestamp attribute in for Tweets
