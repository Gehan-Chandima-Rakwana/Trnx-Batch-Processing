package com.redowl.batch_processing.xmlProceser.xmlDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class xmlReportDto {

    protected int rentityId;
    protected String rentityBranch;
    protected String submissionCode;
    protected String reportCode;
    protected String entityReference;
    protected String fiuRefNumber;
    protected LocalDateTime submissionDate;
    protected xmlCurrencyTypeDto currencyCodeLocal;

    protected String reason;

    protected String action;

    protected List<xmlTransactionDto> transaction;
    protected xmlReportIndicatorsDto reportIndicators;
}
