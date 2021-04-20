package com.sciamus.contractanalyzerfrontend.control;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "GetReportsClient", url = "${application.backend-port}")

public interface GetReportsClient {

    @GetMapping("/reports")
    List<RunCheckClientResponseDTO> getAllReports();


}
