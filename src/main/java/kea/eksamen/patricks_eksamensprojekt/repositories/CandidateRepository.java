package kea.eksamen.patricks_eksamensprojekt.repositories;

import kea.eksamen.patricks_eksamensprojekt.models.Candidate;
import kea.eksamen.patricks_eksamensprojekt.models.Party;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findAllByParty(Party party);
}
