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

@RestController
@AllArgsConstructor

public class ContentCotroller {
    private final ContentService contentService;

    @PostMapping("/api/ClubContent")
    public ResponseEntity<Content> addContent(@RequestBody ContentRequestDto request, HttpServletRequest requestHttp) {
        String userIp = getClientIp(requestHttp);
        request.setUser_id(userIp);
    }
}
