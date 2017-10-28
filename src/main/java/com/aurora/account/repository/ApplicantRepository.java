package com.aurora.account.repository;
import com.aurora.account.model.Applicant;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, String> {
  
}
