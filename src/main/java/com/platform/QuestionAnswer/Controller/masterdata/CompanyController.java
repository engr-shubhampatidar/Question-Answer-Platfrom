package com.platform.QuestionAnswer.Controller.masterdata;

import com.platform.QuestionAnswer.Model.masterdata.Company;
import com.platform.QuestionAnswer.Service.masterdata.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "/company")
public class CompanyController {
    @Autowired
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/company")
    List<Company> getCompany(){
        return companyService.getCompany();
    }

    @ResponseBody
    @PostMapping(path = "/company")
    void postCompany(@RequestBody Company company){
        companyService.postCompany(company);
    }



    @PutMapping(path = "/company/{companyId}")
    void updateCompany(@PathVariable Long companyId,@RequestParam String company){
        companyService.updateCompany(companyId, company);
    }

    @DeleteMapping(path = "/company/{companyId}")
    void deleteCompany(@PathVariable Long companyId){
        companyService.deleteCompany(companyId);
    }
}
