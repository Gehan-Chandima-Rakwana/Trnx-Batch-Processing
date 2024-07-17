package com.redowl.batch_processing.xmlProceser.xmlDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class xmlTransactionDto {

    protected String transactionnumber;
    protected String internalRefNumber;
    protected String transactionLocation;
    protected String transactionDescription;
    protected LocalDateTime dateTransaction;
    protected xmlLateDepositDto lateDeposit;
    protected LocalDateTime datePosting;
    protected LocalDateTime valueDate;
    protected String transmodeCode;
    protected String transmodeComment;
    protected BigDecimal amountLocal;

    protected String comments;
}
