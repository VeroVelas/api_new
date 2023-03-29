package com.basedatos.basededatos.dao.imp;

import com.basedatos.basededatos.dao.ProducerDao;
import com.basedatos.basededatos.models.ProducerModel;
import com.basedatos.basededatos.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class ProducerDaoImp implements ProducerDao {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public List<ProducerModel> getAll(){
        String hql = "FROM ProducerModel as u";
        return (List<ProducerModel>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public ProducerModel get( long id){
        return entityManager.find(ProducerModel.class, id);

    }
    @Transactional
    @Override
    public ProducerModel register( ProducerModel producerModel){
        entityManager.merge(producerModel);
        return producerModel;
    }
    @Transactional
    @Override
    public ProducerModel update( ProducerModel producerModel){
        entityManager.merge(producerModel);
        return producerModel;
    }
    @Transactional
    @Override
    public void delete(  long id){
        ProducerModel producerModel = get(id);
        entityManager.remove(producerModel);
    }
}
