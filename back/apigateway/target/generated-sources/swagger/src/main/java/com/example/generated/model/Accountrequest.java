package com.example.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Accountrequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class Accountrequest   {
  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("accountAgent")
  private String accountAgent = null;

  public Accountrequest currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Default EUR
   * @return currency
  **/
  @ApiModelProperty(value = "Default EUR")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Accountrequest accountAgent(String accountAgent) {
    this.accountAgent = accountAgent;
    return this;
  }

   /**
   * Get accountAgent
   * @return accountAgent
  **/
  @ApiModelProperty(value = "")


  public String getAccountAgent() {
    return accountAgent;
  }

  public void setAccountAgent(String accountAgent) {
    this.accountAgent = accountAgent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Accountrequest accountrequest = (Accountrequest) o;
    return Objects.equals(this.currency, accountrequest.currency) &&
        Objects.equals(this.accountAgent, accountrequest.accountAgent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, accountAgent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Accountrequest {\n");
    
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    accountAgent: ").append(toIndentedString(accountAgent)).append("\n");
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

