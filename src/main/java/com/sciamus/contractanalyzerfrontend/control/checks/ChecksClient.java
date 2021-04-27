package com.sciamus.contractanalyzerfrontend.control.checks;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ChecksClient", url = "${application.backend-port}")

public interface ChecksClient {

    @GetMapping("/restContractChecks")
    ListOfChecksDTO getListOfChecks();

    @GetMapping("/reports")
    List<CheckReportDTO> getAllReports();

    @GetMapping("/checks/{name}/run?url={url}")
    CheckReportDTO runCheck(@PathVariable String name, @PathVariable String url);

}
