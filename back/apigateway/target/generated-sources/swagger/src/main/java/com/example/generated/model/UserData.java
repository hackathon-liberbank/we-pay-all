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
 * UserData
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class UserData   {
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

  @JsonProperty("password")
  private String password = null;

  public UserData name(String name) {
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

  public UserData surname(String surname) {
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

  public UserData phone(String phone) {
    this.phone = phone;
    return this;
  }

   /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")

 @Size(min=9,max=15)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserData email(String email) {
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

  public UserData address(Address address) {
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

  public UserData password(String password) {
    this.password = password;
    return this;
  }

   /**
   * el password debe estar codificado haciendo uso de un sha256.
   * @return password
  **/
  @ApiModelProperty(value = "el password debe estar codificado haciendo uso de un sha256.")

 @Pattern(regexp="[A-Fa-f0-9]{64}") @Size(min=64,max=64)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserData userData = (UserData) o;
    return Objects.equals(this.name, userData.name) &&
        Objects.equals(this.surname, userData.surname) &&
        Objects.equals(this.phone, userData.phone) &&
        Objects.equals(this.email, userData.email) &&
        Objects.equals(this.address, userData.address) &&
        Objects.equals(this.password, userData.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, phone, email, address, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserData {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

