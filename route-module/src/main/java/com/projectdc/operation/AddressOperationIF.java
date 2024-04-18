package com.projectdc.operation;

import com.projectdc.request.GetAddressRequest;
import com.projectdc.request.PostAddressRequest;
import com.projectdc.response.DeleteAddressResponse;
import com.projectdc.response.GetAddressResponse;
import com.projectdc.response.PostAddressResponse;

public interface AddressOperationIF {
    /**
     * @param request GetAddressRequest
     * @return GetAddressResponse
     */
    GetAddressResponse operateGetAddress(GetAddressRequest request);

    /**
     * @param request PostAddressRequest
     * @return PostAddressResponse
     */
    PostAddressResponse operateInsertAddress(PostAddressRequest request);

    /**
     * @return DeleteAddressResponse
     */
    DeleteAddressResponse operateDeleteAddress();
}
