package com.sciamus.contractanalyzerfrontend.control.suites;

import com.sciamus.contractanalyzerfrontend.control.FeignClientsConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "SuitesClient", url = "${application.backend-port}", configuration = FeignClientsConfig.class)
public interface SuitesClient {

    @GetMapping("/suites")
    List<String> getSuites();

    @GetMapping("/suites/{name}/run?url={url}")
    SuiteReportDTO runSuite(@PathVariable String name, @PathVariable String url);

    @GetMapping("/suites/reports")
    List<SuiteReportDTO> getAllReports();


}
