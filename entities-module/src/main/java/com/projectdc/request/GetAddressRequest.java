package com.projectdc.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressRequest {

    public int id;

    public String code;

    public String name;

    public String correspondenceCode;

    public String geographicLevel;

    public String oldName;

    public String cityClass;

    public String incomeClass;

    public String urbanRural;

    public long population;

    public String status;

    public int page;

    public int limit;
}
