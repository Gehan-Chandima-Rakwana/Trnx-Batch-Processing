package com.redowl.batch_processing.xmlProceser.service;


import com.redowl.batch_processing.xmlProceser.utils.XmlUtils;
import com.redowl.batch_processing.xmlProceser.xmlConfigDto.Report;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlTransactionDto;

public class TransactionService {

    public Report.Transaction generateTransactionTag(xmlTransactionDto transactionDto) {

        Report.Transaction transaction = new Report.Transaction();
        if (transactionDto.getTransactionnumber() != null)
            transaction.setTransactionnumber(transactionDto.getTransactionnumber());

        if (transactionDto.getInternalRefNumber() != null)
            transaction.setInternalRefNumber(transactionDto.getInternalRefNumber());

        if (transactionDto.getTransactionLocation() != null)
            transaction.setTransactionLocation(transactionDto.getTransactionLocation());

        if (transactionDto.getTransactionDescription() != null)
            transaction.setTransactionDescription(transactionDto.getTransactionDescription());

        if (transactionDto.getDateTransaction() != null)
            transaction.setDateTransaction(XmlUtils.createXMLGregorianCalendar(transactionDto.getDateTransaction().toString()));

//        if (transactionDto.getLateDeposit() != null) {
//            LateDepositService lateDepositService = new LateDepositService();
//            transaction.setLateDeposit(lateDepositService.generateLateDepositTag(transactionDto.getLateDeposit()));
//        }

        if (transactionDto.getDatePosting() != null)
            transaction.setDatePosting(XmlUtils.createXMLGregorianCalendar(transactionDto.getDatePosting().toString()));

        if (transactionDto.getValueDate() != null)
            transaction.setValueDate(XmlUtils.createXMLGregorianCalendar(transactionDto.getValueDate().toString()));

        if (transactionDto.getTransmodeCode() != null)
            transaction.setTransmodeCode(transactionDto.getTransmodeCode());

        if (transactionDto.getTransmodeComment() != null)
            transaction.setTransmodeComment(XmlUtils.createJAXBElement("transmode_comment", transactionDto.getTransmodeComment()));

        if (transactionDto.getAmountLocal() != null)
            transaction.setAmountLocal(transactionDto.getAmountLocal());


//        transaction.setGoodsServices(new Report.Transaction.GoodsServices());

        if (transactionDto.getComments() != null)
            transaction.setComments(transactionDto.getComments());

        return transaction;
    }
}
