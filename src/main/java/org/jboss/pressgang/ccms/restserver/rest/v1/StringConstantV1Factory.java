package org.jboss.pressgang.ccms.restserver.rest.v1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.pressgang.ccms.rest.v1.collections.RESTStringConstantCollectionV1;
import org.jboss.pressgang.ccms.rest.v1.collections.items.RESTStringConstantCollectionItemV1;
import org.jboss.pressgang.ccms.rest.v1.constants.RESTv1Constants;
import org.jboss.pressgang.ccms.rest.v1.entities.RESTStringConstantV1;
import org.jboss.pressgang.ccms.rest.v1.entities.base.RESTBaseEntityV1;
import org.jboss.pressgang.ccms.rest.v1.expansion.ExpandDataTrunk;
import org.jboss.pressgang.ccms.restserver.entity.StringConstants;
import org.jboss.pressgang.ccms.restserver.rest.v1.base.RESTDataObjectCollectionFactory;
import org.jboss.pressgang.ccms.restserver.rest.v1.base.RESTDataObjectFactory;

public class StringConstantV1Factory
        extends
        RESTDataObjectFactory<RESTStringConstantV1, StringConstants, RESTStringConstantCollectionV1, RESTStringConstantCollectionItemV1> {

    public StringConstantV1Factory() {
        super(StringConstants.class);
    }

    @Override
    public RESTStringConstantV1 createRESTEntityFromDBEntity(final StringConstants entity, final String baseUrl,
            final String dataType, final ExpandDataTrunk expand, final Number revision, final boolean expandParentReferences,
            final EntityManager entityManager) {
        assert entity != null : "Parameter topic can not be null";
        assert baseUrl != null : "Parameter baseUrl can not be null";

        final RESTStringConstantV1 retValue = new RESTStringConstantV1();

        final List<String> expandOptions = new ArrayList<String>();
        expandOptions.add(RESTBaseEntityV1.LOG_DETAILS_NAME);
        if (revision == null)
            expandOptions.add(RESTBaseEntityV1.REVISIONS_NAME);
        retValue.setExpand(expandOptions);

        retValue.setId(entity.getStringConstantsId());
        retValue.setName(entity.getConstantName());
        retValue.setValue(entity.getConstantValue());

        // REVISIONS
        if (revision == null) {
            retValue.setRevisions(new RESTDataObjectCollectionFactory<RESTStringConstantV1, StringConstants, RESTStringConstantCollectionV1, RESTStringConstantCollectionItemV1>()
                    .create(RESTStringConstantCollectionV1.class, new StringConstantV1Factory(), entity, entity.getRevisions(entityManager),
                            RESTBaseEntityV1.REVISIONS_NAME, dataType, expand, baseUrl, entityManager));
        }

        retValue.setLinks(baseUrl, RESTv1Constants.STRINGCONSTANT_URL_NAME, dataType, retValue.getId());
        retValue.setLogDetails(new LogDetailsV1Factory().create(entity, revision, RESTBaseEntityV1.LOG_DETAILS_NAME, expand,
                dataType, baseUrl, entityManager));

        return retValue;
    }

    @Override
    public void syncDBEntityWithRESTEntity(final EntityManager entityManager, final StringConstants entity,
            final RESTStringConstantV1 dataObject) {
        if (dataObject.hasParameterSet(RESTStringConstantV1.NAME_NAME))
            entity.setConstantName(dataObject.getName());

        if (dataObject.hasParameterSet(RESTStringConstantV1.VALUE_NAME))
            entity.setConstantValue(dataObject.getValue());

        entityManager.persist(entity);
    }
}