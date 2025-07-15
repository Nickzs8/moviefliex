package dev.nickzs.moviefliex.controller.interfaces;

import dev.nickzs.moviefliex.controller.request.StreamingRequest;
import dev.nickzs.moviefliex.controller.response.StreamingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Streaming", description = "Resource responsible for streaming platform management")
public interface StreamingControllerApi {

    @Operation(summary = "List all streaming platforms", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = StreamingResponse.class))))
    ResponseEntity<List<StreamingResponse>> getAll();

    @Operation(summary = "Save a new streaming platform", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Streaming successfully saved",
                    content = @Content(schema = @Schema(implementation = StreamingResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    ResponseEntity<StreamingResponse> save(@RequestBody StreamingRequest request);

    @Operation(summary = "Find streaming platform by ID", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Streaming found",
                    content = @Content(schema = @Schema(implementation = StreamingResponse.class))),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<StreamingResponse> findById(@PathVariable long id);

    @Operation(summary = "Delete streaming platform by ID", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Streaming successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<Void> deleteById(@PathVariable Long id);

    @Operation(summary = "Update streaming platform by ID", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Streaming successfully updated",
                    content = @Content(schema = @Schema(implementation = StreamingResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data"),
            @ApiResponse(responseCode = "404", description = "Streaming not found")
    })
    ResponseEntity<StreamingResponse> update(@PathVariable Long id, @RequestBody StreamingRequest request);
}