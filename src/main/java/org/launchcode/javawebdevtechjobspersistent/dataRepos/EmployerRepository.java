package org.launchcode.javawebdevtechjobspersistent.dataRepos;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}