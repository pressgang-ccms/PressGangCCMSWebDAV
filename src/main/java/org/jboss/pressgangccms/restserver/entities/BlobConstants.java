package org.jboss.pressgangccms.restserver.entities;

// Generated Jul 14, 2011 1:47:13 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;
import org.jboss.pressgangccms.restserver.entities.base.AuditedEntity;

/**
 * BlobConstants generated by hbm2java
 */
@Audited
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "BlobConstants")
public class BlobConstants extends AuditedEntity<BlobConstants> implements java.io.Serializable
{
	private static final long serialVersionUID = 2142789116413087991L;
	private Integer blobConstantsId;
	private String constantName;
	private byte[] constantValue;

	public BlobConstants()
	{
		super(BlobConstants.class);
	}

	public BlobConstants(final String constantName)
	{
		super(BlobConstants.class);
		this.constantName = constantName;
	}

	public BlobConstants(final String constantName, final byte[] constantValue)
	{
		super(BlobConstants.class);
		this.constantName = constantName;
		this.constantValue = constantValue;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BlobConstantsID", unique = true, nullable = false)
	public Integer getBlobConstantsId()
	{
		return this.blobConstantsId;
	}

	public void setBlobConstantsId(final Integer blobConstantsId)
	{
		this.blobConstantsId = blobConstantsId;
	}

	@Column(name = "ConstantName", nullable = false, length = 45)
	@NotNull
	@Size(max = 45)
	public String getConstantName()
	{
		return this.constantName;
	}

	public void setConstantName(final String constantName)
	{
		this.constantName = constantName;
	}

	@Column(name = "ConstantValue")
	public byte[] getConstantValue()
	{
		return this.constantValue;
	}

	public void setConstantValue(final byte[] constantValue)
	{
		this.constantValue = constantValue;
	}

	@Override
	@Transient
	public Integer getId()
	{
		return this.blobConstantsId;
	}

}
