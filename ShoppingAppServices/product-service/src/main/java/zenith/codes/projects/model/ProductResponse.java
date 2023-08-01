package zenith.codes.projects.model;

import lombok.Builder;

@Builder
public record ProductResponse(int id, String name, String description, Double price) { //get yaparken
}
