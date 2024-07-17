package com.redowl.batch_processing.xmlProceser.xmlDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class xmlAddressesDto {
    protected List<xmlTAddressDto> address;
}
