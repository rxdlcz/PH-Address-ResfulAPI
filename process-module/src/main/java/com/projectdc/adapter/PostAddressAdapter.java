package com.projectdc.adapter;

import com.projectdc.entities.Address;
import com.projectdc.request.PostAddressRequest;
import com.projectdc.utilities.ExcelReaderUtils;
import com.projectdc.repository.AddressRepo;
import com.projectdc.service.PostAddressProcessIF;
import com.projectdc.utilities.StatusHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostAddressAdapter implements PostAddressProcessIF {

    private final AddressRepo addressRepo;

    /**
     * @param PostAddressRequest request
     * @return StatusHandler
     */
    @Override
    public StatusHandler postAddressProcess(PostAddressRequest request) {
        StatusHandler statusHandler = new StatusHandler();
        List<Address> address;

        address = ExcelReaderUtils.getExcelAddress(request);

        if (!address.isEmpty()) {
            List<Address> result = new ArrayList<>();
            try {
                result = this.addressRepo.saveAll(address);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (result.size() == address.size()) {
                statusHandler.setStatus(HttpStatus.CREATED);
                statusHandler.setMessage("Total inserted data:" + result.size());
            } else {
                statusHandler.apiError("There is an error in saving the data to the database");
            }
        } else {
            statusHandler.apiError("No data found in the file");
        }

        return statusHandler;
    }
}
