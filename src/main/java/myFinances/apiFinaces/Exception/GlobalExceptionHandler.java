package myFinances.apiFinaces.Exception;

import myFinances.apiFinaces.DTOs.Error.ErrorResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponseDTO> IllegalArgument(IllegalArgumentException exception){
        ErrorResponseDTO dto =  ErrorResponseDTO.builder()
                .code(400)
                .message("IllegalArgument")
                .details(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateEmail(DataIntegrityViolationException exception) {

        ErrorResponseDTO dto = ErrorResponseDTO.builder()
                .code(409)
                .message("CONFLICT")
                .details(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }
}
