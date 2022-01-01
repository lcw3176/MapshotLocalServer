package com.joebrooks.mapshotserver.domain.kakaoMap.controller;

import com.joebrooks.mapshotserver.domain.kakaoMap.dto.KakaoMap;
import com.joebrooks.mapshotserver.domain.kakaoMap.service.ChromeDriverService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("https://testservermapshot.netlify.app")
@RestController
@RequestMapping("/proxy/kakao")
public class KakaoMapController {

    private final ChromeDriverService chromeDriverService;

    public KakaoMapController(ChromeDriverService chromeDriverService){
        this.chromeDriverService = chromeDriverService;
    }

    @PostMapping
    public ResponseEntity requestMapImage(@RequestBody KakaoMap kakaoMapInfo) throws Exception {

        byte[] srcFile = chromeDriverService.getImage(kakaoMapInfo);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }


}

