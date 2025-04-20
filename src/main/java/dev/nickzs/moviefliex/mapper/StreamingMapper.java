package dev.nickzs.moviefliex.mapper;

import dev.nickzs.moviefliex.controller.request.StreamingRequest;
import dev.nickzs.moviefliex.controller.response.StreamingResponse;
import dev.nickzs.moviefliex.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
