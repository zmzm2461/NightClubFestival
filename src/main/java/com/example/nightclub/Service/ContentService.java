package com.example.nightclub.Service;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.Entity.Content;
import com.example.nightclub.Repository.ContentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service

public class ContentService {
    private final ContentRepository contentRepository;

    public Content save(ContentRequestDto request) {
        Content content = request.toEntity();
        return contentRepository.save(content);
    }


}
