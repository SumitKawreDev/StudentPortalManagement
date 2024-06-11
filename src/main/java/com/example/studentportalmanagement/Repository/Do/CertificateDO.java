package com.example.studentportalmanagement.Repository.Do;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "certificate")
public class CertificateDO {

    @Id
    @Column(name = "certificate_id")
    public int certificateId;
    @Column(name = "certificate_type")
    public String certificateType;
    @Column(name = "certificate_year")
    public int certificateYear;

    public int getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public int getCertificateYear() {
        return certificateYear;
    }

    public void setCertificateYear(int certificateYear) {
        this.certificateYear = certificateYear;
    }
}
