package edu.utn.frsr.csi.services;

import edu.utn.frsr.csi.dao.CaseRepository;
import edu.utn.frsr.csi.model.Case;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCase {

    CaseRepository caseRepository;

    public ServiceCase(CaseRepository caseRepository){
        this.caseRepository = caseRepository;
    }

    public List<Case> getAllCases(){
        return caseRepository.findAll();
    }

    public Case create(Case caso){
        return caseRepository.save(caso);
    }


    public void update(Case caso){
        caseRepository.save(caso);
    }

    public Optional<Case> findById(Long id){
        return caseRepository.findById(id);
    }

}
