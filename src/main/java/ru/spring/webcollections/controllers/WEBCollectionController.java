package ru.spring.webcollections.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.spring.webcollections.domains.WEBCollection;
import ru.spring.webcollections.repositories.WEBCollectionRepos;

import java.util.List;
import java.util.Map;

@Controller
public class WEBCollectionController {
    @Autowired
    private WEBCollectionRepos collectionRepos;

    @GetMapping
    public String index(Map<String, Object> model) {
        Iterable<WEBCollection> collections = collectionRepos.findAll();
        model.put("collections", collections);
        return "index";
    }

    @GetMapping("/create")
    public String create(Map<String, Object> model) {
        return "create";
    }

    @PostMapping("/create")
    public String create(@RequestParam String name, @RequestParam String description, Map<String, Object> model) {
        WEBCollection collection = new WEBCollection(name, description);
        collectionRepos.save(collection);
        return "redirect:";
    }

    @PostMapping("filter")
    public String create(@RequestParam String filter, Map<String, Object> model) {
        Iterable<WEBCollection> collections;
        if(filter != null && !filter.isEmpty()){
            collections = collectionRepos.findByName(filter);
        } else{
            collections = collectionRepos.findAll();
        }
        model.put("collections", collections);
        return "index";
    }
}
