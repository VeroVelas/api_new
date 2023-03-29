package com.basedatos.basededatos.controllers;

import com.basedatos.basededatos.models.RegistroModel;
import com.basedatos.basededatos.models.UserModel;
import com.basedatos.basededatos.services.RegistroService;
import com.basedatos.basededatos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/registro")

public class RegistroController {

    @Autowired
    RegistroService registroService;

    @GetMapping("/getAll")
    List<RegistroModel> getAllUser(){
        return registroService.getAll();
    }

    @GetMapping(value = "/getId/{id}")
    RegistroModel getUserById(@PathVariable("id") long id ){
        return registroService.get(id);
    }

    @PostMapping(value = "/create")
    RegistroModel createUser(@RequestBody RegistroModel registroModel){
        return registroService.register(registroModel);
    }



    @PutMapping(value = "/update/{id}")
    RegistroModel updateUserById(@RequestBody RegistroModel registroModel ){
        return registroService.update(registroModel);
    }

    @DeleteMapping(value = "/delete/{id}")
    void  deleteUserById(@PathVariable("id") long id){
        registroService.delete(id);
    }
}
