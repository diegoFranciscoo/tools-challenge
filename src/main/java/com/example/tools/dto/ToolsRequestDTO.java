package com.example.tools.dto;

import java.util.List;
import java.util.Set;

public record ToolsRequestDTO(String title, String link, String description, Set<String> tags)  {
}
