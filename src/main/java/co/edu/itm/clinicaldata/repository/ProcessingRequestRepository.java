package co.edu.itm.clinicaldata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.itm.clinicaldata.model.ProcessingRequest;

@Repository
public interface ProcessingRequestRepository extends JpaRepository<ProcessingRequest, Long> {

    ProcessingRequest findByIdentifier(String identifier);

    List<ProcessingRequest> findByInvestigatorId(Long investigatorId);

}
