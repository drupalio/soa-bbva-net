package com.bbva.czic.accounts.business.dto;

import java.util.Date;

import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntFilterAccount {

	@NotNull
	@Size(min = 20, max = 20)
	private String accountId;

	private String month;

	private String startMonth;

	private String endMonth;

	private Date startDate;

	private Date endDate;

	private Date issuedate;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getIssuedate() {
		return issuedate;
	}

	public void setIssuedate(Date issuedate) {
		this.issuedate = issuedate;
	}

	public Date getEndDate() {

		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
