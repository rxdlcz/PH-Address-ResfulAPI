package com.projectdc.request;

import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
public class PostAddressRequest {

    @NotNull(message = "file path is required")
    public String path;

    @NotNull(message = "Sheet name is required")
    public String sheet;

    public String columnName;

    public String item;

    public int limit;
}
