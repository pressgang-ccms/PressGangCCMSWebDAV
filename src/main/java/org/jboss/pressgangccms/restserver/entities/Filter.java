package org.jboss.pressgangccms.restserver.entities;

// Generated Apr 14, 2011 12:17:30 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import static ch.lambdaj.Lambda.filter;
import static ch.lambdaj.Lambda.having;
import static ch.lambdaj.Lambda.on;
import static javax.persistence.GenerationType.IDENTITY;
import static org.hamcrest.Matchers.equalTo;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.Audited;
import org.jboss.pressgangccms.docbook.compiling.DocbookBuildingOptions;
import org.jboss.pressgangccms.restserver.constants.Constants;
import org.jboss.pressgangccms.restserver.entities.base.AuditedEntity;
import org.jboss.pressgangccms.restserver.filter.FilterQueryBuilder;
import org.jboss.pressgangccms.restserver.filter.TopicFilter;
import org.jboss.pressgangccms.utils.common.CollectionUtilities;

/**
 * Filter generated by hbm2java
 */
@Entity
@Audited
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Table(name = "Filter", uniqueConstraints = @UniqueConstraint(columnNames = { "FilterName" }))
public class Filter extends AuditedEntity<Filter> implements java.io.Serializable
{
	@PersistenceContext(unitName="Topic") EntityManager entityManager;
	
	public static final String SELECT_ALL_QUERY = "select filter from Filter filter";
	/** Serializable version identifier */
	private static final long serialVersionUID = 1378015715100292871L;
	private Integer filterId;
	private String filterName;
	private String filterDescription;
	private Set<FilterTag> filterTags = new HashSet<FilterTag>(0);
	private Set<FilterCategory> filterCategories = new HashSet<FilterCategory>(0);
	private Set<FilterField> filterFields = new HashSet<FilterField>(0);
	private Set<FilterOption> filterOptions = new HashSet<FilterOption>(0);
	private Set<FilterLocale> filterLocales = new HashSet<FilterLocale>(0);

	public Filter()
	{
		super(Filter.class);
	}

	public Filter(final String filterName)
	{
		super(Filter.class);
		this.filterName = filterName;
	}

