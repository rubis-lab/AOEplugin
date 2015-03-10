package org.eclipse.actor.oriented.features;

import org.eclipse.actor.oriented.Component;
import org.eclipse.actor.oriented.OrientedFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class CreateComponentObjectFeature extends AbstractCreateFeature implements
		ICreateFeature {

	public CreateComponentObjectFeature(IFeatureProvider fp) {
		super(fp, "ComponentObject", "Creates a new ComponentObject");
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		Resource resource = context.getTargetContainer().eResource();
		
		// Create a new component and add it to an EMF resource
		Component component = OrientedFactory.eINSTANCE.createComponent();
		resource.getContents().add( component );

		addGraphicalRepresentation( context, component );
		return new Object[] { component };
	}
}
