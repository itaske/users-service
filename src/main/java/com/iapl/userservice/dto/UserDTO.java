package com.iapl.userservice.dto;

import com.iapl.userservice.models.Address;
import com.iapl.userservice.models.User;
import com.iapl.userservice.utilities.ModelMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {


    private String id;

    private String name;

    private String username;

    private String phone;

    //@Pattern can be used with specified regex too
    @Email
    private String email;


    private AddressDTO address;


    public static UserDTO convertUserToDTO(User user){
        UserDTO userDTO = new UserDTO();
        ModelMapper.mapNotNullValues(user, userDTO);

        userDTO.setAddress(AddressDTO.convertAddressToDTO(user.getAddress()));
        return userDTO;
    }

}
