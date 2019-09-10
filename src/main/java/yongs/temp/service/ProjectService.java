package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.dao.ProjectRepository;
import yongs.temp.model.Project;

@Service
public class ProjectService implements IProject {
	private Logger logger = LoggerFactory.getLogger(ProjectService.class);	

	@Autowired
    ProjectRepository repo;
	
	@Override
	public void create(Project e) {
		logger.debug("flex-project|ProjectService|create()");
		repo.save(e).subscribe();
	}

	@Override
	public Mono<Project> findById(Integer id) {
		logger.debug("flex-project|ProjectService|findById({})", id);
		return repo.findById(id);
	}

	@Override
	public Flux<Project> findByName(String name) {
		logger.debug("flex-project|ProjectService|findByName({})", name);
		return repo.findByName(name);
	}

	@Override
	public Flux<Project> findAll() {
		logger.debug("flex-project|ProjectService|findAll()");
		try {
			Thread.sleep(30000); // 5초 대기
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 		
		return repo.findAll();
	}

	@Override
	public Mono<Project> update(Project e) {
		logger.debug("flex-project|ProjectService|update()");
		return repo.save(e);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		logger.debug("flex-project|ProjectService|delete({})", id);
		return repo.deleteById(id);
	}
}
