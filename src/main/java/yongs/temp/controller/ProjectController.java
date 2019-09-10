package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.model.Project;
import yongs.temp.service.ProjectService;

@RestController
public class ProjectController {
	private Logger logger = LoggerFactory.getLogger(ProjectController.class);
	@Autowired
    private ProjectService service;
	
    @PostMapping("/project/create") /* Postman 프로그램으로 실행 */
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Project e) {
    	logger.debug("flex-project|ProjectController|create()");
        service.create(e);
    }
    
    @GetMapping("/project/id/{id}")
    public ResponseEntity<Mono<Project>> findById(@PathVariable("id") Integer id) {
    	logger.debug("flex-project|ProjectController|findById({})", id);
    	Mono<Project> e = service.findById(id);
        HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Project>>(e, status);
    }
 
    @GetMapping("/project/name/{name}")
    public Flux<Project> findByName(@PathVariable("name") String name) {
    	logger.debug("flex-project|ProjectController|findByName({})", name);
        return service.findByName(name);
    }
 
    @GetMapping("/projects")
    public Flux<Project> findAll() {
    	logger.debug("flex-project|ProjectController|findAll()");    	
        Flux<Project> emps = service.findAll();
        return emps;
    }
 
    @PutMapping("/project/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Project> update(@RequestBody Project e) {
    	logger.debug("flex-project|ProjectController|update()");    	    	
        return service.update(e);
    }
 
    @DeleteMapping("/project/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") Integer id) {
    	logger.debug("flex-project|ProjectController|delete({})", id);      	
        return service.delete(id);
    }
}
