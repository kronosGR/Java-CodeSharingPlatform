package platform.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping(path = "/code")
    @ResponseBody
    public ResponseEntity<?> getCode() {
        return ResponseEntity.ok().header("Content-Type", "application/json")
                .body(Map.of("code","public static void main(String[] args) {    SpringApplication.run(CodeSharingPlatform.class, args);}"));
    }
}
