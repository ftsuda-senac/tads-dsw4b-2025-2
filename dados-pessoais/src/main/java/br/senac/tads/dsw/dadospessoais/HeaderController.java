package br.senac.tads.dsw.dadospessoais;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeaderController {

    @GetMapping("/headers")
    public Map<String, Object> findAllHeaders(
        @RequestHeader Map<String, Object> headers) {
        return headers;
    }

    @GetMapping("/headers/user-agent")
    public String findUserAgent(
            @RequestHeader("user-agent") String userAgent) {
        return userAgent;
    }

}
