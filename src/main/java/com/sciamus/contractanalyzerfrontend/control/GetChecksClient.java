package com.sciamus.contractanalyzerfrontend.control;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component

//czy do tego przypadkiem nie należy użyć EUREKI albo coś w tym stylu
@FeignClient(name = "CheckGetFeignClient", url = "${application.backend-port}")
public interface GetChecksClient {

    @GetMapping("/restContractChecks")
    GetChecksResponseDTO getListOfChecks();

}
