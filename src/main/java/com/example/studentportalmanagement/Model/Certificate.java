package com.example.studentportalmanagement.Model;

public class Certificate {
    public int certificateId;
    public String certificateType;
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
