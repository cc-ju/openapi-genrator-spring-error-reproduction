package com.example.demo;

import com.example.demo.api.TestApi;
import com.example.demo.api.model.TestObjectPart;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController implements TestApi {

  @Override
  public ResponseEntity<Void> testPost(MultipartFile file, TestObjectPart content) {
    return ResponseEntity.ok().build();
  }
}
