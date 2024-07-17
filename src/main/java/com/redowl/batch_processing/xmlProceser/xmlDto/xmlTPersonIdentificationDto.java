package com.redowl.batch_processing.xmlProceser.xmlDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class xmlTPersonIdentificationDto {

    protected String type;

    protected String number;
    protected LocalDateTime issueDate;
    protected LocalDateTime expiryDate;
    protected String issuedBy;
    protected String issueCountry;

    protected String comments;
}
