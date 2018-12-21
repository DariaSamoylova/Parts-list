package com.study.dao;

import com.study.model.Part;

import java.util.List;

public interface PartDao {
    void addPart(Part var1);

    List<Part> getAllParts(String filter, int page) throws Exception;

    void deletePart(Integer var1);

    int getCount();
    Part updatePart(Part var1);

    List<Part> getPart(String detail);
    Part getPart(int id);
      int getCompsCount() ;
}
