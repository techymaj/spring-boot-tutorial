package tech.majaliwa.EmployeeCRUD.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.majaliwa.EmployeeCRUD.models.EmployeeNotFound;

@ControllerAdvice
public class GlobalExceptions {

    @ExceptionHandler
    public ResponseEntity<EmployeeNotFound> handlesEmployeeNotFound(EmployeeNotFoundException e) {
       var  message = e.getMessage();
       var status = HttpStatus.NOT_FOUND.value();
       var timeStamp = System.currentTimeMillis();

       EmployeeNotFound employeeNotFound = new EmployeeNotFound(message, timeStamp, status);

       return new ResponseEntity<>(employeeNotFound, HttpStatus.NOT_FOUND);
    }
}
