package com.islam.demo.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface CountriesRepository extends JpaRepository<Countries, String> 
{
    List<Countries> findAll(String cntrycode);
}