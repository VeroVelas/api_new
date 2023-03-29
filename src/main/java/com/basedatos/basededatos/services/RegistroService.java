package com.basedatos.basededatos.services;

import com.basedatos.basededatos.dao.RegistroDao;
import com.basedatos.basededatos.dao.UserDao;
import com.basedatos.basededatos.models.RegistroModel;
import com.basedatos.basededatos.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@CrossOrigin
public class RegistroService {

    @Autowired
    RegistroDao registroDao;

    public List<RegistroModel> getAll(){return registroDao.getAll();
    }

    public RegistroModel get( long id){

        return registroDao.get(id);
    }

    public RegistroModel register( RegistroModel registroModel){
        return registroDao.register(registroModel);
    }

    public RegistroModel update(@RequestBody RegistroModel registroModel){
        return registroDao.update(registroModel);
    }

    public void delete(@PathVariable long id){
        registroDao.delete(id);
    }
}
