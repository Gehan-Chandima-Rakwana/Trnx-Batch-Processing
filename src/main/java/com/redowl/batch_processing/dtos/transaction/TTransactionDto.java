package com.redowl.batch_processing.dtos.transaction;

import com.redowl.batch_processing.dtos.reference.RStatusDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TTransactionDto implements Serializable {
    private Integer transactionId;
    private BigDecimal amountLocal;
    private String authorized;
    private String comments;
    private LocalDate datePosting;
    private LocalDate dateTransaction;
    private String goodsServices;
    private String internalRefNumber;
    private Boolean isActive;
    private Boolean lateDeposit;
    private String teller;
    private String transactionDescription;
    private String transactionLocation;
    private String transactionNumber;
    private String transmodeComment;
    private LocalDate valueDate;
    private String trxNo;
    private String rptCode;
    private RStatusDto RStatus;
    private TReportDto TReport;

    private Integer conductionTypeId;
    private Integer statusId;
    private Integer reportId;
    private String custId;
    private String acid ;
}