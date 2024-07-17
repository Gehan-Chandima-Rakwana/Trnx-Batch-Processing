package com.redowl.batch_processing.dtos.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RStatusDto implements Serializable {
    private Integer statusId;
    private String description;
    private Boolean isActive;
    private String statusCode;
}
