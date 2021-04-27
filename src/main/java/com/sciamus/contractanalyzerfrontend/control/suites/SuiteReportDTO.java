package com.sciamus.contractanalyzerfrontend.control.suites;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.sciamus.contractanalyzerfrontend.control.checks.CheckReportDTO;

import java.util.List;

public class SuiteReportDTO {

    @JsonUnwrapped
    public List<CheckReportDTO> reportList;

    public List<CheckReportDTO> getReportList() {
        return reportList;
    }

    public void setReportList(List<CheckReportDTO> reportList) {
        this.reportList = reportList;
    }

    @Override
    public String toString() {
        return "SuiteReportDTO{" +
                "reportDTOList=" + reportList +
                '}';
    }




}
