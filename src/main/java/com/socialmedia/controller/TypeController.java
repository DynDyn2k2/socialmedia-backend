package com.socialmedia.controller;

import com.socialmedia.model.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.service.TypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/types")
@CrossOrigin
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/id/{id}")
    public Types getTypeById(@PathVariable("id") int id) {
        Optional<Types> optionalType = typeService.findById(id);
        Types type = new Types();
        if (optionalType.isPresent()) {
            type = optionalType.get();
        }
        return type;
    }
    
    @PostMapping("/add")
    public boolean saveType(@RequestBody Types type) {
        typeService.saveType(type);
        return true;
    }
    
    @GetMapping("/getAll")
    public List<Types> getAllTypes() {
        return typeService.getAllTypes();
    }
}