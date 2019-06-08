package com.example.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TransactionResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class TransactionResponse   {
  @JsonProperty("event")
  private String event = null;

  @JsonProperty("creditor")
  private String creditor = null;

  @JsonProperty("ammount")
  private Long ammount = null;

  public TransactionResponse event(String event) {
    this.event = event;
    return this;
  }

   /**
   * Get event
   * @return event
  **/
  @ApiModelProperty(value = "")


  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public TransactionResponse creditor(String creditor) {
    this.creditor = creditor;
    return this;
  }

   /**
   * Get creditor
   * @return creditor
  **/
  @ApiModelProperty(value = "")


  public String getCreditor() {
    return creditor;
  }

  public void setCreditor(String creditor) {
    this.creditor = creditor;
  }

  public TransactionResponse ammount(Long ammount) {
    this.ammount = ammount;
    return this;
  }

   /**
   * Get ammount
   * @return ammount
  **/
  @ApiModelProperty(value = "")


  public Long getAmmount() {
    return ammount;
  }

  public void setAmmount(Long ammount) {
    this.ammount = ammount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionResponse transactionResponse = (TransactionResponse) o;
    return Objects.equals(this.event, transactionResponse.event) &&
        Objects.equals(this.creditor, transactionResponse.creditor) &&
        Objects.equals(this.ammount, transactionResponse.ammount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, creditor, ammount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionResponse {\n");
    
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    creditor: ").append(toIndentedString(creditor)).append("\n");
    sb.append("    ammount: ").append(toIndentedString(ammount)).append("\n");
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

