package com.example.boundigbox.service;

import com.example.boundigbox.model.BoundingBox;
import com.example.boundigbox.repository.BoundingBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoundingBoxService {

    @Autowired
    private BoundingBoxRepository repository;

    public BoundingBox saveBoundingBox(BoundingBox boundingBox) {
        return repository.save(boundingBox);
    }

    public List<BoundingBox> getAllBoundingBox() {
        return repository.getAllBoundingBox();
    }

    public BoundingBox getBoundingBoxById(int id) {
        return repository.findById(id);
    }

    public String deleteBoundingBox(int id) {
        repository.delete(id);
        return "BoundingBox removed !! " + id;
    }

    public List<BoundingBox> findByNameBoundingBox(String name) {
        return repository.search(name);
    }

    public BoundingBox updateBoundingBox(int id, BoundingBox boundingBox) {
        return repository.update(id, boundingBox);
    }

}
