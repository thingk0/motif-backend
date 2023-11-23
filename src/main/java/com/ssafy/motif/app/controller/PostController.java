package com.ssafy.motif.app.controller;

import com.ssafy.motif.app.domain.dto.post.PostRequestDto;
import com.ssafy.motif.app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<?> create(
        @RequestBody PostRequestDto requestDto,
        @ApiIgnore Authentication authentication
    ) {
        postService.create(requestDto, authentication.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(requestDto);
    }
    
    @GetMapping("/paging/{pageId}")
    public ResponseEntity<?> postPaging(@PathVariable int pageId){
    	int size=20; // 페이징 사이즈
    	return ResponseEntity.ok(postService.postPaging(pageId, size));
    }

    @GetMapping("/select/{postId}")
    public ResponseEntity<?> postSelect(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.postSelect(postId));

    }

    @PutMapping("/modify")
    public ResponseEntity<?> postModify(PostRequestDto postRequestDto) {
        postService.postModify(postRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> postDelete(@PathVariable Long postId) {
        postService.postDelete(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}