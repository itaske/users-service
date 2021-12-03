package com.iapl.userservice.controllers;

import com.iapl.userservice.dto.RequestParam;
import com.iapl.userservice.dto.ResponseList;
import com.iapl.userservice.dto.UserDTO;
import com.iapl.userservice.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "Get All Users",
            notes = "Retrieves all users in the system and if empty retrieves from proxy url and filter by properties")
    public ResponseList<UserDTO> retrieveAllUsers(@ModelAttribute RequestParam requestParam){

        return userService.retrieveAllUsers(requestParam);
    }
}
