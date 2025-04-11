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
        // 클라이언트 IP 주소 추출
        String userIp = getClientIp(requestHttp);  // getClientIp 메서드 호출

        Content content = contentService.addContent(request, userIp);

        return new ResponseEntity<>(content, HttpStatus.CREATED);

    }

    // 클라이언트 IP 주소를 추출하는 메서드
    private String getClientIp(HttpServletRequest request) {
        String remoteAddr = request.getHeader("X-Forwarded-For");
        if (remoteAddr == null || remoteAddr.isEmpty()) {
            remoteAddr = request.getRemoteAddr();  // 기본적으로 직접 연결된 클라이언트의 IP 주소
        }
        return remoteAddr;  // 클라이언트의 IP 주소 반환
    }
}