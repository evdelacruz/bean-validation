package com.evdelacruz.samples.beanvalidation.dist.rest;

import com.evdelacruz.samples.beanvalidation.util.error.Error;
import com.evdelacruz.samples.beanvalidation.util.error.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.function.Function;
import static com.evdelacruz.samples.beanvalidation.util.constraint.ConstraintViolationUtils.*;
import static org.springframework.http.ResponseEntity.*;

@ControllerAdvice
public class GlobalController extends ErrorHandler<ResponseEntity<Error>> {

    public GlobalController() {
        super();
        this.setDefaultResponse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Error("E1", "Internal Error")));
    }

    @Override
    public void initialize(Map<Class<? extends Exception>, Function<Exception, ResponseEntity<Error>>> responses) {
        responses.put(ConstraintViolationException.class, ex -> badRequest().body(new Error("E3", extractFields(((ConstraintViolationException)ex).getConstraintViolations()))));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        return this.handleError(ex);
    }
}
