package com.basedatos.basededatos.dao.imp;

import com.basedatos.basededatos.dao.MarkerDao;
import com.basedatos.basededatos.models.MakerModel;
import com.basedatos.basededatos.models.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class MarkerDaoImp implements MarkerDao {


    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public List<MakerModel> getAll(){
        String hql = "FROM MakerModel as u";
        return (List<MakerModel>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public MakerModel get( long id){
        return entityManager.find(MakerModel.class, id);

    }
    @Transactional
    @Override
    public MakerModel register( MakerModel makerModel){
        entityManager.merge(makerModel);
        return makerModel;
    }
    @Transactional
    @Override
    public MakerModel update( MakerModel makerModel){
        entityManager.merge(makerModel);
        return makerModel;
    }
    @Transactional
    @Override
    public void delete(  long id){
        MakerModel makerModel = get(id);
        entityManager.remove(makerModel);
    }
}
