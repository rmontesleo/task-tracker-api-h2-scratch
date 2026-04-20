package com.demo.tasktracker.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.client.RestTestClient;

import com.demo.tasktracker.dto.TaskDTO;

@SpringBootTest( webEnvironment = WebEnvironment.RANDOM_PORT )
@AutoConfigureRestTestClient
@ActiveProfiles("test")
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RestTestClient restTestClient;

    @Test
    @Sql("/data.sql")
    void verifyFirstItemExists(){
        var expectedDto = new TaskDTO(1, "Study SpringBoot", "Monday", false);

        restTestClient.get()
            .uri("http://localhost:%d/api/tasks/1".formatted(port))
            .exchange()
            .expectStatus().isOk()
            .expectBody(TaskDTO.class)
            .isEqualTo(expectedDto);
    }

}
