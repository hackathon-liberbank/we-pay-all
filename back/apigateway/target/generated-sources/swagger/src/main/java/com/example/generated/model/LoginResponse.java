package com.example.generated.model;

import java.util.Objects;
import com.example.generated.model.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LoginResponse
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class LoginResponse   {
  @JsonProperty("userID")
  private Integer userID = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("bearer")
  private String bearer = null;

  public LoginResponse userID(Integer userID) {
    this.userID = userID;
    return this;
  }

   /**
   * Get userID
   * minimum: 1
   * maximum: 10000
   * @return userID
  **/
  @ApiModelProperty(value = "")

 @Min(1) @Max(10000)
  public Integer getUserID() {
    return userID;
  }

  public void setUserID(Integer userID) {
    this.userID = userID;
  }

  public LoginResponse name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")

 @Size(min=3)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LoginResponse surname(String surname) {
    this.surname = surname;
    return this;
  }

   /**
   * Get surname
   * @return surname
  **/
  @ApiModelProperty(value = "")

 @Size(min=3)
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public LoginResponse phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")

 @Size(min=3)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public LoginResponse email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")

 @Pattern(regexp="^[a-zA-Z0-9-@.]+$") @Size(min=6,max=30)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LoginResponse address(Address address) {
    this.address = address;
    return this;
  }

   /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public LoginResponse bearer(String bearer) {
    this.bearer = bearer;
    return this;
  }

   /**
   * Get bearer
   * @return bearer
  **/
  @ApiModelProperty(value = "")


  public String getBearer() {
    return bearer;
  }

  public void setBearer(String bearer) {
    this.bearer = bearer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginResponse loginResponse = (LoginResponse) o;
    return Objects.equals(this.userID, loginResponse.userID) &&
        Objects.equals(this.name, loginResponse.name) &&
        Objects.equals(this.surname, loginResponse.surname) &&
        Objects.equals(this.phone, loginResponse.phone) &&
        Objects.equals(this.email, loginResponse.email) &&
        Objects.equals(this.address, loginResponse.address) &&
        Objects.equals(this.bearer, loginResponse.bearer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userID, name, surname, phone, email, address, bearer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    
    sb.append("    userID: ").append(toIndentedString(userID)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    bearer: ").append(toIndentedString(bearer)).append("\n");
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

