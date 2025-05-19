package com.femtech.client_service.client.handler;


import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
