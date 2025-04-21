package dev.nickzs.moviefliex.repository;

import dev.nickzs.moviefliex.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingRepository extends JpaRepository<Streaming, Long> {

}
