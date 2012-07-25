package org.jboss.pressgangccms.restserver.entities;

// Generated Aug 12, 2011 11:10:16 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Cacheable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;
import org.hibernate.validator.NotNull;

import com.redhat.topicindex.entity.base.AuditedEntity;

/**
 * TopicToTopicSourceUrl generated by hbm2java
 */
@Entity
@Audited
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "TopicToTopicSourceURL", uniqueConstraints = @UniqueConstraint(columnNames = { "TopicID", "TopicSourceURLID" }))
public class TopicToTopicSourceUrl extends AuditedEntity<TopicToTopicSourceUrl> implements java.io.Serializable
{
	private static final long serialVersionUID = -6269439146645434078L;
	private Integer topicToTopicSourceUrlid;
	private TopicSourceUrl topicSourceUrl;
	private Topic topic;

	public TopicToTopicSourceUrl()
	{
		super(TopicToTopicSourceUrl.class);
	}

	public TopicToTopicSourceUrl(final TopicSourceUrl topicSourceUrl, final Topic topic)
	{
		super(TopicToTopicSourceUrl.class);
		this.topicSourceUrl = topicSourceUrl;
		this.topic = topic;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TopicToTopicSourceURLID", unique = true, nullable = false)
	public Integer getTopicToTopicSourceUrlid()
	{
		return this.topicToTopicSourceUrlid;
	}

	public void setTopicToTopicSourceUrlid(final Integer topicToTopicSourceUrlid)
	{
		this.topicToTopicSourceUrlid = topicToTopicSourceUrlid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TopicSourceURLID", nullable = false)
	@NotNull
	public TopicSourceUrl getTopicSourceUrl()
	{
		return this.topicSourceUrl;
	}

	public void setTopicSourceUrl(final TopicSourceUrl topicSourceUrl)
	{
		this.topicSourceUrl = topicSourceUrl;
	}

	@ManyToOne
	@JoinColumn(name = "TopicID", nullable = false)
	@NotNull
	public Topic getTopic()
	{
		return this.topic;
	}

	public void setTopic(final Topic topic)
	{
		this.topic = topic;
	}

	@Override
	@Transient
	public Integer getId()
	{
		return this.topicToTopicSourceUrlid;
	}

}
