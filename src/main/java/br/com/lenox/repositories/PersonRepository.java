package br.com.lenox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lenox.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
