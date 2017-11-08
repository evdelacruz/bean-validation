package com.evdelacruz.samples.beanvalidation.dist.rest;

import com.evdelacruz.samples.beanvalidation.util.error.Error;
import com.evdelacruz.samples.beanvalidation.util.error.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import static org.springframework.http.ResponseEntity.*;

@ControllerAdvice
public class GlobalController extends ErrorHandler<ResponseEntity<Error>> {

    public GlobalController() {
        super();
        this.setDefaultResponse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error("E1", "Internal Error")));
    }

    @Override
    public void initialize(Map<Class<? extends Exception>, Function<Exception, ResponseEntity<Error>>> responses) {
        responses.put(ConstraintViolationException.class, ex -> badRequest().body(new Error("E3", ((ConstraintViolationException)ex).getConstraintViolations().stream().map(this::convert).collect(Collectors.joining(", ")))));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        return this.handleError(ex);
    }

    //<editor-fold desc="Description">
    private String convert(ConstraintViolation<?> violation) {
        Iterator<Path.Node> it = violation.getPropertyPath().iterator();
        Path.Node node;
        do {
            node = it.next();
        } while (it.hasNext() && node.getKind() != ElementKind.PROPERTY);
        return node.getName();
    }
    //</editor-fold>
}
