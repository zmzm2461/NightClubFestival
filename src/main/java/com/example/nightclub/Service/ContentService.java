package com.example.nightclub.Service;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.nightclub.Entity.Content;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public Content save(ContentRequestDto request){
        return contentRepository.save(request.toEntity());
    }
   public List<Content> findAll(){
        return contentRepository.findAll();
   }
}
