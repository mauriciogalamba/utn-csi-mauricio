package edu.utn.frsr.csi.services;

import edu.utn.frsr.csi.dao.EvidenceRepository;
import edu.utn.frsr.csi.model.Evidence;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceEvidence {

    EvidenceRepository evidenceRepository;

    public ServiceEvidence(EvidenceRepository evidenceRepository){
        this.evidenceRepository = evidenceRepository;
    }

    public List<Evidence> getAllEvidences(){
        return evidenceRepository.findAll();
    }

    public Evidence create(Evidence evidence){
        return evidenceRepository.save(evidence);
    }


    public void update(Evidence evidence){
        evidenceRepository.save(evidence);
    }

    public Optional<Evidence> findById(Long id){
        return evidenceRepository.findById(id);
    }

}
