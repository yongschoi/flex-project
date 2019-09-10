package yongs.temp.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.model.Project;

public interface IProject {
    void create(Project e); 
    Mono<Project> findById(Integer id);
    Flux<Project> findByName(String name);
    Flux<Project> findAll();
    Mono<Project> update(Project e);
    Mono<Void> delete(Integer id);
}
