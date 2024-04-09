package com.projectdc.entities;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class NationalSummary {

    public int code;
    public String region;
    public String province;
    public String cities;
    public String municipality;
    public String barangay;
    public int population;

}
