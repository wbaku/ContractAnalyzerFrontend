package com.sciamus.contractanalyzerfrontend.control;

//import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RunCheckClientResponseDTO {

    //        @JsonProperty("id")
    public String id;
    //        @JsonProperty("result")
    public String result;
    //        @JsonProperty ("name")
    public String nameOfCheck;
    //        @JsonProperty("reportBody")
    public String reportBody;
    //        @JsonProperty("timestamp")
    public Date timestamp;


    public String getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return nameOfCheck;
    }

    public String getReportBody() {
        return reportBody;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "RunCheckClientResponseDTO{" +
                "id='" + id + '\'' +
                ", result='" + result + '\'' +
                ", name='" + nameOfCheck + '\'' +
                ", reportBody='" + reportBody + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
