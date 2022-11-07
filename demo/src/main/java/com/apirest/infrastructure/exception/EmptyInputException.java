package com.apirest.infrastructure.exception;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class EmptyInputException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

}
