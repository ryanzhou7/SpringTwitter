# Spring Boot Twitter clone web service  
## Description
Restful twitter clone backend api. Able to CRUD users/tweets (that belong to users). Complete with user/tweet controller and repository integration tests. Uses Spring Web, Spring data JPA, H2 database, Swagger for api documentation, and Thyme leaf for landing page.

## [App Running on AWS](http://springtwitter-env.byeuzxsjhm.us-west-1.elasticbeanstalk.com)
[http://springtwitter-env.byeuzxsjhm.us-west-1.elasticbeanstalk.com](http://springtwitter-env.byeuzxsjhm.us-west-1.elasticbeanstalk.com)

Add "/swagger-ui.html#/" to end of url for swagger's rest client to test out the app or click

[http://springtwitter-env.byeuzxsjhm.us-west-1.elasticbeanstalk.com/swagger-ui.html#/](http://springtwitter-env.byeuzxsjhm.us-west-1.elasticbeanstalk.com/swagger-ui.html#/)

## How To Run Locally with Spring Tool Suite(STS)
* $git clone [git@github.com:ryanzhou7/SpringTwitter.git](git@github.com:ryanzhou7/SpringTwitter.git)
* Open STS -> File -> Import
* Maven -> Existing Maven Projects
* Choose SpringTwitter as root project
* Right click project -> Run as -> Junit Test

[Tutorial](https://medium.com/@ryanzhou7/running-spring-boot-on-amazon-web-services-for-free-f3b0aeec809) on how to run this on AWS for free.

TODO
- [ ] Switch to MySql for database
- [ ] Configure MySql database on AWS and deploy
- [ ] Follow users feature
- [ ] Get following users feed feature
- [ ] Retweet feature
- [ ] Comment on tweet feature 
- [ ] Add timestamp attribute in for Tweets 
- [ ] Implement HATEOUS for Level 3 Richardson Restful maturity
