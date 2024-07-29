package com.example.tools.service;

import com.example.tools.domain.Tools;
import com.example.tools.dto.ToolsRequestDTO;
import com.example.tools.repository.ToolsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ToolsServiceTest {

    @InjectMocks
    private ToolsService service;
    @Mock
    private ToolsRepository repository;


    @Test
    @DisplayName("findAll return List of Tools when successfully")
    void findAll_ReturnListTools_WhenSuccessfully() {
        Set<String> tags = new HashSet<>(List.of("test", "test2", "test3", "test4"));
        var tools = List.of(new Tools(1L, "test", "www.test.com", "test test", tags));

        when(repository.findAll()).thenReturn(tools);

        List<Tools> findAll = service.findAll();

        assertNotNull(findAll);
        assertEquals(1, findAll.size());
        assertEquals(findAll.getFirst().getId(), tools.getFirst().getId());
    }

    @Test
    @DisplayName("findByTag return tools by tag when successfully")
    void findByTag_ReturnToolsByTag_WhenSuccessfully() {
        Set<String> tags = new HashSet<>(List.of("test", "test2", "test3", "test4"));
        var tools = List.of(new Tools(1L, "test", "www.test.com", "test test", tags));

        when(repository.findByTags(any())).thenReturn(tools);

        List<Tools> findByTag = service.findByTag("test");

        assertNotNull(findByTag);
        assertEquals(1, findByTag.size());
        assertEquals(findByTag.getFirst().getId(), findByTag.getFirst().getId());
    }

    @Test
    @DisplayName("create new tools when successfully")
    void create_CreateNewTools_WhenSuccessfully() {
        Set<String> tags = new HashSet<>(List.of("test", "test2", "test3", "test4"));
        var toolsDTO = new ToolsRequestDTO("test", "www.test.com", "test test", tags);
        var tools = new Tools(toolsDTO);

        when(repository.save(any())).thenReturn(tools);

        Tools newTools = service.create(toolsDTO);

        assertNotNull(newTools);
        assertEquals(newTools.getTitle(), toolsDTO.title());
    }

    @Test
    @DisplayName("findById return tools by id when successfully")
    void findById_ReturnToolsById_WhenSucessfully() {
        Set<String> tags = new HashSet<>(List.of("test", "test2", "test3", "test4"));
        var tools = new Tools(1L, "test", "www.test.com", "test test", tags);

        when(repository.findById(1L)).thenReturn(Optional.of(tools));

        Tools findById = service.findById(1L);

        assertNotNull(findById);
        assertEquals(findById.getId(), tools.getId());
        assertDoesNotThrow(() -> service.findById(1L));
    }

    @Test
    @DisplayName("findById throw IllegalArgumentException when not found Tools by id")
    void findById_ThrowIllegalArgumentException_WhenToolsNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.findById(1L));
    }

}