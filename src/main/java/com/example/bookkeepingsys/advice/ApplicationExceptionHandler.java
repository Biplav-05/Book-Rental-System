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
         String errorMessage="";
        for(FieldError e : ex.getBindingResult().getFieldErrors())
        {
            error.add(e.getDefaultMessage());
            errorMessage += e.getDefaultMessage()+" ";

//            "Column : "+e.getField() +" => "
        }

       return error(errorMessage,null);
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
    @ExceptionHandler({Exception.class})
    public ApiResponse handleParentEcception(Exception ex)
    {
        return error(ex.getMessage(),null);
    }
}
