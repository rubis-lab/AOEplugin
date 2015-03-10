package org.eclipse.actor.oriented.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.impl.DefaultRemoveBendpointFeature;

public class RemoveComBendpointFeature extends DefaultRemoveBendpointFeature {
	
	public RemoveComBendpointFeature ( IFeatureProvider fp ) {
		super ( fp );
	}

	@Override
	public boolean canRemoveBendpoint(IRemoveBendpointContext context) {
		return false;
	}
}
