package com.qcadoo.mes.newview;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractContainerPattern extends AbstractComponentPattern implements ContainerPattern {

    private final Map<String, ComponentPattern> children = new HashMap<String, ComponentPattern>();

    public AbstractContainerPattern(final String name, final String fieldPath, final String sourceFieldPath,
            final ComponentPattern parent) {
        super(name, fieldPath, sourceFieldPath, parent);
    }

    @Override
    public Map<String, ComponentPattern> getChildren() {
        return children;
    }

    @Override
    public ComponentPattern getChild(final String name) {
        return children.get(name);
    }

    @Override
    public void addChild(final ComponentPattern componentPattern) {
        children.put(componentPattern.getName(), componentPattern);
    }

    @Override
    public void initialize(final ViewDefinition viewDefinition) {
        super.initialize(viewDefinition);
        for (ComponentPattern componentPattern : children.values()) {
            componentPattern.initialize(viewDefinition);
        }
    }

    @Override
    public void updateComponentStateListeners(final ViewDefinitionState viewDefinitionState) {
        super.updateComponentStateListeners(viewDefinitionState);
        for (ComponentPattern componentPattern : children.values()) {
            ((AbstractComponentPattern) componentPattern).updateComponentStateListeners(viewDefinitionState);
        }
    }
}
