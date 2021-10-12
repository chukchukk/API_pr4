package com.example.demo.repository;

import com.example.demo.entity.Joke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokeRepository extends CrudRepository<Joke, Long> {
    public List<Joke> findAllByJokeType(Joke.Type type);
}
