package com.example.generated.model;

import java.util.Objects;
import com.example.generated.model.AccountsResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccountsGetResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class AccountsGetResponse   {
  @JsonProperty("accounts")
  private List<AccountsResponse> accounts = null;

  public AccountsGetResponse accounts(List<AccountsResponse> accounts) {
    this.accounts = accounts;
    return this;
  }

  public AccountsGetResponse addAccountsItem(AccountsResponse accountsItem) {
    if (this.accounts == null) {
      this.accounts = new ArrayList<AccountsResponse>();
    }
    this.accounts.add(accountsItem);
    return this;
  }

   /**
   * Get accounts
   * @return accounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountsResponse> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<AccountsResponse> accounts) {
    this.accounts = accounts;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsGetResponse accountsGetResponse = (AccountsGetResponse) o;
    return Objects.equals(this.accounts, accountsGetResponse.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsGetResponse {\n");
    
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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

