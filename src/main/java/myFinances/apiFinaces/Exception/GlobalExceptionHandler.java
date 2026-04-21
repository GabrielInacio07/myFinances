package myFinances.apiFinaces.Exception;

import myFinances.apiFinaces.DTOs.Error.ErrorResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalArgument(IllegalArgumentException exception){

        ErrorResponseDTO dto =  ErrorResponseDTO.builder()
                .code(400)
                .message("IllegalArgument")
                .details(exception.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleDuplicateEmail(EmailAlreadyExistsException exception) {

        ErrorResponseDTO dto = ErrorResponseDTO.builder()
                .code(409)
                .message("CONFLICT")
                .details(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<ErrorResponseDTO> handleEntityNotFound(EntityNotFound exception){

            ErrorResponseDTO dto = ErrorResponseDTO.builder()
                    .code(404)
                    .message("NOT_FOUND")
                    .details(exception.getMessage())
                    .build();

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }
}
