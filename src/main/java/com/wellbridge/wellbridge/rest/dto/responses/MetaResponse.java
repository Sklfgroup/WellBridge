package com.wellbridge.wellbridge.rest.dto.responses;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MetaResponse {
    private boolean hasPrevious;
    private boolean hasNext;
    private int total;
}
