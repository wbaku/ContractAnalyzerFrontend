package com.sciamus.contractanalyzerfrontend.control;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RunCheckClient", url = "${application.backend-port}")
public interface RunCheckClient {

    //idiotyczne - trzeba zmienić:
//    @GetMapping("/checks/{name}/run?url=${application.backend-port}")
//    RunCheckClientResponseDTO runCheck(@PathVariable String name);
//?url=http%3A%2F%2Flocalhost%3A8080
    @GetMapping("/checks/{name}/run?url={url}")
    RunCheckClientResponseDTO runCheck(@PathVariable String name, @PathVariable String url);
}
