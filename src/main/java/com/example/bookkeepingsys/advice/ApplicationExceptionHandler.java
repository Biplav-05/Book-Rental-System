package com.example.bookkeepingsys.advice;

import com.example.bookkeepingsys.misc.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ApiResponse {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse handleValidationException(MethodArgumentNotValidException ex)
    {
        List<String> error = new ArrayList<>();
        for(FieldError e : ex.getBindingResult().getFieldErrors())
        {
            error.add(e.getDefaultMessage());
//            "Column : "+e.getField() +" => "
        }
        ApiResponse apiResponse = new ApiResponse();
       return apiResponse.exception("validation exception",error);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ApiResponse handleConstraintViolationException(ConstraintViolationException ex)
    {
        if(ex.getConstraintName().contains("unique"))
        {
            String uniqueColumn = ex.getConstraintName().replace("unique_", " ");
            return error(uniqueColumn+" already exist",null);
        }
        return error(ex.getMessage(),null);
    }
}
