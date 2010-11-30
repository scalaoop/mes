/**
 * ********************************************************************
 * Code developed by amazing QCADOO developers team.
 * Copyright (c) Qcadoo Limited sp. z o.o. (2010)
 * ********************************************************************
 */

package com.qcadoo.mes.model;

import java.util.Locale;

import com.qcadoo.mes.api.Entity;
import com.qcadoo.mes.newview.ViewDefinitionState;

/**
 * Defines hooks for validation/saving entities and generating views.
 */
public interface HookDefinition {

    /**
     * Validate field using custom hook.
     * 
     * @param dataDefinition
     *            data definition
     * @param value
     *            field value
     * @return is field valid
     */
    boolean callWithObjectAndGetBoolean(final DataDefinition dataDefinition, final Object value);

    /**
     * Validate entity using custom hook.
     * 
     * @param dataDefinition
     *            data definition
     * @param entity
     *            entity
     * @return is entity valid
     */
    boolean callWithEntityAndGetBoolean(final DataDefinition dataDefinition, final Entity entity);

    /**
     * Call custom hook on entity.
     * 
     * @param dataDefinition
     *            data definition
     * @param entity
     *            entity
     */
    void callWithEntity(final DataDefinition dataDefinition, final Entity entity);

    /**
     * Call custom hook on view.
     * 
     * @param value
     *            view value
     * @param triggerComponentName
     *            component which trigger this hook
     * @param locale
     *            locale
     */
    void callWithViewState(ViewDefinitionState viewDefinitionState, final Locale locale);

}
