package com.projectdc.utilities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusHandler {

    /**
     * Http Status code
     */
    private HttpStatus status;

    /**
     *  Error message
     */
    private String message;

    /**
     * Defaults as INTERNAL_SERVER_ERROR 500
     *
     * @return HttpStatus
     */
    public HttpStatus apiError(){
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        return this.status;
    }

    /**
     * Defaults as INTERNAL_SERVER_ERROR 500
     *
     * @return HttpStatus
     */
    public StatusHandler apiError(String message){
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
        return this;
    }
}
