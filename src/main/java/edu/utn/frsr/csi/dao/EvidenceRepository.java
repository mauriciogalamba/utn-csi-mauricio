package edu.utn.frsr.csi.dao;

import edu.utn.frsr.csi.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Long>{

}
