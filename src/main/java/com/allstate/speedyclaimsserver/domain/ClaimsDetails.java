package com.allstate.speedyclaimsserver.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ClaimsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claimId;

    @ManyToOne
    @JoinColumn(name="customerID", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double estimatedValue;

    @Column(nullable = false)
    private LocalDate claimOpenDate = LocalDate.now();

    @Column(nullable = false)
    private String claimReason;

    @Column(nullable = false)
    private String claimDescription;

    @Column(nullable = false)
    private LocalDate incidentDate;
    private String furtherDetails;

    // Motor fields
    private String make;
    private String model;
    private Integer year;

    // Property fields
    private String address;

    // Pet fields
    private String animalType;
    private String breed;

    public ClaimsDetails() {
    }

    public ClaimsDetails(Integer claimId, Customer customer, String status, String type, Double estimatedValue, LocalDate claimOpenDate, String claimReason, String claimDescription, LocalDate incidentDate, String furtherDetails, String make, String model, Integer year, String address, String animalType, String breed) {
        this.claimId = claimId;
        this.customer = customer;
        this.status = status;
        this.type = type;
        this.estimatedValue = estimatedValue;
        this.claimOpenDate = claimOpenDate;
        this.claimReason = claimReason;
        this.claimDescription = claimDescription;
        this.incidentDate = incidentDate;
        this.furtherDetails = furtherDetails;
        this.make = make;
        this.model = model;
        this.year = year;
        this.address = address;
        this.animalType = animalType;
        this.breed = breed;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getEstimatedValue() {
        return estimatedValue;
    }

    public void setEstimatedValue(Double estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public LocalDate getClaimOpenDate() {
        return claimOpenDate;
    }

    public void setClaimOpenDate(LocalDate claimOpenDate) {
        this.claimOpenDate = claimOpenDate;
    }

    public String getClaimReason() {
        return claimReason;
    }

    public void setClaimReason(String claimReason) {
        this.claimReason = claimReason;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getFurtherDetails() {
        return furtherDetails;
    }

    public void setFurtherDetails(String furtherDetails) {
        this.furtherDetails = furtherDetails;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "ClaimsDetails{" +
                "claimId=" + claimId +
                ", customer=" + customer +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", estimatedValue=" + estimatedValue +
                ", claimOpenDate=" + claimOpenDate +
                ", claimReason='" + claimReason + '\'' +
                ", claimDescription='" + claimDescription + '\'' +
                ", incidentDate=" + incidentDate +
                ", furtherDetails='" + furtherDetails + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", address='" + address + '\'' +
                ", animalType='" + animalType + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
