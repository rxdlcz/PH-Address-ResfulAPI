package com.projectdc.application.transaction.endpoint.implement;

import com.projectdc.request.GetAddressRequest;
import com.projectdc.request.PostAddressRequest;
import com.projectdc.response.DeleteAddressResponse;
import com.projectdc.response.PostAddressResponse;
import com.projectdc.application.transaction.endpoint.AddressEndPointIF;
import com.projectdc.operation.AddressOperationIF;
import com.projectdc.utilities.StatusHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.projectdc.response.GetAddressResponse;


@RestController
@RequiredArgsConstructor
public class AddressEndPoint implements AddressEndPointIF {

    private final AddressOperationIF addressOperationIF;

    /**
     * @param request GetAddressRequest
     * @return ResponseEntity&lt;GetAddressResponse&gt;
     */
    @Override
    public ResponseEntity<GetAddressResponse> getAddress(GetAddressRequest request) {
        GetAddressResponse response = new GetAddressResponse();

        try {
            response = this.addressOperationIF.operateGetAddress(request);
        }catch (Exception e){
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, response.apiError());
        }

        return ResponseEntity.ok(response);
    }

    /**
     * @param request String
     * @return ResponseEntity&lt;PostAddressResponse&gt;
     */
    @Override
    public ResponseEntity<PostAddressResponse> insertAddress(@Valid PostAddressRequest request){
        PostAddressResponse response = new PostAddressResponse();

        try {
            response = this.addressOperationIF.operateInsertAddress(request);
        }catch (Exception e){
            response.setMessage(e.getLocalizedMessage());
            return new ResponseEntity<>(response, response.apiError());
        }

        return new ResponseEntity<>(response, response.getStatus());
    }

    /**
     * @return ResponseEntity&lt;DeleteAddressResponse&gt;
     */
    @Override
    public ResponseEntity<DeleteAddressResponse> deleteAddress() {
        DeleteAddressResponse response = new DeleteAddressResponse();

        try{
            response = this.addressOperationIF.operateDeleteAddress();
        }catch (Exception e){
            response.setMessage(e.getLocalizedMessage());
            return new ResponseEntity<>(response, response.apiError());
        }

        return new ResponseEntity<>(response, response.getStatus());
    }
}
