package ch.c0de.skill.spring6webapp.controllers;

import ch.c0de.skill.spring6webapp.services.ObjectStorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ObjectListController {

    private final ObjectStorageService storageService;

    public ObjectListController(ObjectStorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/objects")
    public List<String> listObjects() {
        return storageService.listObjects();
    }
}