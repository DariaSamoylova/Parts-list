package com.study.service;

import com.study.dao.PartDao;
import com.study.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PartServiceImpl implements PartService {
    @Autowired
    private PartDao partDao;

    public void addPart(Part var1) {
        partDao.addPart(var1);
    }

    public List<Part> getAllParts(String filter, int page) throws Exception {

        return partDao.getAllParts(filter, page);
    }
    @Transactional
    public int getCount(){
        return partDao.getCount();
    }

    public void deletePart(Integer var1) {
        partDao.deletePart(var1);
    }

    public Part updatePart(Part var1) {
        return partDao.updatePart(var1);
    }

    public List<Part> getPart(String detail) {
        return partDao.getPart(detail);
    }


    public Part getPart(int id) {
        return partDao.getPart(id);
    }

    public int getCompsCount() {
        return partDao.getCompsCount();
    }
}
