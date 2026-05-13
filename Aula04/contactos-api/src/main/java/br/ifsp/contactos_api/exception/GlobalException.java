package br.ifsp.contactos_api.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
@ExceptionHandler(ResourceNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ConfigDataResourceNotFoundException exception){
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("error", exception.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
}
@ExceptionHandler(Exception.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception exception){
    Map<String, String> errorResponse = new HashMap<>();
    errorResponse.put("error", "Deu zika no servidor,entre em contato com o Cypher");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
}

}
