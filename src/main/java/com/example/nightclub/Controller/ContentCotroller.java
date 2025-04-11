package com.example.nightclub.Controller;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.DTO.ContentResponceDto;
import com.example.nightclub.Repository.ContentRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.nightclub.Entity.Content;
import com.example.nightclub.Service.ContentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ContentCotroller {
    private final ContentService contentService;


    @GetMapping("/api/content")
    public ResponseEntity<List<ContentResponceDto>> getAllContents(){
        List<ContentResponceDto> Allcontents = contentService.findAll()
                .stream()
                .map(ContentResponceDto::new)
                .toList();

        return ResponseEntity.ok(Allcontents);
    }


}
