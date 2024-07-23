package com.redowl.batch_processing.xmlProceser.service;


import com.redowl.batch_processing.xmlProceser.utils.XmlUtils;
import com.redowl.batch_processing.xmlProceser.xmlConfigDto.CurrencyType;
import com.redowl.batch_processing.xmlProceser.xmlConfigDto.Report;
import com.redowl.batch_processing.xmlProceser.xmlConfigDto.ReportIndicatorType;
import com.redowl.batch_processing.xmlProceser.xmlConfigDto.ReportType;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlReportDto;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlReportIndicatorTypeDto;
import com.redowl.batch_processing.xmlProceser.xmlDto.xmlTransactionDto;

import java.util.ArrayList;
import java.util.List;

public class ReportService {

    public Report generateReportTag(xmlReportDto xmlReportDto) {

        Report report = new Report();
//        XmlUtils.setIfNotNull(report, xmlReportDto.getRentityId(), Report::setRentityId);
//        XmlUtils.setIfNotNull(report, xmlReportDto.getRentityBranch(), Report::setRentityBranch);

        if (xmlReportDto != null) {

            report.setRentityId(xmlReportDto.getRentityId());

            if (xmlReportDto.getRentityBranch() != null)
                report.setRentityBranch(xmlReportDto.getRentityBranch());

            if (xmlReportDto.getSubmissionCode() != null)
                report.setSubmissionCode(xmlReportDto.getSubmissionCode());

            if (xmlReportDto.getReportCode() != null)
                report.setReportCode(ReportType.fromValue(xmlReportDto.getReportCode()));

//            if (xmlReportDto.getEntityReference() != null)
//                report.setEntityReference(XmlUtils.createJAXBElement("entity_reference", xmlReportDto.getEntityReference()));
//
//            if (xmlReportDto.getFiuRefNumber() != null)
//                report.setFiuRefNumber(XmlUtils.createJAXBElement("fiu_ref_number", xmlReportDto.getFiuRefNumber()));

            if (xmlReportDto.getSubmissionDate() != null)
                report.setSubmissionDate(XmlUtils.createXMLGregorianCalendar(xmlReportDto.getSubmissionDate().toString()));

            if (xmlReportDto.getCurrencyCodeLocal() != null)
                report.setCurrencyCodeLocal(CurrencyType.fromValue(xmlReportDto.getCurrencyCodeLocal().getCurrencyCode()));

            if (xmlReportDto.getReason() != null)
                report.setReason(xmlReportDto.getReason());

            if (xmlReportDto.getAction() != null)
                report.setAction(xmlReportDto.getAction());


            if (xmlReportDto.getTransaction() != null && !xmlReportDto.getTransaction().isEmpty()) {
                List<Report.Transaction> transactionList = new ArrayList<>();
                for (xmlTransactionDto transactionDto : xmlReportDto.getTransaction()) {
                    TransactionService transactionService = new TransactionService();
                    transactionList.add(transactionService.generateTransactionTag(transactionDto));
                }
                report.setTransaction(transactionList);
            }



            if (xmlReportDto.getReportIndicators() != null && (xmlReportDto.getReportIndicators().getIndicator() != null && !xmlReportDto.getReportIndicators().getIndicator().isEmpty())) {
                Report.ReportIndicators reportIndicators = new Report.ReportIndicators();
                if (xmlReportDto.getReportIndicators().getIndicator() != null && !xmlReportDto.getReportIndicators().getIndicator().isEmpty()) {
                    List<ReportIndicatorType> indicator = new ArrayList<>();
                    for (xmlReportIndicatorTypeDto indicatorDto : xmlReportDto.getReportIndicators().getIndicator()) {
                        ReportIndicatorType indicatorType = ReportIndicatorType.fromValue(indicatorDto.getValue());
                        indicator.add(indicatorType);
                    }
                    reportIndicators.setIndicator(indicator);

                }
                report.setReportIndicators(reportIndicators);
            }
        }

        return report;
    }



}
