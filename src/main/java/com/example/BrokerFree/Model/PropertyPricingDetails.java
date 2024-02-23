package com.example.BrokerFree.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "property_pricing_details")
public class PropertyPricingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="expectedRent")
    private double expectedRent;
    
    @Column(name="expecteddeposit")
    private double expecteddeposit;

    @Column(name="extraCharge")
    private String extraCharge;

    @Column(name="priceNegotiable")
    private String priceNegotiable;

    @Column(name="agreementDuration")
    private String agreementDuration;

    @Column(name="noticeTime")
    private String noticeTime;

    @Column(name="additionalDetails")
    private String additionalDetails;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getExpectedRent() {
		return expectedRent;
	}

	public void setExpectedRent(double expectedRent) {
		this.expectedRent = expectedRent;
	}

	public double getExpecteddeposit() {
		return expecteddeposit;
	}

	public void setExpecteddeposit(double expecteddeposit) {
		this.expecteddeposit = expecteddeposit;
	}

	public String getExtraCharge() {
		return extraCharge;
	}

	public void setExtraCharge(String extraCharge) {
		this.extraCharge = extraCharge;
	}

	public String getPriceNegotiable() {
		return priceNegotiable;
	}

	public void setPriceNegotiable(String priceNegotiable) {
		this.priceNegotiable = priceNegotiable;
	}

	public String getAgreementDuration() {
		return agreementDuration;
	}

	public void setAgreementDuration(String agreementDuration) {
		this.agreementDuration = agreementDuration;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}



	@Override
	public String toString() {
		return "PropertyPricingDetails [id=" + id + ", expectedRent=" + expectedRent + ", expecteddeposit="
				+ expecteddeposit + ", extraCharge=" + extraCharge + ", priceNegotiable=" + priceNegotiable
				+ ", agreementDuration=" + agreementDuration + ", noticeTime=" + noticeTime + ", additionalDetails="
				+ additionalDetails  + "]";
	}

	public PropertyPricingDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyPricingDetails(Long id, double expectedRent, double expecteddeposit, String extraCharge,
			String priceNegotiable, String agreementDuration, String noticeTime, String additionalDetails,
			PropertyBasicDetails propertyBasicDetails) {
		super();
		this.id = id;
		this.expectedRent = expectedRent;
		this.expecteddeposit = expecteddeposit;
		this.extraCharge = extraCharge;
		this.priceNegotiable = priceNegotiable;
		this.agreementDuration = agreementDuration;
		this.noticeTime = noticeTime;
		this.additionalDetails = additionalDetails;		
	}
    

}
