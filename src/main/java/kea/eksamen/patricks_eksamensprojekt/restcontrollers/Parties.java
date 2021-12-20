package kea.eksamen.patricks_eksamensprojekt.restcontrollers;

import kea.eksamen.patricks_eksamensprojekt.models.Candidate;
import kea.eksamen.patricks_eksamensprojekt.models.Party;
import kea.eksamen.patricks_eksamensprojekt.repositories.CandidateRepository;
import kea.eksamen.patricks_eksamensprojekt.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Parties {

    @Autowired
    PartyRepository partyRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @GetMapping("/parties")
    public List<Party> getParties() {
        return partyRepository.findAll();
    }

    @GetMapping("/parties/{id}/candidates")
    public List<Candidate> findAllByParty(@PathVariable Long id) {
        Party party = partyRepository.findById(id).get();
        return candidateRepository.findAllByParty(party);
    }

}
