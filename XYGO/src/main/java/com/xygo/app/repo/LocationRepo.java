package com.xygo.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xygo.app.entity.Location;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {

}
