package org.openapi.quarkus.api_yaml.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Publisher  {

    private Long id;
    private String name;

    public enum SexEnum {
        M(String.valueOf("M")), F(String.valueOf("F"));

        // caching enum access
        private static final java.util.EnumSet<SexEnum> values = java.util.EnumSet.allOf(SexEnum.class);

        String value;

        SexEnum (String v) {
            value = v;
        }

        public String value() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static SexEnum fromValue(String v) {
            for (SexEnum b : values) {
                if (String.valueOf(b.value).equals(v)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + v + "'");
        }
    }    private SexEnum sex;

    /**
    * Get id
    * @return id
    **/
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * Set id
     **/
    public void setId(Long id) {
        this.id = id;
    }

    public Publisher id(Long id) {
        this.id = id;
        return this;
    }

    /**
    * Get name
    * @return name
    **/
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Set name
     **/
    public void setName(String name) {
        this.name = name;
    }

    public Publisher name(String name) {
        this.name = name;
        return this;
    }

    /**
    * Get sex
    * @return sex
    **/
    @JsonProperty("sex")
    public SexEnum getSex() {
        return sex;
    }

    /**
     * Set sex
     **/
    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Publisher sex(SexEnum sex) {
        this.sex = sex;
        return this;
    }

    /**
     * Create a string representation of this pojo.
     **/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Publisher {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}