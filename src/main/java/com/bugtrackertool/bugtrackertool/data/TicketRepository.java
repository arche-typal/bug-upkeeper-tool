package com.bugtrackertool.bugtrackertool.data;

import com.bugtrackertool.bugtrackertool.models.TestModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<TestModel, Integer> {
}
