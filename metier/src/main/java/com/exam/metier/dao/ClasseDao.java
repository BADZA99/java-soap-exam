package com.exam.metier.dao;

import com.exam.metier.entity.Classes;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.exam.metier.config.HibernateUtil;

public class ClasseDao implements IClasseDao {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public void addClasse(Classes classe) {
        Transaction transaction = session.beginTransaction();
        session.save(classe);
        transaction.commit();
    }

    @Override
    public void updateClasse(Classes classe) {
        Transaction transaction = session.beginTransaction();
        session.update(classe);
        transaction.commit();
    }

    @Override
    public void deleteClasse(int id) {
        Transaction transaction = session.beginTransaction();
        Classes classe = session.get(Classes.class, id);
        if (classe != null) {
            session.delete(classe);
        }
        transaction.commit();
    }

    @Override
    public List<Classes> getAllClasses() {
        return session.createQuery("from Classes", Classes.class).list();
    }

    @Override
    public List<Classes> getClassesBySector(Long sectorId) {
        return session.createQuery("from Classes where sector.id = :sectorId", Classes.class)
                      .setParameter("sectorId", sectorId)
                      .list();
    }

    @Override
    public Classes getClasseById(int id) {
        return session.get(Classes.class, id);
    }
}
