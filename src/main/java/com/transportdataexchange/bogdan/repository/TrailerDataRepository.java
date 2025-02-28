package com.transportdataexchange.bogdan.repository;

import com.transportdataexchange.bogdan.model.TrailerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailerDataRepository extends JpaRepository<TrailerData,Integer> {
}