	public Filter(final String filterName, final String filterDescription, final Set<FilterTag> filterTags, final Set<FilterCategory> filterCategories)
	{
		super(Filter.class);
		this.filterName = filterName;
		this.filterDescription = filterDescription;
		this.filterTags = filterTags;
		this.filterCategories = filterCategories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FilterID", unique = true, nullable = false)
	public Integer getFilterId()
	{
		return this.filterId;
	}

	public void setFilterId(Integer filterId)
	{
		this.filterId = filterId;
	}

	@Column(name = "FilterName", nullable = false, length = 512)
	@NotNull
	@Size(max = 512)
	public String getFilterName()
	{
		return this.filterName;
	}

	public void setFilterName(final String filterName)
	{
		this.filterName = filterName;
	}

	// @Column(name = "FilterDescription", length = 65535)
	@Column(name = "FilterDescription", columnDefinition = "TEXT")
	@Size(max = 65535)
	public String getFilterDescription()
	{
		return this.filterDescription;
	}

	public void setFilterDescription(final String filterDescription)
	{
		this.filterDescription = filterDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filter", orphanRemoval = true, cascade = CascadeType.ALL)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@BatchSize(size = Constants.DEFAULT_BATCH_SIZE)
	public Set<FilterTag> getFilterTags()
	{
		return this.filterTags;
	}

	public void setFilterTags(final Set<FilterTag> filterTags)
	{
		this.filterTags = filterTags;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filter", orphanRemoval = true, cascade = CascadeType.ALL)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@BatchSize(size = Constants.DEFAULT_BATCH_SIZE)
	public Set<FilterCategory> getFilterCategories()
	{
		return this.filterCategories;
	}

	public void setFilterCategories(final Set<FilterCategory> filterCategories)
	{
		this.filterCategories = filterCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filter", orphanRemoval = true, cascade = CascadeType.ALL)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@BatchSize(size = Constants.DEFAULT_BATCH_SIZE)
	public Set<FilterField> getFilterFields()
	{
		return filterFields;
	}

	public void setFilterFields(final Set<FilterField> filterFields)
	{
		this.filterFields = filterFields;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filter", orphanRemoval = true, cascade = CascadeType.ALL)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@BatchSize(size = Constants.DEFAULT_BATCH_SIZE)
	public Set<FilterOption> getFilterOptions()
	{
		return filterOptions;
	}

	public void setFilterOptions(final Set<FilterOption> filterOptions)
	{
		this.filterOptions = filterOptions;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filter", orphanRemoval = true, cascade = CascadeType.ALL)
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	@BatchSize(size = Constants.DEFAULT_BATCH_SIZE)
	public Set<FilterLocale> getFilterLocales()
	{
		return filterLocales;
	}

	public void setFilterLocales(final Set<FilterLocale> filterLocales)
	{
		this.filterLocales = filterLocales;
	}

	/**
	 * Loops through the FilterTags held by this Filter, and returns the state
	 * of the tag if it exists, and -1 if it does not.
	 * 
	 * @param tagID
	 *            The id of the tag to get the state of
	 * @return -1 if the tag was not found, otherwise the state of the tag
	 */
	public List<Integer> hasTag(final Integer tagID)
	{
		final List<Integer> retValue = new ArrayList<Integer>();

		for (final FilterTag tag : this.getFilterTags())
		{
			if (tag.getTag().getTagId().equals(tagID))
				retValue.add(tag.getTagState());
		}

		return retValue;
	}

	public ArrayList<Integer> hasCategory(final Integer categoryId)
	{
		ArrayList<Integer> states = new ArrayList<Integer>();

		for (final FilterCategory cat : this.getFilterCategories())
		{
			if (cat.getCategory().getCategoryId().equals(categoryId))
				states.add(cat.getCategoryState());
		}

		return states;
	}
	
	public ArrayList<Integer> hasLocale(final String localeName)
	{
		ArrayList<Integer> states = new ArrayList<Integer>();

		for (final FilterLocale locale : this.getFilterLocales())
		{
			if (locale.getLocaleName().equals(localeName))
				states.add(locale.getLocaleState());
		}

		return states;
	}

	/**
	 * Not all FilterTags assigned to a filter have an associated
	 * FilterCategory. If a FilterTags belongs to a category that does not have
	 * an associated FilterCategory, the default boolean logic is used.
	 * 
	 * This function returns all the categories that the tags in this filter
	 * belong to. These are then matched to any associated FilterCategorys to
	 * find out how the tags are matched (i.e. are we matching all the tags
	 * ("And" logic), or one or more of the tags matches ("Or" logic)), using
	 * the default logic ("Or") if no associated FilterCategory exists.
	 * 
	 * @return An ArrayList containing the Category IDs that the tags in this
	 *         filter belong to
	 */
	@Transient
	public ArrayList<Category> getFilterTagCategories()
	{
		final ArrayList<Category> categories = new ArrayList<Category>();

		for (final FilterTag filterTag : this.filterTags)
		{
			final int filterTagState = filterTag.getTagState();

			if (filterTagState == Constants.MATCH_TAG_STATE || filterTagState == Constants.NOT_MATCH_TAG_STATE)
			{
				final Tag tag = filterTag.getTag();

				for (final TagToCategory category : tag.getTagToCategories())
				{
					if (!categories.contains(category.getCategory()))
					{
						categories.add(category.getCategory());
					}
				}
			}
		}

		return categories;
	}

	@Transient
	public ArrayList<Project> getFilterTagProjects()
	{
		final ArrayList<Project> projects = new ArrayList<Project>();

		for (final FilterTag filterTag : this.filterTags)
		{
			final Tag tag = filterTag.getTag();
			final Set<TagToProject> tagToProjects = tag.getTagToProjects();

			if (tagToProjects.size() != 0)
			{
				for (final TagToProject tagToProject : tagToProjects)
				{
					final Project project = tagToProject.getProject();

					if (!projects.contains(project))
						projects.add(project);
				}
			}
			else
			{
				if (!projects.contains(null))
					projects.add(null);
			}
		}

		return projects;
	}

	@Transient
	public String getFilterTitle()
	{
		String desc = "";

		/* Loop over all the categories that the filter tags belong to */
		for (final Category category : this.getFilterTagCategories())
		{
			String categoryDesc = "[" + category.getCategoryName() + "] ";
			String tagDesc = "";

			/* This will be shown in the topic list results title */
			String internalLogic = Constants.DEFAULT_INTERNAL_LOGIC;

			/* Find out if the category does not have the default internal logic */
			final Set<FilterCategory> filterCategories = this.getFilterCategories();
			for (final FilterCategory filterCategory : filterCategories)
			{
				/*
				 * if a filter category has been saved that matches the category
				 * we are looking at now..
				 */
				if (filterCategory.getCategory().equals(category))
				{
					/*
					 * ...and it defines an internal logic state, update the
					 * internalLogic variable
					 */
					if (filterCategory.getCategoryState() == Constants.CATEGORY_INTERNAL_AND_STATE)
						internalLogic = Constants.AND_LOGIC;
					else if (filterCategory.getCategoryState() == Constants.CATEGORY_INTERNAL_OR_STATE)
						internalLogic = Constants.OR_LOGIC;
					break;
				}
			}

			for (final FilterTag tag : this.filterTags)
			{
				final int tagState = tag.getTagState();

				if (tagState == Constants.MATCH_TAG_STATE || tagState == Constants.NOT_MATCH_TAG_STATE)
				{
					if (tag.getTag().isInCategory(category.getCategoryId()))
					{
						if (tagDesc.length() != 0)
							tagDesc += " " + internalLogic + " ";

						if (tagState == Constants.NOT_MATCH_TAG_STATE)
							tagDesc += "Not ";

						tagDesc += tag.getTag().getTagName();
					}
				}
			}

			if (desc.length() != 0)
				desc += " ";

			desc += categoryDesc + tagDesc;
		}
		
		if (this.getFilterLocales().size() != 0)
		{
			String andLocaleDesc = "";
			String orLocaleDesc = "";
			for (final FilterLocale locale : this.filterLocales)
			{
				final int localeState = locale.getLocaleState();
	
				if (localeState == Constants.MATCH_TAG_STATE)
				{
					if (orLocaleDesc.length() != 0)
						orLocaleDesc += " OR ";
	
					orLocaleDesc += locale.getLocaleName();
				}
				else if (localeState == Constants.NOT_MATCH_TAG_STATE)
				{
					if (andLocaleDesc.length() != 0)
						andLocaleDesc += " AND ";

					andLocaleDesc += "Not " + locale.getLocaleName();
				}
			}
			
			if (orLocaleDesc.length() != 0 || andLocaleDesc.length() != 0)
			{
				String combinedDesc = "";
				
				combinedDesc += orLocaleDesc;
				
				if (combinedDesc.length() != 0  && andLocaleDesc.length() != 0)
					combinedDesc += " AND ";
				
				combinedDesc += andLocaleDesc;
				
				if (desc.length() != 0)
					desc += " ";
				desc += "[Locale] " + combinedDesc;
				
			}
		}

		if (this.getFilterFields().size() != 0)
		{
			String searchFilters = "";

			for (final FilterField filterField : this.getFilterFields())
			{
				if (searchFilters.length() != 0)
					searchFilters += ", ";
				searchFilters += " " + filterField.getDescription() + " = " + filterField.getValue();
			}

			if (desc.length() != 0)
				desc += " ";

			desc += "[Search Filters]" + searchFilters;
		}

		String groupBy = "";

		for (final FilterTag tag : this.filterTags)
		{
			final int tagState = tag.getTagState();

			if (tagState == Constants.GROUP_TAG_STATE)
			{
				if (groupBy.length() != 0)
					groupBy += ", ";

				groupBy += tag.getTag().getTagName();
			}
		}

		if (groupBy.length() != 0)
			desc += " [Group By] " + groupBy;

		return desc;
	}

	/**
	 * Translate the contents of this filter, its tags and categories into
	 * variables that can be appended to a url
	 * 
	 * @return
	 */
	@Transient
	public HashMap<String, String> getUrlVariables()
	{
		final HashMap<String, String> vars = new HashMap<String, String>();

		for (final FilterTag filterTag : this.filterTags)
		{
			final Tag tag = filterTag.getTag();
			final Integer tagState = filterTag.getTagState();

			if (tagState == Constants.MATCH_TAG_STATE)
			{
				vars.put(Constants.MATCH_TAG + tag.getTagId(), Constants.MATCH_TAG_STATE + "");
			}
			else if (tagState == Constants.NOT_MATCH_TAG_STATE)
			{
				vars.put(Constants.MATCH_TAG + tag.getTagId(), Constants.NOT_MATCH_TAG_STATE + "");
			}
			else if (tagState == Constants.GROUP_TAG_STATE)
			{
				vars.put(Constants.GROUP_TAG + tag.getTagId(), Constants.GROUP_TAG_STATE + "");
			}
		}

		for (final FilterCategory filterCategory : this.filterCategories)
		{
			final Category category = filterCategory.getCategory();
			final Project project = filterCategory.getProject();

			if (filterCategory.getCategoryState() == Constants.CATEGORY_INTERNAL_AND_STATE)
			{
				vars.put(Constants.CATEORY_INTERNAL_LOGIC + category.getCategoryId() + (project == null ? "" : "-" + project.getProjectId()), Constants.AND_LOGIC);
			}

			// don't add a url var for the "or" internal logic, as this is the
			// default

			else if (filterCategory.getCategoryState() == Constants.CATEGORY_EXTERNAL_OR_STATE)
			{
				vars.put(Constants.CATEORY_EXTERNAL_LOGIC + category.getCategoryId() + (project == null ? "" : "-" + project.getProjectId()), Constants.OR_LOGIC);
			}

			// don't add a url var for the "and" external logic, as this is the
			// default
		}

		int count = 1;
		for (final FilterLocale filterLocale : this.filterLocales)
		{
			final Integer localeState = filterLocale.getLocaleState();

			if (localeState == Constants.MATCH_TAG_STATE)
			{
				vars.put(Constants.MATCH_LOCALE + count, filterLocale.getLocaleName() + Constants.MATCH_TAG_STATE);
			}
			else if (localeState == Constants.NOT_MATCH_TAG_STATE)
			{
				vars.put(Constants.MATCH_LOCALE + count, filterLocale.getLocaleName() + Constants.NOT_MATCH_TAG_STATE);
			}
			count++;
		}

		boolean foundFilterField = false;
		boolean foundFilterFieldLogic = false;
		for (final FilterField filterField : this.getFilterFields())
		{
			vars.put(filterField.getField(), filterField.getValue());
			if (!filterField.getField().equals(Constants.TOPIC_LOGIC_FILTER_VAR))
				foundFilterField = true;
			else
				foundFilterFieldLogic = true;
		}

		/*
		 * if we have found some filter fields, but did not find the filter
		 * logic, use the default value
		 */
		if (foundFilterField && !foundFilterFieldLogic)
			vars.put(Constants.TOPIC_LOGIC_FILTER_VAR, Constants.TOPIC_LOGIC_FILTER_VAR_DEFAULT_VALUE);

		return vars;
	}

	public String buildFilterUrlVars()
	{
		final HashMap<String, String> vars = this.getUrlVariables();
		String urlVars = "";

		for (final String urlVarKey : vars.keySet())
		{
			if (urlVars.length() != 0)
				urlVars += "&";
			urlVars += urlVarKey + "=" + vars.get(urlVarKey);
		}

		return urlVars;
	}

	/**
	 * 
	 * @return A string that can be supplied to the PathSegment used by the REST
	 *         interface to do queries
	 */
	public String buildRESTQueryString()
	{
		final HashMap<String, String> vars = this.getUrlVariables();
		StringBuffer urlVars = new StringBuffer("query");

		for (final String urlVarKey : vars.keySet())
		{
			if (urlVars.length() != 0)
				urlVars.append(";");
			urlVars.append(urlVarKey + "=" + vars.get(urlVarKey));
		}

		return urlVars.toString();
	}

	/**
	 * This function is used to create the HQL query where clause that is
	 * appended to the generic EJBQL (as created in default EntityList objects)
	 * select statement. It takes the request parameters to get the tags that
	 * are to be included in the clause, groups them by category, and then take
	 * additional request parameters to define the boolean operations to use
	 * between tags in a category, and between categories.
	 * 
	 * @return the clause to append to the EJBQL select statement
	 */
	public String buildQuery(final FilterQueryBuilder filterQueryBuilder)
	{
		if (filterQueryBuilder == null)
			return null;

		// the categories to be ANDed will be added to this string
		String andQueryBlock = "";
		// the categories to be ORed will be added to this string
		String orQueryBlock = "";

		// loop over the projects that the tags in this filter are assigned to
		for (final Project project : this.getFilterTagProjects())
		{
			// loop over the categories that the tags in this filter are
			// assigned to
			for (final Category category : this.getFilterTagCategories())
			{
				// define the default logic used for the FilterTag categories
				String catInternalLogic = Constants.OR_LOGIC;
				String catExternalLogic = Constants.AND_LOGIC;

				/*
				 * Now loop over the FilterCategories, looking for any
				 * categories that specify a particular boolean logic to apply.
				 * Remember that not all FilterTags will have an associated
				 * FilterCategory that specifies the logic to use, in which case
				 * the default logic defined above will be used.
				 */
				final Set<FilterCategory> filterCatgeories = this.getFilterCategories();
				for (final FilterCategory filterCatgeory : filterCatgeories)
				{
					final boolean categoryMatch = category.equals(filterCatgeory.getCategory());
					/*
					 * project or filterCatgeory.getProject() might be null.
					 * CollectionUtilities.isEqual deals with this situation
					 */
					final boolean projectMatch = CollectionUtilities.isEqual(project, filterCatgeory.getProject());

					if (categoryMatch && projectMatch)
					{
						final int categoryState = filterCatgeory.getCategoryState();

						if (categoryState == Constants.CATEGORY_INTERNAL_AND_STATE)
							catInternalLogic = Constants.AND_LOGIC;
						else if (categoryState == Constants.CATEGORY_INTERNAL_OR_STATE)
							catInternalLogic = Constants.OR_LOGIC;
						else if (categoryState == Constants.CATEGORY_EXTERNAL_AND_STATE)
							catExternalLogic = Constants.AND_LOGIC;
						else if (categoryState == Constants.CATEGORY_EXTERNAL_OR_STATE)
							catExternalLogic = Constants.OR_LOGIC;
					}
				}

				/*
				 * now build up the HQL that checks to see if the FilterTags
				 * exist (or not) in this category
				 */
				String categoryBlock = "";

				boolean matchedSomeTags = false;

				final Set<FilterTag> filterTags = this.getFilterTags();
				for (final FilterTag filterTag : filterTags)
				{
					final Tag tag = filterTag.getTag();

					/*
					 * first check to make sure that the FilterTag is actually
					 * associated with the category we are looking at now
					 */
					if (tag.isInCategory(category) && tag.isInProject(project))
					{
						/*
						 * a FilterTag state of 1 "means exists in category",
						 * and 0 means "does not exist in category"
						 */
						final boolean matchTag = filterTag.getTagState() == Constants.MATCH_TAG_STATE;
						final boolean notMatchTag = filterTag.getTagState() == Constants.NOT_MATCH_TAG_STATE;

						if (matchTag || notMatchTag)
						{
							matchedSomeTags = true;

							if (categoryBlock.length() != 0)
								categoryBlock += " " + catInternalLogic + " ";

							if (matchTag)
							{
								/* match the tag in this category */
								categoryBlock += filterQueryBuilder.getMatchTagString(tag.getTagId());
							}
							else if (notMatchTag)
							{
								/*
								 * make sure this tag does not exist in this
								 * category
								 */
								categoryBlock += filterQueryBuilder.getNotMatchTagString(tag.getTagId());
							}
						}
					}
				}

				if (matchedSomeTags)
				{
					categoryBlock = "(" + categoryBlock + ")";

					// append this clause to the appropriate block
					if (catExternalLogic.equals(Constants.AND_LOGIC))
					{
						if (andQueryBlock.length() != 0)
							andQueryBlock += " " + Constants.AND_LOGIC + " ";

						andQueryBlock += categoryBlock;
					}
					else
					{
						if (orQueryBlock.length() != 0)
							orQueryBlock += " " + Constants.OR_LOGIC + " ";

						orQueryBlock += categoryBlock;
					}
				}

			}
		}

		/*
		 * Do an initial loop over the FilterFields, looking for the field logic
		 * value
		 */
		for (final FilterField filterField : this.getFilterFields())
			filterQueryBuilder.processFilterString(filterField.getField(), filterField.getValue());

		/*
		 * Loop over the locales and add the query
		 */
		String orLocaleBlock = "";
		String andLocaleBlock = "";
		for (final FilterLocale filterLocale : this.filterLocales)
		{
			if (filterLocale.getLocaleState() == Constants.MATCH_TAG_STATE)
			{
				if (orLocaleBlock.length() != 0)
					orLocaleBlock += " OR ";
				orLocaleBlock += filterQueryBuilder.getMatchingLocalString(filterLocale.getLocaleName());
			}
			else if (filterLocale.getLocaleState() == Constants.NOT_MATCH_TAG_STATE)
			{
				if (andLocaleBlock.length() != 0)
					andLocaleBlock += " OR ";
				andLocaleBlock += filterQueryBuilder.getNotMatchingLocalString(filterLocale.getLocaleName());
			}
		}
		
		if (orLocaleBlock.length() != 0 || andLocaleBlock.length() != 0)
		{
			String localeBlock = "";
			
			if (orLocaleBlock.length() != 0)
				localeBlock += "(" + orLocaleBlock + ")";
			
			if (localeBlock.length() != 0 && andLocaleBlock.length() != 0)
				localeBlock += " " + Constants.AND_LOGIC + " ";
			
			localeBlock += andLocaleBlock;
			
			if (andQueryBlock.length() != 0)
				andQueryBlock += " " + Constants.AND_LOGIC + " ";
			andQueryBlock += "(" + localeBlock + ")";
		}
		
		final StringBuilder query = new StringBuilder();
		;

		/*
		 * build up the category query if some conditions were specified if not,
		 * we will just return an empty string
		 */
		if (andQueryBlock.length() != 0 || orQueryBlock.length() != 0)
		{
			// add the and categories
			if (!andQueryBlock.isEmpty())
				query.append("(" + andQueryBlock + ")");

			// add the or categories
			if (!orQueryBlock.isEmpty())
				query.append((query.length() != 0 ? " OR " : "") + "(" + orQueryBlock + ")");
		}

		final String fieldQuery = filterQueryBuilder.getFilterString();
		if (!fieldQuery.isEmpty())
		{
			/*
			 * The field conditions are AND'ed to the tag conditions, if any tag
			 * conditions exist
			 */
			if (query.length() != 0)
			{
				query.insert(0, "(");
				query.append(") AND ");
			}

			query.append("(" + fieldQuery + ")");
		}

		/*
		 * add the where clause have to join the topic and its collection of
		 * tags in order for the filter to work
		 */
		if (query.length() != 0)
			query.insert(0, " WHERE ");

		final String retValue = filterQueryBuilder.getSelectAllQuery() + query;
				
		return retValue;

	}

	public void syncFilterWithFieldUIElements(final TopicFilter topic)
	{
		for (final String fieldName : TopicFilter.getBaseFilterNames().keySet())
		{
			final String singleFieldValue = topic.getFieldValue(fieldName);
			if (singleFieldValue != null)
			{
				syncFilterField(fieldName, topic.getFieldValue(fieldName), TopicFilter.getFilterDesc(fieldName));
			}
			else
			{
				int i = 1;
				String multiFieldValue = null;
				while ((multiFieldValue = topic.getFieldValue(fieldName + i)) != null)
				{
					if (!multiFieldValue.trim().isEmpty())
						syncFilterField(fieldName + i, multiFieldValue, TopicFilter.getFilterDesc(fieldName + i));
				}
			}
		}
	}

	private void syncFilterField(final String fieldName, final String fieldValue, final String fieldDescription)
	{
		// get the database filterfield object that matches the fieldName
		final List<FilterField> filterField = filter(having(on(FilterField.class).getField(), equalTo(fieldName)), this.getFilterFields());

		/*
		 * if fieldValue is set to a value, we need to modify or add a
		 * FilterField entity
		 */
		if (fieldValue != null && fieldValue.trim().length() != 0)
		{
			final String fixedFieldValue = fieldValue.trim();

			FilterField newField = null;

			// add a new FilterField entity
			if (filterField.size() == 0)
			{
				newField = new FilterField();
				newField.setFilter(this);
				newField.setField(fieldName);
				newField.setValue(fixedFieldValue);
				newField.setDescription(fieldDescription);
				this.getFilterFields().add(newField);
			}
			// update a FilterField entity
			else if (filterField.size() == 1)
			{
				newField = filterField.get(0);
				newField.setValue(fixedFieldValue);
				newField.setDescription(fieldDescription);
			}
		}
		else
		{
			// remove the FilterField entity
			if (filterField.size() == 1)
				this.getFilterFields().remove(filterField.get(0));
		}
	}

	public void syncWithDocbookOptions(final DocbookBuildingOptions options)
	{
		final List<String> docbookOptions = DocbookBuildingOptions.getOptionNames();
		for (final String option : docbookOptions)
		{
			boolean found = false;
			for (final FilterOption filterOption : this.filterOptions)
			{
				if (filterOption.getFilterOptionName().equals(option))
				{
					found = true;
					filterOption.setFilterOptionValue(options.getFieldValue(option));
				}
			}

			if (!found)
			{
				final FilterOption filterOption = new FilterOption();
				filterOption.setFilter(this);
				filterOption.setFilterOptionName(option);
				filterOption.setFilterOptionValue(options.getFieldValue(option));
				this.filterOptions.add(filterOption);
			}
		}

	}

	public DocbookBuildingOptions createDocbookOptionsFilter()
	{
		final DocbookBuildingOptions options = new DocbookBuildingOptions();
		for (final FilterOption option : this.getFilterOptions())
			options.setFieldValue(option.getFilterOptionName(), option.getFilterOptionValue());
		return options;
	}

	public void updateDocbookOptionsFilter(final DocbookBuildingOptions options)
	{
		for (final FilterOption option : this.getFilterOptions())
			options.setFieldValue(option.getFilterOptionName(), option.getFilterOptionValue());
	}

	@Override
	@Transient
	public Integer getId()
	{
		return this.filterId;
	}

}
