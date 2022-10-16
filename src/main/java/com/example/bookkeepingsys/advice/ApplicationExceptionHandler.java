package com.example.bookkeepingsys.advice;

import com.example.bookkeepingsys.misc.ApiResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

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
    public ApiResponse handleConstraintViolationException(@NotNull ConstraintViolationException ex)
    {
        if(ex.getConstraintName().contains("unique"))
        {
            String uniqueColumn = ex.getConstraintName().replace("unique_", " ");
            return error(uniqueColumn+" already exist",null);
        }
        return error(ex.getMessage(),null);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ApiResponse httpMessageNotReadAbleExceptin(HttpMessageNotReadableException ex)
    {
        return error(ex.getMessage(),null);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ApiResponse handleDataIntegrityException(DataIntegrityViolationException ex)
    {
        if(ex.getCause() instanceof ConstraintViolationException)
        {
          String errorMessage=  ((ConstraintViolationException) ex.getCause()).getConstraintName();
          String tempErrorMessage = errorMessage.replace("unique_","");
            return error(tempErrorMessage+" already exist",null);
        }
        return error("Constraint Violation Exception",null);
    }

    @ExceptionHandler({Exception.class})
    public ApiResponse handleParentException(Exception ex)
    {
        return error(ex.getMessage(),null);
    }
}
