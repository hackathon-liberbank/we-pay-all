package com.example.generated.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountsResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class AccountsResponse   {
  @JsonProperty("accountAgent")
  private String accountAgent = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("currency")
  private String currency = null;

  public AccountsResponse accountAgent(String accountAgent) {
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

  public AccountsResponse iban(String iban) {
    this.iban = iban;
    return this;
  }

   /**
   * Get iban
   * @return iban
  **/
  @ApiModelProperty(value = "")


  public String getIban() {
    return iban;
  }

  public void setIban(String iban) {
    this.iban = iban;
  }

  public AccountsResponse currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsResponse accountsResponse = (AccountsResponse) o;
    return Objects.equals(this.accountAgent, accountsResponse.accountAgent) &&
        Objects.equals(this.iban, accountsResponse.iban) &&
        Objects.equals(this.currency, accountsResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountAgent, iban, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsResponse {\n");
    
    sb.append("    accountAgent: ").append(toIndentedString(accountAgent)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

