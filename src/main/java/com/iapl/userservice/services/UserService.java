package com.iapl.userservice.services;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iapl.userservice.dto.RequestParam;
import com.iapl.userservice.dto.ResponseList;
import com.iapl.userservice.dto.UserDTO;
import com.iapl.userservice.models.User;
import com.iapl.userservice.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private RestTemplate restTemplate;

    private UserRepository userRepository;

    private static final String PROXY_URL = "https://jsonplaceholder.typicode.com/users";

    public UserService(RestTemplate restTemplate, UserRepository userRepository){
        this.restTemplate = restTemplate;
        this.userRepository = userRepository;
    }

    public ResponseList<UserDTO> retrieveAllUsers(RequestParam requestParam) {
        requestParam.validate();

        Pageable pageable = PageRequest.of(Integer.valueOf(requestParam.getCurrentPage()), Integer.valueOf(requestParam.getSize()),
                Sort.by(Sort.Direction.valueOf(requestParam.getSortDirection()), requestParam.getSortBy().stream().toArray(String[]::new)));

        Page<User> users = userRepository.findAll(pageable);

        if (!users.isEmpty())
            return ResponseList.createResponseList(users, (user -> UserDTO.convertUserToDTO(user)));

        return new ResponseList<>(retrieveProxyUsers());

    }

    private List<UserDTO> retrieveProxyUsers(){

        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(PROXY_URL, Object[].class);

        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, User.class))
                .map(user -> UserDTO.convertUserToDTO(user))
                .collect(Collectors.toList());

    }


}
