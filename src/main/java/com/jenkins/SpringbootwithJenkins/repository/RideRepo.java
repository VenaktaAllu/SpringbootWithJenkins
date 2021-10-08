package com.jenkins.SpringbootwithJenkins.repository;

import com.jenkins.SpringbootwithJenkins.Entity.Ride;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RideRepo extends CrudRepository<Ride, Long> {
    List<Ride> findByName(String Name);
}
