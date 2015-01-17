package com.bbva.czic.accounts.business.dto;

import java.util.Date;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntFilterAccount {

	private String accountId;

	private String month;

	private Date startMonth;

	private Date endMonth;

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

	public Date getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(Date startMonth) {
		this.startMonth = startMonth;
	}

	public Date getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(Date endMonth) {
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
