package com.ryanzhou.controller;

import com.ryanzhou.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FollowerControllerIntegrationTest {


    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;
    
    private final String url = "http://localhost:";
    private String fullUrl;
    private final String api =  "/api/followers";

    @Before
    public void init() {

        fullUrl = String.format("%S%S%S", url, port, api);
    }

    @Test
    public void createFollowTest(){

    }

    @Test
    public void deleteFollowTest(){


    }

}
