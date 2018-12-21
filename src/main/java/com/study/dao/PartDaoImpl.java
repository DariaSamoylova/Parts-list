package com.study.dao;

import com.study.model.Part;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PartDaoImpl implements PartDao {
    @Autowired
    private SessionFactory sessionFactory;
    private int notesPerPage = 10;
    private int count;

    public PartDaoImpl() {
    }

    public void addPart(Part var1) {
        this.sessionFactory.getCurrentSession().saveOrUpdate(var1);
    }

    public List<Part> getAllParts(String filter, int page) throws Exception {
        Query query;
        if (filter.equals("Req")) {
            query = this.sessionFactory.getCurrentSession().createQuery("from Part as Part where Part.required = true ");
        } else if (filter.equals("Opt")) {
            query = this.sessionFactory.getCurrentSession().createQuery("from Part as Part where Part.required = false ");
        } else
            query = this.sessionFactory.getCurrentSession().createQuery("from Part as Part");
        System.out.println(count);
        count = query.list().size();
        System.out.println(count);
        query.setFirstResult((page - 1) * notesPerPage);
        query.setMaxResults(notesPerPage);
        List<Part> result = query.list();


        return result;
    }

    public void deletePart(Integer var1) {
        Part part = this.sessionFactory.getCurrentSession().load(Part.class, var1);
        if (null != part)
            this.sessionFactory.getCurrentSession().delete(part);
    }

    public Part updatePart(Part var1) {
        this.sessionFactory.getCurrentSession().update(var1);
        return var1;
    }

    public List<Part> getPart(String det) {

        List<Part> results = this.sessionFactory.getCurrentSession().createQuery("from Part p  where p.detail = ?1 ", Part.class)
                .setParameter(1, det)
                .getResultList();


        return results;

    }


    public int getCount() {
        return count;
    }

    @Override
    public Part getPart(int id) {
        List<Part> results = this.sessionFactory.getCurrentSession().createQuery("from Part p  where p.id = ?1 ", Part.class)
                .setParameter(1, id)
                .getResultList();
        return results.get(0);
    }

    public int getCompsCount() {
        List<Part> results = this.sessionFactory.getCurrentSession().createQuery("from Part p  where p.required=true", Part.class)
                .getResultList();
        results.stream();
        List<Integer> counts = results.stream()
                .map(Part::getCount)
                .collect(Collectors.toList());
        return Collections.min(counts);
        //через стрим апи получить список count и найти  Минимальный

    }




}
