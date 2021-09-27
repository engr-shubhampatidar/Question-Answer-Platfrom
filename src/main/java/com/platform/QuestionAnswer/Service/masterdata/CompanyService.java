package com.platform.QuestionAnswer.Service.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Company;
import com.platform.QuestionAnswer.Repositiory.master.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompany() {
       return companyRepository.findAll();
    }

    public void postCompany(Company company) {
        companyRepository.save(company);
    }

    @Transactional
    public void updateCompany(Long company_id, String company) {
        Company company1 = companyRepository.findById(company_id).orElseThrow(() ->
                new IllegalStateException("Company with id" + company_id + " does not exits"));
        if(company != null &&
                company.length() > 0 ){
            company1.setCompany(company);
        }
    }

    public void deleteCompany(Long company_id) {
        companyRepository.deleteById(company_id);
    }
}
