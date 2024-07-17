package com.redowl.batch_processing.models.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the t_report database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_REPORT", indexes = {
		@Index(name = "T_REPORT_R_STATUS1_idx", columnList = "STATUS_ID")
})
public class TReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="T_REPORT", allocationSize = 1, sequenceName="T_REPORT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="T_REPORT")
	@Column(name="REPORT_ID")
	private Integer reportId;

	@Column(name = "ACTION")
	private String action;

	@Column(name="CURRENCY_CODE_LOCAL")
	private String currencyCodeLocal;

	@Column(name="ENTITY_REFERENCE")
	private String entityReference;

	@Column(name="FIU_REF_NUMBER")
	private String fiuRefNumber;

	@Column(name="IS_ACTIVE")
	private Boolean isActive;

	@Column(name = "LOCATION")
	private String location;

	@Column(name="REASON")
	private String reason;

	@Column(name="RENTITY_BRANCH")
	private String rentityBranch;

	@Column(name="RENTITY_ID")
	private Integer rentityId;

	@Column(name="REPORT_CODE")
	private String reportCode;

	@Column(name="REPORTING_PERSON")
	private String reportingPerson;

	@Column(name="SUBMISSION_CODE")
	private String submissionCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="SUBMISSION_DATE")
	private Date submissionDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="STATUS_ID", referencedColumnName = "STATUS_ID", nullable = false)
	private com.redowl.batch_processing.models.reference.RStatus RStatus;

	@OneToMany(mappedBy="TReport")
	private List<TTransaction> TTransactions;

}