package com.iapl.userservice.dto;

import com.iapl.userservice.models.Address;
import com.iapl.userservice.utilities.ModelMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class AddressDTO {

    private String id;

    private String street;

    private String city;

    private String zipcode;


    public static AddressDTO convertAddressToDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();
        ModelMapper.mapNotNullValues(address, addressDTO);

        return addressDTO;
    }


}
