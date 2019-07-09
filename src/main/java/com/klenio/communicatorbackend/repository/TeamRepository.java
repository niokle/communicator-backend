package com.klenio.communicatorbackend.repository;

import com.klenio.communicatorbackend.domain.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends CrudRepository<Team, Long> {
    @Override
    List<Team> findAll();

    @Override
    Optional<Team> findById(Long id);

    @Override
    Team save(Team team);

    @Override
    void deleteById(Long id);
}
