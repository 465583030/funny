package com.example.crxc.funny.bean;

/**
 * Created by crxc on 2016/7/9.
 */

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.HashMap;
        import java.util.Map;
        import javax.annotation.Generated;
        import com.fasterxml.jackson.annotation.JsonAnyGetter;
        import com.fasterxml.jackson.annotation.JsonAnySetter;
        import com.fasterxml.jackson.annotation.JsonIgnore;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "content",
        "hashId",
        "unixtime",
        "updatetime",
        "url"
})
public class GifDatum implements Serializable{

    @JsonProperty("content")
    private String content;
    @JsonProperty("hashId")
    private String hashId;
    @JsonProperty("unixtime")
    private Integer unixtime;
    @JsonProperty("updatetime")
    private String updatetime;
    @JsonProperty("url")
    private String url;
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

    /**
     *
     * @return
     * The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
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
