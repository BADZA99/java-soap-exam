package com.exam.metier.dao;

import com.exam.metier.entity.Sectors;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.exam.metier.config.HibernateUtil;

public class SectorDao implements ISectorDao {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @Override
    public void addSector(Sectors sector) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(sector);
            transaction.commit();
            System.out.println("Sector added successfully: " + sector);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error while adding sector: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateSector(Sectors sector) {
        Transaction transaction = session.beginTransaction();
        session.update(sector);
        transaction.commit();
    }

    @Override
    public void deleteSector(int id) {
        Transaction transaction = session.beginTransaction();
        Sectors sector = session.get(Sectors.class, id);
        if (sector != null) {
            session.delete(sector);
        }
        transaction.commit();
    }

    @Override
    public List<Sectors> getAllSectors() {
        List<Sectors> sectors = session.createQuery("from Sectors", Sectors.class).list();
        System.out.println("Secteurs récupérés dans SectorDao : " + sectors);
        return sectors;
    }

    @Override
    public Sectors getSectorById(int id) {
        return session.get(Sectors.class, id);
    }
}
