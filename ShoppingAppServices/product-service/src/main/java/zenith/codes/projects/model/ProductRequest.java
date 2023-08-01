package zenith.codes.projects.model;

import lombok.Builder;

@Builder
public record ProductRequest(String name, String description, Double price) { //post yaparken
}
