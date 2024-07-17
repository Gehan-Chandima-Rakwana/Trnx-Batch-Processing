package com.redowl.batch_processing.xmlProceser.xmlDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class xmlTAddressDto {
    protected String addressType;

    protected String address;
    protected String town;
    protected String city;
    protected String zip;
    protected String countryCode;
    protected String state;

    protected String comments;
}
