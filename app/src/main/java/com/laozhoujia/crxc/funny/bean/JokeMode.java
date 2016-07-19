package com.laozhoujia.crxc.funny.bean;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "error_code",
        "reason",
        "result"
})
public class JokeMode {

    @JsonProperty("error_code")
    private Integer errorCode;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("result")
    private Result result;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The errorCode
     */
    @JsonProperty("error_code")
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     *
     * @param errorCode
     * The error_code
     */
    @JsonProperty("error_code")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    /**
     *
     * @return
     * The reason
     */
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     * The reason
     */
    @JsonProperty("reason")
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return
     * The result
     */
    @JsonProperty("result")
    public Result getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    @JsonProperty("result")
    public void setResult(Result result) {
        this.result = result;
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



