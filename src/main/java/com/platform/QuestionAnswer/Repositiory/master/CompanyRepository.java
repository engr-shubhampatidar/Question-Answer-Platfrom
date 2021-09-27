package com.platform.QuestionAnswer.Repositiory.master;

import com.platform.QuestionAnswer.Model.masterdata.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
//    @Modifying
//    @Query("UPDATE company c SET u.company = :company WHERE u.company_id = :company_id")
//    void updateCompany(@Param(value = "company_id") Long company_id, String company);

//    Company findById(Long id);

}
