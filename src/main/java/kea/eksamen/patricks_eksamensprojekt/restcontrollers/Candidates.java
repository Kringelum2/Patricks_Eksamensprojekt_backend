package kea.eksamen.patricks_eksamensprojekt.restcontrollers;

import kea.eksamen.patricks_eksamensprojekt.models.Candidate;
import kea.eksamen.patricks_eksamensprojekt.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Candidates {

    @Autowired
    CandidateRepository candidateRepository;

    @GetMapping("/candidates")
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

    @GetMapping("/candidates/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateRepository.findById(id).get();
    }

    @PostMapping("/candidates")
    public Candidate addCandidate(@RequestBody Candidate newCandidate) {
        return candidateRepository.save(newCandidate);
    }

    @PutMapping("/candidates/{id}")
    public Candidate updateCandidateById(@PathVariable Long id, @RequestBody Candidate candidateToUpdateWith) {
        if (candidateRepository.existsById(id)) {
            candidateToUpdateWith.setId(id);

            return candidateRepository.save(candidateToUpdateWith);
        } else {
            return null;
        }
    }

    @DeleteMapping("/candidates/{id}")
    public void deleteCandidateById(@PathVariable Long id) {
        candidateRepository.deleteById(id);
    }

}
