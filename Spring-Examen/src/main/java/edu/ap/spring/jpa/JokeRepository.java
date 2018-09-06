package edu.ap.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ap.spring.models.Joke;

@Repository
//@Transactional
public interface JokeRepository extends CrudRepository<Joke, Long> {
}
