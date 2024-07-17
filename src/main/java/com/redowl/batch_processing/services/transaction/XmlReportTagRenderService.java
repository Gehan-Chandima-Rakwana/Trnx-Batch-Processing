package com.redowl.batch_processing.services.transaction;


import com.redowl.batch_processing.xmlProceser.xmlDto.xmlReportDto;

public interface XmlReportTagRenderService {
    xmlReportDto getRenderedReport(String reportCode);
}
