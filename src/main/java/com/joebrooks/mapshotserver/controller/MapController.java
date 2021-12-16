package com.joebrooks.mapshotserver.controller;

import com.joebrooks.mapshotserver.domain.KakaoMap;
import com.joebrooks.mapshotserver.service.ChromeDriverService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("https://testservermapshot.netlify.app")
@RestController
@RequestMapping("/proxy/kakao")
public class MapController {

    private final ChromeDriverService chromeDriverService;

    public MapController(ChromeDriverService chromeDriverService){
        this.chromeDriverService = chromeDriverService;
    }

    @PostMapping
    public ResponseEntity requestMapImage(@RequestBody KakaoMap kakaoMapInfo) {

        String srcFile = chromeDriverService.getImage(kakaoMapInfo);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }


}

