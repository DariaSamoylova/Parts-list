package com.study.service;

import com.study.model.Part;

import java.util.List;

public interface PartService {
    void addPart(Part var1);

    List<Part> getAllParts(String filter, int page) throws Exception;

    int getCount();

    void deletePart(Integer var1);

    Part updatePart(Part var1);

    List<Part> getPart(String detail);

    Part getPart(int id);

    int getCompsCount();
}
