package com.liberbank.apigateway.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * MailRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-08T09:25:42.368+02:00")

public class MailRequestDTO   {
  @JsonProperty("to")
  private String to = null;

  @JsonProperty("subject")
  private String subject = null;

  @JsonProperty("body")
  private String body = null;

  public MailRequestDTO to(String to) {
    this.to = to;
    return this;
  }

   /**
   * Get to
   * @return to
  **/
  @ApiModelProperty(value = "")


  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public MailRequestDTO subject(String subject) {
    this.subject = subject;
    return this;
  }

   /**
   * Get subject
   * @return subject
  **/
  @ApiModelProperty(value = "")


  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public MailRequestDTO body(String body) {
    this.body = body;
    return this;
  }

   /**
   * Get body
   * @return body
  **/
  @ApiModelProperty(value = "")


  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MailRequestDTO mailRequestDTO = (MailRequestDTO) o;
    return Objects.equals(this.to, mailRequestDTO.to) &&
        Objects.equals(this.subject, mailRequestDTO.subject) &&
        Objects.equals(this.body, mailRequestDTO.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(to, subject, body);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailRequest {\n");
    
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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

