package com.redowl.batch_processing.xmlProceser.xmlConfigDto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rentityId",
    "rentityBranch",
    "submissionCode",
    "reportCode",
    "entityReference",
    "fiuRefNumber",
    "submissionDate",
    "currencyCodeLocal",
    "reportingPerson",
    "location",
    "reason",
    "action",
    "transaction",
    "activity",
    "reportIndicators"
})
@XmlRootElement(name = "report")
public class Report {

    @XmlElement(name = "rentity_id")
    protected int rentityId;
    @XmlElement(name = "rentity_branch")
    protected String rentityBranch;
    @XmlElement(name = "submission_code", required = true)
    protected String submissionCode;
    @XmlElement(name = "report_code", required = true)
    @XmlSchemaType(name = "string")
    protected ReportType reportCode;
    @XmlElementRef(name = "entity_reference", type = JAXBElement.class, required = false)
    protected JAXBElement<String> entityReference;
    @XmlElementRef(name = "fiu_ref_number", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fiuRefNumber;
    @XmlElement(name = "submission_date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submissionDate;
    @XmlElement(name = "currency_code_local", required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyType currencyCodeLocal;

    protected TAddress location;
    protected String reason;
    protected String action;
    protected List<Transaction> transaction;
    @XmlElement(name = "report_indicators", required = true)
    protected ReportIndicators reportIndicators;


    public int getRentityId() {
        return rentityId;
    }
    public void setRentityId(int value) {
        this.rentityId = value;
    }

    public String getRentityBranch() {
        return rentityBranch;
    }

    public void setRentityBranch(String value) {
        this.rentityBranch = value;
    }

    public String getSubmissionCode() {
        return submissionCode;
    }

    public void setSubmissionCode(String value) {
        this.submissionCode = value;
    }

    public ReportType getReportCode() {
        return reportCode;
    }

    public void setReportCode(ReportType value) {
        this.reportCode = value;
    }

    public JAXBElement<String> getEntityReference() {
        return entityReference;
    }

    public void setEntityReference(JAXBElement<String> value) {
        this.entityReference = value;
    }

    public JAXBElement<String> getFiuRefNumber() {
        return fiuRefNumber;
    }

    public void setFiuRefNumber(JAXBElement<String> value) {
        this.fiuRefNumber = value;
    }

    public XMLGregorianCalendar getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(XMLGregorianCalendar value) {
        this.submissionDate = value;
    }

    public CurrencyType getCurrencyCodeLocal() {
        return currencyCodeLocal;
    }
    public void setCurrencyCodeLocal(CurrencyType value) {
        this.currencyCodeLocal = value;
    }


    public TAddress getLocation() {
        return location;
    }
    public void setLocation(TAddress value) {
        this.location = value;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String value) {
        this.reason = value;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String value) {
        this.action = value;
    }

    public List<Transaction> getTransaction() {
        if (transaction == null) {
            transaction = new ArrayList<Transaction>();
        }
        return this.transaction;
    }
    public void setTransaction(List<Transaction> value) {
        this.transaction = value;
    }
    public ReportIndicators getReportIndicators() {
        return reportIndicators;
    }
    public void setReportIndicators(ReportIndicators value) {
        this.reportIndicators = value;
    }




    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "indicator"
    })
    public static class ReportIndicators {

        @XmlElement(required = true)
        @XmlSchemaType(name = "string")
        protected List<ReportIndicatorType> indicator;

        public List<ReportIndicatorType> getIndicator() {
            if (indicator == null) {
                indicator = new ArrayList<ReportIndicatorType>();
            }
            return this.indicator;
        }

        public void setIndicator(List<ReportIndicatorType> indicator) {
            this.indicator = indicator;
        }
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transactionnumber",
        "internalRefNumber",
        "transactionLocation",
        "transactionDescription",
        "dateTransaction",
        "lateDeposit",
        "datePosting",
        "valueDate",
        "transmodeCode",
        "transmodeComment",
        "amountLocal",
        "involvedParties",
        "tFromMyClient",
        "tFrom",
        "tToMyClient",
        "tTo",
        "goodsServices",
        "comments"
    })
    public static class Transaction {

        @XmlElement(required = true)
        protected String transactionnumber;
        @XmlElement(name = "internal_ref_number")
        protected String internalRefNumber;
        @XmlElement(name = "transaction_location")
        protected String transactionLocation;
        @XmlElement(name = "transaction_description", required = true)
        protected String transactionDescription;
        @XmlElement(name = "date_transaction", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dateTransaction;
        @XmlElement(name = "late_deposit")
        protected LateDeposit lateDeposit;
        @XmlElement(name = "date_posting")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar datePosting;
        @XmlElement(name = "value_date")
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar valueDate;
        @XmlElement(name = "transmode_code", required = true)
        protected String transmodeCode;
        @XmlElementRef(name = "transmode_comment", type = JAXBElement.class, required = false)
        protected JAXBElement<String> transmodeComment;
        @XmlElement(name = "amount_local", required = true)
        protected BigDecimal amountLocal;
        @XmlElement(name = "goods_services")
        protected GoodsServices goodsServices;
        protected String comments;

        public String getTransactionnumber() {
            return transactionnumber;
        }

        public void setTransactionnumber(String value) {
            this.transactionnumber = value;
        }

        public String getInternalRefNumber() {
            return internalRefNumber;
        }

        public void setInternalRefNumber(String value) {
            this.internalRefNumber = value;
        }
        public String getTransactionLocation() {
            return transactionLocation;
        }
        public void setTransactionLocation(String value) {
            this.transactionLocation = value;
        }
        public String getTransactionDescription() {
            return transactionDescription;
        }
        public void setTransactionDescription(String value) {
            this.transactionDescription = value;
        }
        public XMLGregorianCalendar getDateTransaction() {
            return dateTransaction;
        }
        public void setDateTransaction(XMLGregorianCalendar value) {
            this.dateTransaction = value;
        }
        public LateDeposit getLateDeposit() {
            return lateDeposit;
        }
        public void setLateDeposit(LateDeposit value) {
            this.lateDeposit = value;
        }
        public XMLGregorianCalendar getDatePosting() {
            return datePosting;
        }
        public void setDatePosting(XMLGregorianCalendar value) {
            this.datePosting = value;
        }
        public XMLGregorianCalendar getValueDate() {
            return valueDate;
        }
        public void setValueDate(XMLGregorianCalendar value) {
            this.valueDate = value;
        }
        public String getTransmodeCode() {
            return transmodeCode;
        }
        public void setTransmodeCode(String value) {
            this.transmodeCode = value;
        }
        public JAXBElement<String> getTransmodeComment() {
            return transmodeComment;
        }
        public void setTransmodeComment(JAXBElement<String> value) {
            this.transmodeComment = value;
        }
        public BigDecimal getAmountLocal() {
            return amountLocal;
        }
        public void setAmountLocal(BigDecimal value) {
            this.amountLocal = value;
        }
        public GoodsServices getGoodsServices() {
            return goodsServices;
        }
        public void setGoodsServices(GoodsServices value) {
            this.goodsServices = value;
        }
        public String getComments() {
            return comments;
        }
        public void setComments(String value) {
            this.comments = value;
        }



        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class GoodsServices {

            @XmlElement(required = true)
            protected List<TTransItem> item;

            public List<TTransItem> getItem() {
                if (item == null) {
                    item = new ArrayList<TTransItem>();
                }
                return this.item;
            }

        }


        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class LateDeposit {

            @XmlValue
            protected boolean value;

            public boolean isValue() {
                return value;
            }

            public void setValue(boolean value) {
                this.value = value;
            }

        }

    }

}
