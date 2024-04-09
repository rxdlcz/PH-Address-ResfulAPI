package com.projectdc.service;

import com.projectdc.entities.Address;
import com.projectdc.request.GetAddressRequest;

import java.util.List;

public interface GetAddressProcessIF {
    /**
     * @param getAddressRequest AddressRequest
     * @return List&lt;Address&gt;
     */
    List<Address> getAddressList(GetAddressRequest getAddressRequest);

    /**
     * @param getAddressRequest AddressRequest
     * @return long
     */
    long getAddressListCount(GetAddressRequest getAddressRequest);
}
