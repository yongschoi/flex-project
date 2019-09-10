package yongs.temp.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import yongs.temp.model.Project;

public interface ProjectRepository extends ReactiveMongoRepository<Project, Integer> {
	@Query("{ 'name': ?0 }")
    Flux<Project> findByName(final String name);
}
