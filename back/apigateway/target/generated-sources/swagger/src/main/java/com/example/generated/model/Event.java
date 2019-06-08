package com.example.generated.model;

import java.util.Objects;
import com.example.generated.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Event
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T02:35:48.848+02:00")

public class Event   {
  @JsonProperty("price")
  private List<User> price = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("iban")
  private String iban = null;

  @JsonProperty("name")
  private String name = null;

  public Event price(List<User> price) {
    this.price = price;
    return this;
  }

  public Event addPriceItem(User priceItem) {
    if (this.price == null) {
      this.price = new ArrayList<User>();
    }
    this.price.add(priceItem);
    return this;
  }

   /**
   * Get price
   * @return price
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getPrice() {
    return price;
  }

  public void setPrice(List<User> price) {
    this.price = price;
  }

  public Event description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Event iban(String iban) {
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

  public Event name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.price, event.price) &&
        Objects.equals(this.description, event.description) &&
        Objects.equals(this.iban, event.iban) &&
        Objects.equals(this.name, event.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(price, description, iban, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

