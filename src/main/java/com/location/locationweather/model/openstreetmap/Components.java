
package com.location.locationweather.model.openstreetmap;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ISO_3166-1_alpha-2",
    "ISO_3166-1_alpha-3",
    "_category",
    "_type",
    "city",
    "continent",
    "country",
    "country_code",
    "postcode",
    "state",
    "state_code",
    "state_district",
    "county",
    "county_code",
    "village",
    "hamlet"
})
public class Components {

    @JsonProperty("ISO_3166-1_alpha-2")
    private String iSO31661Alpha2;
    @JsonProperty("ISO_3166-1_alpha-3")
    private String iSO31661Alpha3;
    @JsonProperty("_category")
    private String category;
    @JsonProperty("_type")
    private String type;
    @JsonProperty("city")
    private String city;
    @JsonProperty("continent")
    private String continent;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("state_code")
    private String stateCode;
    @JsonProperty("state_district")
    private String stateDistrict;
    @JsonProperty("county")
    private String county;
    @JsonProperty("county_code")
    private String countyCode;
    @JsonProperty("village")
    private String village;
    @JsonProperty("hamlet")
    private String hamlet;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ISO_3166-1_alpha-2")
    public String getISO31661Alpha2() {
        return iSO31661Alpha2;
    }

    @JsonProperty("ISO_3166-1_alpha-2")
    public void setISO31661Alpha2(String iSO31661Alpha2) {
        this.iSO31661Alpha2 = iSO31661Alpha2;
    }

    @JsonProperty("ISO_3166-1_alpha-3")
    public String getISO31661Alpha3() {
        return iSO31661Alpha3;
    }

    @JsonProperty("ISO_3166-1_alpha-3")
    public void setISO31661Alpha3(String iSO31661Alpha3) {
        this.iSO31661Alpha3 = iSO31661Alpha3;
    }

    @JsonProperty("_category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("_category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("_type")
    public String getType() {
        return type;
    }

    @JsonProperty("_type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("continent")
    public String getContinent() {
        return continent;
    }

    @JsonProperty("continent")
    public void setContinent(String continent) {
        this.continent = continent;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("postcode")
    public String getPostcode() {
        return postcode;
    }

    @JsonProperty("postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("state_code")
    public String getStateCode() {
        return stateCode;
    }

    @JsonProperty("state_code")
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    @JsonProperty("state_district")
    public String getStateDistrict() {
        return stateDistrict;
    }

    @JsonProperty("state_district")
    public void setStateDistrict(String stateDistrict) {
        this.stateDistrict = stateDistrict;
    }

    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty("county_code")
    public String getCountyCode() {
        return countyCode;
    }

    @JsonProperty("county_code")
    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    @JsonProperty("village")
    public String getVillage() {
        return village;
    }

    @JsonProperty("village")
    public void setVillage(String village) {
        this.village = village;
    }

    @JsonProperty("hamlet")
    public String getHamlet() {
        return hamlet;
    }

    @JsonProperty("hamlet")
    public void setHamlet(String hamlet) {
        this.hamlet = hamlet;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
