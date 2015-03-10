package org.eclipse.actor.oriented.features;

import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.impl.DefaultAddBendpointFeature;

public class AddComBendpointFeature extends DefaultAddBendpointFeature implements IAddBendpointFeature  {
	public AddComBendpointFeature ( IFeatureProvider fp ) {
		super (fp);
	}

	@Override
	public boolean canAddBendpoint(IAddBendpointContext context) {
		return false;
	}

	@Override
	public boolean canExecute(IContext context) {
		return false;
	}
}
