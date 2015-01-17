package com.bbva.czic.accounts.business.dto;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

import java.util.*;

public class DTOIntCheck extends DTOIntFilterAccount implements List<DTOIntCheck> {

	public final static long serialVersionUID = 1L;

	private String id;

	private Date issueDate;

	private Money value;

	private EnumCheckStatus status;

	private Date modifiedDate;

	private int paginationKey;

	public DTOIntCheck() {
		// default constructor
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Money getValue() {
		return value;
	}

	public void setValue(Money value) {
		this.value = value;
	}

	public EnumCheckStatus getStatus() {
		return status;
	}

	public void setStatus(EnumCheckStatus status) {
		this.status = status;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getpaginationKey(){return paginationKey;}

	public void setPaginationKey (String paginationKey1) {this.paginationKey = paginationKey;}



	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<DTOIntCheck> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(DTOIntCheck dtoIntCheck) {
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends DTOIntCheck> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends DTOIntCheck> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {

	}

	@Override
	public DTOIntCheck get(int index) {
		return null;
	}

	@Override
	public DTOIntCheck set(int index, DTOIntCheck element) {
		return null;
	}

	@Override
	public void add(int index, DTOIntCheck element) {

	}

	@Override
	public DTOIntCheck remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<DTOIntCheck> listIterator() {
		return null;
	}

	@Override
	public ListIterator<DTOIntCheck> listIterator(int index) {
		return null;
	}

	@Override
	public List<DTOIntCheck> subList(int fromIndex, int toIndex) {
		return null;
	}
}
