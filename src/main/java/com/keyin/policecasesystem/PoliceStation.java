package com.keyin.policecasesystem;

import java.util.ArrayList;
import java.util.List;

public class PoliceStation {
    private int stationId;
    private String name;
    private String address;
    private String phoneNumber;
    private List<PoliceCase> policeCases;

    public PoliceStation(int stationId, String name, String address, String phoneNumber) {
        this.stationId = stationId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.policeCases = new ArrayList<PoliceCase>();
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<PoliceCase> getPoliceCases() {
        return policeCases;
    }

    public void setPoliceCases(List<PoliceCase> policeCases) {
        this.policeCases = policeCases;
    }
    public void addPoliceCase(PoliceCase policeCase) {

        if(policeCase.getCaseNumber().isEmpty()){
            throw new IllegalArgumentException("Case number cannot be empty");
        }
        if(policeCase.getDescription().isEmpty()){
            throw new IllegalArgumentException("Description cannot be empty");
        }
        if(policeCase.getStatus().isEmpty()){
            throw new IllegalArgumentException("Status cannot be empty");
        }
        if(policeCase.getCaseNumber().length() > 10){
            throw new IllegalArgumentException("Case number cannot be more than 10 characters");
        }

        this.policeCases.add(policeCase);
    }
}
