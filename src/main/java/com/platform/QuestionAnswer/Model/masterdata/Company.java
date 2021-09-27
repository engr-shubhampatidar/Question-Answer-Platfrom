package com.platform.QuestionAnswer.Model.masterdata;

import javax.persistence.*;

@Entity
@Table
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long companyId;
    private String company;

//    @ManyToOne(optional = true)
//    @JoinColumn(name = "question_id")
//    private Questions questions;

    public Company() {
    }

    public Company(String company) {
        this.company = company;
    }

    public Company(Long company_id, String company) {
        this.companyId = company_id;
        this.company = company;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + companyId +
                ", company='" + company + '\'' +
                '}';
    }
}
