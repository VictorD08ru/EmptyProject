package tk.djandjiev.practice.controller;

import org.junit.Before;
import org.springframework.web.client.RestTemplate;
import tk.djandjiev.practice.AbstractTest;

public abstract class AbstractControllerTest extends AbstractTest {

  protected RestTemplate restTemplate;

  final static String ROOT_URL = "http://localhost:8888/api";

  @Before
  public void setUp() {
    restTemplate = new RestTemplate();
  }

}
