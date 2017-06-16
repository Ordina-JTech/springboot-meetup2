package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AirplaneRepository extends JpaRepository<Airplane, Long> {

    Airplane findByName(String name);
}
