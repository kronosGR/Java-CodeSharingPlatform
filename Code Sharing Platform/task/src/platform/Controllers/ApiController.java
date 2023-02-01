package platform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.Models.Code;
import platform.Services.Service;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    Service service;

    @GetMapping(path = "/code")
    @ResponseBody
    public ResponseEntity<Code> getCode() {
        return ResponseEntity.ok().header("Content-Type", "application/json")
                .body(service.getCode());
    }

    @PostMapping(path  ="/code/new")
    @ResponseBody
    public ResponseEntity<String> updateCode(@RequestBody Code code){
        service.updateCode(code);
        return ResponseEntity.ok().body("{}");
    }
}
