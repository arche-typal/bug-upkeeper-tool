package com.bugtrackertool.bugtrackertool.data;

import com.bugtrackertool.bugtrackertool.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
