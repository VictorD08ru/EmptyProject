package tk.djandjiev.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import tk.djandjiev.practice.AbstractTest;

public abstract class AbstractControllerTest extends AbstractTest {

  @Autowired
  protected TestRestTemplate restTemplate;

  final static String ROOT_URL = "http://localhost:8888/api";
}
