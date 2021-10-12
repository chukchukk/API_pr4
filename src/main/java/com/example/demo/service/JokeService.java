package com.example.demo.service;

import com.example.demo.entity.Joke;
import com.example.demo.repository.JokeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JokeService {
    private final JokeRepository repository;
    private Joke notFound;

    public JokeService(JokeRepository repository) {
        this.repository = repository;
        this.notFound = new Joke();
        notFound.setValue("Not found");
    }

    public List<Joke> getAll() {
        return (List<Joke>) repository.findAll();
    }

    public ResponseEntity<Joke> getById(Long id) {
        Optional<Joke> joke = repository.findById(id);
        if(joke.isPresent()) {
            return ResponseEntity.ok(joke.get());
        } else {
            return ResponseEntity.status(404).body(notFound);
        }
    }

    public List<Joke> getAllByType(Joke.Type type) {
        return repository.findAllByJokeType(type);
    }

    public Joke addNewJoke(Joke joke) {
        return repository.save(joke);
    }

    public ResponseEntity<String> deleteById(Long id) {
        Optional<Joke> byId = repository.findById(id);
        if(byId.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().body("Was deleted " + byId.get());
        }
        return ResponseEntity.status(404).body("Not found.");
    }

    public ResponseEntity<Joke> updateValueById(Long id, String value) {
        Optional<Joke> byId = repository.findById(id);
        if(byId.isPresent()) {
            Joke joke = byId.get();
            joke.setValue(value);
            Joke saved = repository.save(joke);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.status(404).body(notFound);
        }
    }

    public ResponseEntity<Joke> updateJokeTypeByID(Long id, Joke.Type type) {
        Optional<Joke> byId = repository.findById(id);
        if(byId.isPresent()) {
            Joke joke = byId.get();
            joke.setJokeType(type);
            Joke saved = repository.save(joke);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.status(404).body(notFound);
        }
    }
}
