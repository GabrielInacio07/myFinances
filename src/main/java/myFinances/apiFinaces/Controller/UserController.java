package myFinances.apiFinaces.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class UserController {

    @GetMapping
    public ResponseEntity<String> helloWord(){

        return ResponseEntity.ok("Hello World");
    }
}
