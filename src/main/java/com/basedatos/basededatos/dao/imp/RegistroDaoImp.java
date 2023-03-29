package com.basedatos.basededatos.dao.imp;

import com.basedatos.basededatos.dao.RegistroDao;
import com.basedatos.basededatos.models.RegistroModel;
import com.basedatos.basededatos.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class RegistroDaoImp implements RegistroDao {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public List<RegistroModel> getAll(){
        String hql = "FROM RegistroModel as u";
        return (List<RegistroModel>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public RegistroModel get( long id){
        return entityManager.find(RegistroModel.class, id);

    }
    @Transactional
    @Override
    public RegistroModel register( RegistroModel registroModel){
        entityManager.merge(registroModel);
        return registroModel;
    }
    @Transactional
    @Override
    public RegistroModel update( RegistroModel registroModel){
        entityManager.merge(registroModel);
        return registroModel;
    }
    @Transactional
    @Override
    public void delete(  long id){
        RegistroModel registroModel = get(id);
        entityManager.remove(registroModel);
    }
}
