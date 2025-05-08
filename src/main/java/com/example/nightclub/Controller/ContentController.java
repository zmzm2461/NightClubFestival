package com.example.nightclub.Controller;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.DTO.ContentResponceDto;
import com.example.nightclub.Service.ContentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor

public class ContentController {
    private final ContentService contentService;


    @GetMapping("/api/content")
    public ResponseEntity<List<ContentResponceDto>> getAllContents(){
        List<ContentResponceDto> Allcontents = contentService.findAll()
                .stream()
                .map(ContentResponceDto::new)
                .toList();

        return ResponseEntity.ok(Allcontents);
    }
    @PostMapping("/api/ClubContent")
    public ResponseEntity<String> addContent(@RequestBody ContentRequestDto request, HttpServletRequest requestHttp) {
        // 클라이언트 IP 주소 추출
        String userid = requestHttp.getRemoteAddr();

        String content = contentService.addContent(request, userid);

        return new ResponseEntity<>(content, HttpStatus.CREATED);

    }

    @DeleteMapping("/api/ClubContent")
    public ResponseEntity<String> deleteContent(HttpServletRequest requestHttp, @RequestParam Long postId) {
        String userid = requestHttp.getRemoteAddr(); // 클라이언트 IP
        String result = contentService.deleteContent(userid, postId);

        return ResponseEntity.ok(result);
    }

}

