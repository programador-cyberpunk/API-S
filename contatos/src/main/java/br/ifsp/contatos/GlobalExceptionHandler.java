package br.ifsp.contatos.exception;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import br.ifsp.contatos.model.Contato;
import br.ifsp.contatos.repository.ContatoRepository;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
    public class GlobalExceptionHandler {
    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    //tratar as exceções como sem retorno
   @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
        public ResponseEntity<Map<String, String>> handleResourceNotFoundException(final NoResourceFoundException e) {
       Map<String, String> map = new HashMap<>();
       errorResponse.put("error",exception.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
   }
   @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
     public ResponseEntity<Map<String, String>> handleGenericException(Exception exception){
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Erro interno nesse caralho desse servidor,se vira");
        return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
   }
}