package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@WebMvcTest(TestController.class)
class TestControllerControllerMockMvcTest {

  @Autowired
  WebTestClient webClient;

  @Test
  void should_be_able_to_handle_multipart_request() {
    var bodyBuilder = new MultipartBodyBuilder();
    bodyBuilder
        .part("file", "")
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .filename("nice-file.csv");
    bodyBuilder
        .part("content", "{\"foo\": \"123\", \"bar\": 5}")
        .contentType(MediaType.APPLICATION_JSON);

    webClient
        .post()
        .uri("/test")
        .body(BodyInserters.fromMultipartData(bodyBuilder.build()))
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk();
  }
}
