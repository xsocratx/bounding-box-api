package com.example.boundigbox.controller;

import com.example.boundigbox.model.BoundingBox;
import com.example.boundigbox.service.BoundingBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bounding-boxes")
public class BoundingBoxController {

    @Autowired
    private BoundingBoxService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BoundingBox addBoundingBox(@RequestBody BoundingBox boundingBox) {
        return service.saveBoundingBox(boundingBox);
    }

    @GetMapping
    public List<BoundingBox> findAllBoundingBox() {
        return service.getAllBoundingBox();
    }

    @GetMapping(path = "/{id}")
    public BoundingBox findBoundingBoxById(@PathVariable int id) {
        return service.getBoundingBoxById(id);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public BoundingBox updateBoundingBox(@PathVariable int id, @RequestBody BoundingBox boundingBox) {
        return service.updateBoundingBox(id, boundingBox);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteBoundingBox(@PathVariable int id) {
        return service.deleteBoundingBox(id);
    }

    @GetMapping(path = "/find-by-name/{name}")
    public List<BoundingBox> findBoundingBoxByName(@PathVariable String name) {
        return service.findByNameBoundingBox(name);
    }

}
