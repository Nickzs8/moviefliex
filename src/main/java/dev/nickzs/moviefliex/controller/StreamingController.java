package dev.nickzs.moviefliex.controller;

import dev.nickzs.moviefliex.controller.interfaces.StreamingControllerApi;
import dev.nickzs.moviefliex.controller.request.CategoryRequest;
import dev.nickzs.moviefliex.controller.request.StreamingRequest;
import dev.nickzs.moviefliex.controller.response.CategoryResponse;
import dev.nickzs.moviefliex.controller.response.StreamingResponse;
import dev.nickzs.moviefliex.entity.Category;
import dev.nickzs.moviefliex.entity.Streaming;
import dev.nickzs.moviefliex.mapper.CategoryMapper;
import dev.nickzs.moviefliex.mapper.StreamingMapper;
import dev.nickzs.moviefliex.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/moviefliex/streaming")
@RequiredArgsConstructor
public class StreamingController implements StreamingControllerApi {

    private final StreamingService streamingService;

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> getAll() {
        List<StreamingResponse> categories = streamingService.findAll().stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }


    @PostMapping()
    public ResponseEntity<StreamingResponse> save(@Valid @RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        newStreaming = streamingService.save(newStreaming);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                StreamingMapper.toStreamingResponse(newStreaming)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> findById(@PathVariable long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Streaming> optionalStreaming = streamingService.findById(id);

        if (optionalStreaming.isPresent()) {
            streamingService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> update(@PathVariable Long id, @RequestBody StreamingRequest request) {
        return streamingService.update(id, StreamingMapper.toStreaming(request))
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());


    }
}
