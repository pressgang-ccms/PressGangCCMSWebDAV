package org.jboss.pressgang.ccms.restserver.filter;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import org.jboss.pressgang.ccms.rest.v1.constants.CommonFilterConstants;
import org.jboss.pressgang.ccms.restserver.filter.base.BaseFieldFilter;
import org.jboss.pressgang.ccms.restserver.filter.structures.FilterFieldStringData;


public class PropertyTagCategoryFieldFilter extends BaseFieldFilter
{
    /**
     * A map of the base filter field names that can not have multiple
     *         mappings
     */
    private static final Map<String, String> filterNames = Collections.unmodifiableMap(new HashMap<String, String>()
    {
        private static final long serialVersionUID = 4454656533723964663L;
        
        {
            put(CommonFilterConstants.PROP_CATEGORY_IDS_FILTER_VAR, CommonFilterConstants.PROP_CATEGORY_IDS_FILTER_VAR_DESC);
            put(CommonFilterConstants.PROP_CATEGORY_NAME_FILTER_VAR, CommonFilterConstants.PROP_CATEGORY_NAME_FILTER_VAR_DESC);
            put(CommonFilterConstants.PROP_CATEGORY_DESCRIPTION_FILTER_VAR, CommonFilterConstants.PROP_CATEGORY_DESCRIPTION_FILTER_VAR_DESC);
        }
    });
    
    private FilterFieldStringData propCategoryIds;
    private FilterFieldStringData propCategoryName;
    private FilterFieldStringData propCategoryDescription;
    
    public PropertyTagCategoryFieldFilter()
    {
        resetAllValues();
    }
    
    @Override
    protected void resetAllValues()
    {
        super.resetAllValues();
        
        propCategoryIds = new FilterFieldStringData(CommonFilterConstants.PROP_CATEGORY_IDS_FILTER_VAR, CommonFilterConstants.PROP_CATEGORY_IDS_FILTER_VAR_DESC);
        propCategoryName = new FilterFieldStringData(CommonFilterConstants.PROP_CATEGORY_NAME_FILTER_VAR, CommonFilterConstants.PROP_CATEGORY_NAME_FILTER_VAR_DESC);
        propCategoryDescription = new FilterFieldStringData(CommonFilterConstants.PROP_CATEGORY_DESCRIPTION_FILTER_VAR, CommonFilterConstants.PROP_CATEGORY_DESCRIPTION_FILTER_VAR_DESC);
        
        addFilterVar(propCategoryIds);
        addFilterVar(propCategoryName);
        addFilterVar(propCategoryDescription);
    }

    @Override
    public Map<String, String> getFieldNames()
    {
        final Map<String, String> retValue = super.getFieldNames();
        retValue.putAll(filterNames);
        return retValue;
    }

    @Override
    public Map<String, String> getBaseFieldNames()
    {
        final Map<String, String> retValue = super.getFieldNames();
        retValue.putAll(filterNames);
        return retValue;
    }
}