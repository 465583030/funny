package com.example.crxc.funny;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
        import javax.annotation.Generated;
        import com.fasterxml.jackson.annotation.JsonAnyGetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "content",
        "hashId",
        "unixtime",
        "updatetime"
})
class Datum implements Serializable {

    @JsonProperty("content")
    private String content;
    @JsonProperty("hashId")
    private String hashId;
    @JsonProperty("unixtime")
    private Integer unixtime;
    @JsonProperty("updatetime")
    private String updatetime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The content
     */
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     * The content
     */
    @JsonProperty("content")
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @return
     * The hashId
     */
    @JsonProperty("hashId")
    public String getHashId() {
        return hashId;
    }

    /**
     *
     * @param hashId
     * The hashId
     */
    @JsonProperty("hashId")
    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    /**
     *
     * @return
     * The unixtime
     */
    @JsonProperty("unixtime")
    public Integer getUnixtime() {
        return unixtime;
    }

    /**
     *
     * @param unixtime
     * The unixtime
     */
    @JsonProperty("unixtime")
    public void setUnixtime(Integer unixtime) {
        this.unixtime = unixtime;
    }

    /**
     *
     * @return
     * The updatetime
     */
    @JsonProperty("updatetime")
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     *
     * @param updatetime
     * The updatetime
     */
    @JsonProperty("updatetime")
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
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



@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "data"
})
class Result {

    @JsonProperty("data")
    private List<Datum> data = new ArrayList<Datum>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The data
     */
    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
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