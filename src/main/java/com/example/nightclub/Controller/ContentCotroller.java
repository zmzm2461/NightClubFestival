package com.example.nightclub.Controller;

import com.example.nightclub.DTO.ContentRequestDto;
import com.example.nightclub.Entity.Content;
import com.example.nightclub.Service.ContentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@AllArgsConstructor

public class ContentCotroller {
    private final ContentService contentService;

    @PostMapping("/api/ClubContent")
    public ResponseEntity<String> addContent(@RequestBody ContentRequestDto request, HttpServletRequest requestHttp) {
        // 클라이언트 IP 주소 추출
        String userid = requestHttp.getRemoteAddr();

        String content = contentService.addContent(request, userid);

        return new ResponseEntity<>(content, HttpStatus.CREATED);

    }

}