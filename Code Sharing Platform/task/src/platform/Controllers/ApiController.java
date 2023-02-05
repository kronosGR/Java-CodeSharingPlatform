package platform.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.Models.Code;
import platform.Services.Service;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    Service service;

    @GetMapping(path = "/code/{id}")
    @ResponseBody
    public ResponseEntity<Code> getCodeById(@PathVariable String id) {
        return ResponseEntity.ok().header("Content-Type", "application/json")
                .body(service.getCodeById(id));
    }

    @PostMapping(path = "/code/new")
    @ResponseBody
    public ResponseEntity<String> putCode(@RequestBody Code code) {
        return ResponseEntity.ok().header("Content-Type", "application/json")
                .body(Map.of("id", "\""+service.putCode(code).toString()+"\"").toString());
    }

    @GetMapping(path = "/code/latest")
    @ResponseBody
    public ResponseEntity<List<Code>> getLatest() {
        return ResponseEntity.ok().header("Content-Type", "application/json")
                .body(service.getLatestCode());
    }
}
