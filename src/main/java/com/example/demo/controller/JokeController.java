package com.example.demo.controller;

import com.example.demo.entity.Joke;
import com.example.demo.service.JokeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class JokeController {
    private final JokeService service;

    @GetMapping("/getAll")
    public List<Joke> getAll() {
        return service.getAll();
    }

    @GetMapping("/getById")
    public ResponseEntity<Joke> getById(@RequestParam(name = "id") Long id) {
        return service.getById(id);
    }

    @GetMapping("/getAllByType")
    public List<Joke> getAllByStatus(@RequestParam("type") Joke.Type type) {
        return service.getAllByType(type);
    }

    @PostMapping("/addNew")
    public Joke addNewJoke(@RequestBody Joke joke) {
        return service.addNewJoke(joke);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteById(@RequestParam("id") Long id) {
        return service.deleteById(id);
    }

    @PatchMapping("/updateValueById")
    public ResponseEntity<Joke> updateValueById(@RequestParam("id") Long id, @RequestParam("value") String value) {
        return service.updateValueById(id, value);
    }

    @PatchMapping("/updateTypeById")
    public ResponseEntity<Joke> updateTypeById(@RequestParam("id") Long id, @RequestParam("type") Joke.Type value) {
        return service.updateJokeTypeByID(id, value);
    }
}
