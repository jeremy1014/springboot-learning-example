package com.jeremy.webflux.dao;

import com.jeremy.webflux.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {

}
