package com.example.tools.service;

import com.example.tools.domain.Tools;
import com.example.tools.dto.ToolsRequestDTO;
import com.example.tools.repository.ToolsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToolsService {
    private final ToolsRepository repository;

    public List<Tools> findAll() {
        return repository.findAll();
    }

    public List<Tools> findByTag(String tag) {
        return repository.findByTags(tag);
    }

    public Tools create(ToolsRequestDTO toolsRequestDTO) {
        Tools newTools = new Tools(toolsRequestDTO);
        return repository.save(newTools);
    }

    public Tools findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found"));
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
