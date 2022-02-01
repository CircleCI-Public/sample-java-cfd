package com.circleci.continuousfooddelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * MenuItem
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T03:17:46.722516300-05:00[America/New_York]")
public class MenuItem   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("description")
  private String description;

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("imageId")
  private Integer imageId;

  public MenuItem id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @Schema(name = "id", required = true, defaultValue = "")
  @NotNull
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MenuItem description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @Schema(name = "description", required = true, defaultValue = "")
  @NotNull
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public MenuItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @Schema(name = "name", required = true, defaultValue = "")
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MenuItem price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @Schema(name = "price", required = true, defaultValue = "")
  @NotNull
  @Valid
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public MenuItem imageId(Integer imageId) {
    this.imageId = imageId;
    return this;
  }

  /**
   * URL to an image of the menu item.  This should be the image from the /image endpoint 
   * @return imageId
  */
  @Schema(name = "imageId", required = true, defaultValue = "URL to an image of the menu item.  This should be the image from the /image endpoint ")
  @NotNull
  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MenuItem menuItem = (MenuItem) o;
    return Objects.equals(this.id, menuItem.id) &&
        Objects.equals(this.description, menuItem.description) &&
        Objects.equals(this.name, menuItem.name) &&
        Objects.equals(this.price, menuItem.price) &&
        Objects.equals(this.imageId, menuItem.imageId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, name, price, imageId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MenuItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    imageId: ").append(toIndentedString(imageId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

