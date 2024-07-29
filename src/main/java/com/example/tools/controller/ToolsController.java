package com.example.tools.controller;

import com.example.tools.domain.Tools;
import com.example.tools.dto.ToolsRequestDTO;
import com.example.tools.service.ToolsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
@RequiredArgsConstructor
public class ToolsController {
    private final ToolsService service;

    @GetMapping
    public ResponseEntity<List<Tools>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping(path = "/tag")
    public ResponseEntity<List<Tools>> findByTag(@RequestParam String tag){
       return new ResponseEntity<>(service.findByTag(tag), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tools> create(@RequestBody ToolsRequestDTO toolsRequestDTO) {
        return new ResponseEntity<>(service.create(toolsRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
