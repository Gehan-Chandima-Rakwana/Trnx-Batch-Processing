package com.redowl.batch_processing.models.transaction;

import com.redowl.batch_processing.models.reference.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The persistent class for the t_transaction database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_TRANSACTION", indexes = {
		@Index(name = "T_TRANSACTION_T_REPORT1_idx", columnList = "REPORT_ID")
})
public class TTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_TRANSACTION", allocationSize = 1, sequenceName="T_TRANSACTION_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_TRANSACTION")
	@Column(name="TRANSACTION_ID")
	private Integer transactionId;

	@Column(name="AMOUNT_LOCAL")
	private BigDecimal amountLocal;

	@Column(name="AUTHORIZED")
	private String authorized;

	@Column(name="COMMENTS")
	private String comments;

	@Column(name="DATE_POSTING")
	private LocalDate datePosting;

	@Column(name="DATE_TRANSACTION")
	private LocalDate dateTransaction;

	@Column(name="GOODS_SERVICES")
	private String goodsServices;

	@Column(name="INTERNAL_REF_NUMBER")
	private String internalRefNumber;

	@Column(name="IS_ACTIVE")
	private Boolean isActive;

	@Column(name="LATE_DEPOSIT")
	private Boolean lateDeposit;

	@Column(name = "TELLER")
	private String teller;

	@Column(name = "TRX_NO", length = 50 )
	private String trxNo;

	@Column(name = "RPT_CODE", length = 50)
	private String rptCode;

	@Column(name="TRANSACTION_DESCRIPTION")
	private String transactionDescription;

	@Column(name="TRANSACTION_LOCATION")
	private String transactionLocation;

	@Column(name="TRANSACTION_NUMBER")
	private String transactionNumber;

	@Column(name="TRANSMODE_COMMENT")
	private String transmodeComment;

	@Column(name="VALUE_DATE")
	private LocalDate valueDate;

	@Column(name = "CUST_ID", length = 9)
	private String custId;

	@Column(name = "ACID", length = 11)
	private String acid ;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false)
	private RStatus RStatus;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REPORT_ID", referencedColumnName = "REPORT_ID", nullable = false)
	private TReport TReport;

}