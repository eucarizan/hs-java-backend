package dev.njeu.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Accessors(chain = true)
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @UpdateTimestamp
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dateTime;

    private String description;

    @ElementCollection
    private List<String> ingredients;

    @ElementCollection
    private List<String> directions;

    @ManyToOne(optional = false)
    private User creator;
}
