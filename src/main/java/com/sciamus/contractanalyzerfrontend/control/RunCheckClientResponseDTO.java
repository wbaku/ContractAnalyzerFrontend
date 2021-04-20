package com.sciamus.contractanalyzerfrontend.control;

import java.util.Date;

public class RunCheckClientResponseDTO {

    //    @JsonProperty("id")
    private String id="dupa";
    //    @JsonProperty("result")
    private String result;
    //    @JsonProperty ("name")
    private String nameOfCheck;
    //    @JsonProperty("reportBody")
    private String reportBody;
    //    @JsonProperty("timestamp")
    private Date timestamp;

    public void setId(String id) {
        this.id = id;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNameOfCheck(String nameOfCheck) {
        this.nameOfCheck = nameOfCheck;
    }

    public void setReportBody(String reportBody) {
        this.reportBody = reportBody;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

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
