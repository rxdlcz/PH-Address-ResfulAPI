package com.projectdc.adapter;

import com.projectdc.entities.Address;
import com.projectdc.request.GetAddressRequest;
import com.projectdc.repository.AddressRepo;
import com.projectdc.service.GetAddressProcessIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetAddressAdapter implements GetAddressProcessIF {

    @Autowired
    private AddressRepo addressRepo;

    /**
     * @param getAddressRequest AddressRequest
     * @return List&lt;Address&gt;
     */
    @Override
    public List<Address> getAddressList(GetAddressRequest getAddressRequest){
        Example<Address> requestParam = getParamMatcher(getAddressRequest);

        return this.addressRepo.findAll(requestParam);
    }

    /**
     * @param getAddressRequest AddressRequest
     * @return long
     */
    @Override
    public long getAddressListCount(GetAddressRequest getAddressRequest){
        Example<Address> requestParam = getParamMatcher(getAddressRequest);
        return this.addressRepo.count(requestParam);
    }

    /**
     * Setting Parameter based on Request param
     *
     * @param request AddressRequest
     * @return Example&lt;Address&gt;
     */
    private Example<Address> getParamMatcher(GetAddressRequest request){
        Address param = Address.builder()
                .id(request.id)
                .code(request.code)
                .name(request.name)
                .correspondenceCode(request.correspondenceCode)
                .geographicLevel(request.geographicLevel)
                .oldName(request.oldName)
                .cityClass(request.cityClass)
                .incomeClass(request.incomeClass)
                .urbanRural(request.urbanRural)
                .population(request.population)
                .status(request.status)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withIgnoreCase();

        if(request.id == 0){
            matcher = matcher.withIgnorePaths("id");
        }
        if(request.getPopulation() == 0){
            matcher = matcher.withIgnorePaths("population");
        }

        return Example.of(param, matcher);
    }
}
