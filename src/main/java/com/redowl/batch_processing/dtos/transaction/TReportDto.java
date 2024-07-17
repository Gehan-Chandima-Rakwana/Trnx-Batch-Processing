package com.redowl.batch_processing.dtos.transaction;


import com.redowl.batch_processing.dtos.reference.RStatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TReportDto implements Serializable {
    private Integer reportId;
    private String action;
    private String currencyCodeLocal;
    private String entityReference;
    private String fiuRefNumber;
    private Boolean isActive;
    private String location;
    private String reason;
    private String rentityBranch;
    private Integer rentityId;
    private String reportCode;
    private String reportingPerson;
    private String submissionCode;
    private Date submissionDate;

    private RStatusDto RStatus;
    private List<TTransactionDto> transactions;
    private Integer statusId;
}