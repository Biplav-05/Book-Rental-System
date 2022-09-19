package com.example.bookkeepingsys.misc;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private Integer status;
    private String message;
    private Object data;



    public ApiResponse success(String message, Object data) {
        ApiResponse apiResponse = ApiResponse.builder()
                .message(message)
                .data(data)
                .status(1)
                .build();
        return apiResponse;
    }

    public ApiResponse error(String message, Object data) {
        ApiResponse apiResponse1 = ApiResponse.builder()
                .message(message)
                .data(data)
                .status(0)
                .build();
        return apiResponse1;
    }


}
