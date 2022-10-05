package com.filadacreche.demo.exceptions;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@ControllerAdvice
public class ExceptionHandlerApp {
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ProblemDetail> handlerResourceNotFoundException(
//            ResourceNotFoundException ex) {
//
//        log.warn("Demonio da Garoa");
//        String message = "Recurso não encontrado com valor " + ex.getResourceId();
//        ProblemDetail problemDetail = new ProblemDetail(
//                "Resource not found exception",
//                List.of(new Violation(ex.getResourceName().getName(), message))
//        );
//        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleContentNotAllowedException(ResourceNotFoundException ex) {
        ProblemDetail problemDetail = new ProblemDetail(
                "Resource not found exception",
                List.of(new Violation(ex.getResourceName().getName(), "message"))
        );
        return new ResponseEntity<>(problemDetail, HttpStatus.NOT_FOUND);
    }

}
