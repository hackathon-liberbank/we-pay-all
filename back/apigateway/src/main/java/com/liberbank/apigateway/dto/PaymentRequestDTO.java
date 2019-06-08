package com.liberbank.apigateway.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PaymentRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T05:36:45.607+02:00")

public class PaymentRequestDTO   {
  @JsonProperty("eventID")
  private Long eventID = null;

  @JsonProperty("beneficiary")
  private Long beneficiary = null;

  @JsonProperty("amount")
  private Long amount = null;

  public PaymentRequestDTO eventID(Long eventID) {
    this.eventID = eventID;
    return this;
  }

   /**
   * Get eventID
   * @return eventID
  **/
  @ApiModelProperty(value = "")


  public Long getEventID() {
    return eventID;
  }

  public void setEventID(Long eventID) {
    this.eventID = eventID;
  }

  public PaymentRequestDTO beneficiary(Long beneficiary) {
    this.beneficiary = beneficiary;
    return this;
  }

   /**
   * Get beneficiary
   * @return beneficiary
  **/
  @ApiModelProperty(value = "")


  public Long getBeneficiary() {
    return beneficiary;
  }

  public void setBeneficiary(Long beneficiary) {
    this.beneficiary = beneficiary;
  }

  public PaymentRequestDTO amount(Long amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRequestDTO paymentRequestDTO = (PaymentRequestDTO) o;
    return Objects.equals(this.eventID, paymentRequestDTO.eventID) &&
        Objects.equals(this.beneficiary, paymentRequestDTO.beneficiary) &&
        Objects.equals(this.amount, paymentRequestDTO.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventID, beneficiary, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequest {\n");
    
    sb.append("    eventID: ").append(toIndentedString(eventID)).append("\n");
    sb.append("    beneficiary: ").append(toIndentedString(beneficiary)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

