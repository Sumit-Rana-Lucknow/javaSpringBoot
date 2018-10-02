package com.opt.springboot.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

//@MappedSuperclass
@Embeddable
public class BaseEntity {

	public static final int BASE_PAGE_SIZE = 10;
	public static final int MAX_PAGE_SIZE = 500;

	public static ThreadLocal<Long> currentUserId = new ThreadLocal<Long>();
	private static final long serialVersionUID = 1L;

	private Calendar creationDate;
	private Calendar updationDate;
	private Long createdUserId;
	private Long updatedUserId;
	private long version;

	/**
	 * @return the creationDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(insertable = true, updatable = false)
	public Calendar getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the updationDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getUpdationDate() {
		return updationDate;
	}

	/**
	 * @param updationDate
	 *            the updationDate to set
	 */
	public void setUpdationDate(Calendar updationDate) {
		this.updationDate = updationDate;
	}

	/**
	 * @return the createdUserId
	 */
	@Column(insertable = true, updatable = false)
	public Long getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * @param createdUserId
	 *            the createdUserId to set
	 */
	public void setCreatedUserId(Long createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * @return the updatedUserId
	 */
	public Long getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * @param updatedUserId
	 *            the updatedUserId to set
	 */
	public void setUpdatedUserId(Long updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * @return the version
	 */
	@Version
	public long getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(long version) {
		this.version = version;
	}

	@PrePersist
	public void createAuditInfo() {
		setCreatedUserId((Long) BaseEntity.currentUserId.get());
		setCreationDate(Calendar.getInstance());
	}

	@PreUpdate
	public void updateAuditInfo() {
		setUpdatedUserId((Long) BaseEntity.currentUserId.get());
		setUpdationDate(Calendar.getInstance());
	}


}
