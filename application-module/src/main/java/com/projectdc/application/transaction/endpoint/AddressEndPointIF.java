package com.projectdc.application.transaction.endpoint;

import com.projectdc.request.GetAddressRequest;
import com.projectdc.request.PostAddressRequest;
import com.projectdc.response.DeleteAddressResponse;
import com.projectdc.response.PostAddressResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projectdc.response.GetAddressResponse;

@RequestMapping("/address")
public interface AddressEndPointIF {

    /**
     * @param getAddressRequest GetAddressRequest
     * @return ResponseEntity&lt;GetAddressResponse&gt;
     */
    @GetMapping("/getAddress")
    ResponseEntity<GetAddressResponse> getAddress(GetAddressRequest getAddressRequest);

    /**
     * @param request String
     * @return ResponseEntity&lt;PostAddressResponse&gt;
     */
    @PostMapping("/getAddress")
    ResponseEntity<PostAddressResponse> insertAddress(@RequestBody PostAddressRequest request);

    /**
     * @return ResponseEntity&lt;DeleteAddressResponse&gt;
     */
    @DeleteMapping("/getAddress")
    ResponseEntity<DeleteAddressResponse> deleteAddress();
}
