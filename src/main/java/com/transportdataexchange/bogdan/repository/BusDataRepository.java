package com.transportdataexchange.bogdan.repository;

import com.transportdataexchange.bogdan.model.BusData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusDataRepository extends JpaRepository<BusData, Integer> {
}
