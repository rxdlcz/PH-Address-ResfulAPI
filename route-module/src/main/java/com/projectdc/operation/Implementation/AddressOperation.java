package com.projectdc.operation.Implementation;

import com.projectdc.entities.Address;
import com.projectdc.request.GetAddressRequest;
import com.projectdc.request.PostAddressRequest;
import com.projectdc.response.GetAddressResponse;
import com.projectdc.response.PostAddressResponse;
import com.projectdc.operation.AddressOperationIF;
import com.projectdc.service.GetAddressProcessIF;
import com.projectdc.service.PostAddressProcessIF;
import com.projectdc.utilities.StatusHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressOperation implements AddressOperationIF {

    private final GetAddressProcessIF getAddressProcessIF;

    private final PostAddressProcessIF postAddressProcessIF;

    /**
     * @param request AddressRequest
     * @return AddressResponse
     */
    @Override
    public GetAddressResponse operateGetAddress(GetAddressRequest request) {
        long count = getAddressProcessIF.getAddressListCount(request);
        List<Address> addressResponse = getAddressProcessIF.getAddressList(request);

        return GetAddressResponse.builder()
                .response(addressResponse)
                .count(count)
                .build();
    }

    /**
     * @param request String
     * @return PostAddressResponse
     */
    @Override
    public PostAddressResponse operateInsertAddress(PostAddressRequest request) {
        StatusHandler response = this.postAddressProcessIF.postAddressProcess(request);

        return PostAddressResponse.builder()
                .status(response.getStatus())
                .message(response.getMessage())
                .build();
    }

}
