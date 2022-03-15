package com.example.users_rating_test_task.api.controller;

import com.example.users_rating_test_task.api.dto.request.RatingRequestDto;
import com.example.users_rating_test_task.api.dto.response.RatingResponseDto;
import com.example.users_rating_test_task.facade.RatingFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class RatingController {

    private final RatingFacade ratingFacade;

    public RatingController(RatingFacade ratingFacade) {
        this.ratingFacade = ratingFacade;
    }

    @PutMapping("/setinfo")
    public ResponseEntity<Boolean> setRating(@RequestBody RatingRequestDto ratingRequestDto) {
        ratingFacade.setInfo(ratingRequestDto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/levelinfo/{id}")
    public ResponseEntity<List<RatingResponseDto>> levelInfo(@PathVariable Long id) {
        return ResponseEntity.ok(ratingFacade.levelInfo(id));
    }

    @GetMapping("/userinfo/{id}")
    public ResponseEntity<List<RatingResponseDto>> userInfo(@PathVariable Long id) {
        return ResponseEntity.ok(ratingFacade.userInfo(id));
    }
}
