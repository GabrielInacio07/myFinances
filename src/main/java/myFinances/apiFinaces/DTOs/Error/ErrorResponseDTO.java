package myFinances.apiFinaces.DTOs.Error;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

@JsonPropertyOrder({"code", "message", "details"})
@Getter
@Builder
public class ErrorResponseDTO {

    private int code;
    private String message;
    private String details;
}
