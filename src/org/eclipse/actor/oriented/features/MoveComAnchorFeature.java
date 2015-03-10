package org.eclipse.actor.oriented.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.impl.DefaultMoveAnchorFeature;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;

public class MoveComAnchorFeature extends DefaultMoveAnchorFeature {
	public MoveComAnchorFeature ( IFeatureProvider fp ) {
		super ( fp );
	}

	@Override
	public boolean canMoveAnchor(IMoveAnchorContext context) {
		boolean ret = super.canMoveAnchor(context);
		if ( context.getAnchor() instanceof BoxRelativeAnchor ) return false;
		else return ret;
	}
}
