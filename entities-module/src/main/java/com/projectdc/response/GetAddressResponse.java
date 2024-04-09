package com.projectdc.response;

import com.projectdc.entities.Address;
import com.projectdc.utilities.StatusHandler;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetAddressResponse extends StatusHandler {

    private List<Address> response;

    private long count;
}
