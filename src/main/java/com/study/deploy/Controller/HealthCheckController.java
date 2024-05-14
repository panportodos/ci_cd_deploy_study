package com.study.deploy.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {
    @Value("${server.env}")
    private String env;
    @Value("${server.name}")
    private String serverName;
    @Value("${server.deploy-address}")
    private String deployAddress;
    @Value("${server.port}")
    private String port;

    @GetMapping("/server/hc") //요청이 제대로 오는지 체크
    public ResponseEntity<?> healthCheck() {
        return ResponseEntity.ok(
                Map.of(
                            "serverName", serverName,
                            "deployAddress", deployAddress,
                            "port", port
                )
        );
    }

    @GetMapping("/server/env") //블루인지 그린인지 체크
    public ResponseEntity<?> getEnv() {
        return ResponseEntity.ok(env);
    }
}
