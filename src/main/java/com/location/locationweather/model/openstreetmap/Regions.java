
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
    "EUROPE",
    "GB",
    "NORTHERN_EUROPE",
    "WORLD",
    "AMERICAS",
    "CA",
    "NORTHERN_AMERICA",
    "US"
})
public class Regions {

    @JsonProperty("EUROPE")
    private String eUROPE;
    @JsonProperty("GB")
    private String gB;
    @JsonProperty("NORTHERN_EUROPE")
    private String nORTHERNEUROPE;
    @JsonProperty("WORLD")
    private String wORLD;
    @JsonProperty("AMERICAS")
    private String aMERICAS;
    @JsonProperty("CA")
    private String cA;
    @JsonProperty("NORTHERN_AMERICA")
    private String nORTHERNAMERICA;
    @JsonProperty("US")
    private String uS;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("EUROPE")
    public String getEUROPE() {
        return eUROPE;
    }

    @JsonProperty("EUROPE")
    public void setEUROPE(String eUROPE) {
        this.eUROPE = eUROPE;
    }

    @JsonProperty("GB")
    public String getGB() {
        return gB;
    }

    @JsonProperty("GB")
    public void setGB(String gB) {
        this.gB = gB;
    }

    @JsonProperty("NORTHERN_EUROPE")
    public String getNORTHERNEUROPE() {
        return nORTHERNEUROPE;
    }

    @JsonProperty("NORTHERN_EUROPE")
    public void setNORTHERNEUROPE(String nORTHERNEUROPE) {
        this.nORTHERNEUROPE = nORTHERNEUROPE;
    }

    @JsonProperty("WORLD")
    public String getWORLD() {
        return wORLD;
    }

    @JsonProperty("WORLD")
    public void setWORLD(String wORLD) {
        this.wORLD = wORLD;
    }

    @JsonProperty("AMERICAS")
    public String getAMERICAS() {
        return aMERICAS;
    }

    @JsonProperty("AMERICAS")
    public void setAMERICAS(String aMERICAS) {
        this.aMERICAS = aMERICAS;
    }

    @JsonProperty("CA")
    public String getCA() {
        return cA;
    }

    @JsonProperty("CA")
    public void setCA(String cA) {
        this.cA = cA;
    }

    @JsonProperty("NORTHERN_AMERICA")
    public String getNORTHERNAMERICA() {
        return nORTHERNAMERICA;
    }

    @JsonProperty("NORTHERN_AMERICA")
    public void setNORTHERNAMERICA(String nORTHERNAMERICA) {
        this.nORTHERNAMERICA = nORTHERNAMERICA;
    }

    @JsonProperty("US")
    public String getUS() {
        return uS;
    }

    @JsonProperty("US")
    public void setUS(String uS) {
        this.uS = uS;
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
