package com.keyin.policecasesystem;

public class PoliceCase {
    private String caseNumber;
    private String description;
    private String status;

    public PoliceCase(String caseNumber, String description, String status) {
        this.caseNumber = caseNumber;
        this.description = description;
        this.status = status;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PoliceCase{" +
                "caseNumber='" + caseNumber + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
