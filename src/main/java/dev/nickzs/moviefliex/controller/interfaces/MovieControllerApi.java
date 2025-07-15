package dev.nickzs.moviefliex.controller.interfaces;

import dev.nickzs.moviefliex.controller.request.MovieRequest;
import dev.nickzs.moviefliex.controller.response.MovieResponse;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "Movie", description = "Resource responsible for movie management")
public interface MovieControllerApi {

    @Operation(summary = "List all movies", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> getAll();

    @Operation(summary = "Save a new movie", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie successfully saved",
                    content = @Content(schema = @Schema(implementation = MovieResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content)
    })
    ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request);

    @Operation(summary = "Find movie by ID", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie found",
                    content = @Content(schema = @Schema(implementation = MovieResponse.class))),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
    })
    ResponseEntity<MovieResponse> findById(@PathVariable Long id);

    @Operation(summary = "Delete movie by ID", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Movie successfully deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
    })
    ResponseEntity<Void> deleteById(@PathVariable Long id);

    @Operation(summary = "Update movie by ID", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie successfully updated",
                    content = @Content(schema = @Schema(implementation = MovieResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content),
            @ApiResponse(responseCode = "404", description = "Movie not found", content = @Content)
    })
    ResponseEntity<MovieResponse> update(@PathVariable Long id, @RequestBody MovieRequest request);

    @Operation(summary = "Find movies by category", security = {@SecurityRequirement(name = "bearerAuth")})
    @ApiResponse(responseCode = "200", description = "Successful operation",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieResponse.class))))
    ResponseEntity<List<MovieResponse>> findByCategory(@RequestParam Long categoryId);
}