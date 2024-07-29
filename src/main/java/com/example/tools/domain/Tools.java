package com.example.tools.domain;

import com.example.tools.dto.ToolsRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tools")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tools {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String link;
    private String description;
    private Set<String> tags;

    public Tools(ToolsRequestDTO requestDTO) {
        this.title = requestDTO.title();
        this.link = requestDTO.link();
        this.description = requestDTO.description();
        this.tags = requestDTO.tags();
    }
}
