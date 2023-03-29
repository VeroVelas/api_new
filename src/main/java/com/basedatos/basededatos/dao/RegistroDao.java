package com.basedatos.basededatos.dao;

import com.basedatos.basededatos.models.RegistroModel;
import com.basedatos.basededatos.models.UserModel;

import java.util.List;

public interface RegistroDao {
    List<RegistroModel> getAll();

    RegistroModel get( long id);

    RegistroModel register( RegistroModel registroModel);

    RegistroModel update( RegistroModel registroModel);

    void delete(  long id);
}
