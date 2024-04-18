package com.projectdc.adapter;

import com.projectdc.repository.AddressRepo;
import com.projectdc.service.DeleteAddressProcessIF;
import com.projectdc.utilities.StatusHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteAddressAdapter implements DeleteAddressProcessIF {

    private final AddressRepo addressRepo;

    /**
     * @return StatusHandler
     */
    @Override
    public StatusHandler DeleteAddressProcess() {
        StatusHandler statusHandler = new StatusHandler();

        long count = this.addressRepo.count();

        this.addressRepo.truncate();

        statusHandler.setMessage("Total Deleted data: " + count);
        statusHandler.setStatus(HttpStatus.OK);

        return statusHandler;
    }
}
