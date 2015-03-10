package org.eclipse.actor.oriented.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.services.Graphiti;

public class MoveComShapeFeature extends DefaultMoveShapeFeature {
	public MoveComShapeFeature ( IFeatureProvider fp ) {
		super ( fp );
	}

	@Override
	protected void postMoveShape(IMoveShapeContext context) {
		super.postMoveShape(context);
		
		for ( Anchor anchor : context.getShape().getAnchors() ) {
			if ( anchor instanceof BoxRelativeAnchor ) {
				/* Case of Input port */
				for ( Connection ic : anchor.getIncomingConnections() ) {
					FreeFormConnection ffc = (FreeFormConnection) ic;
					ffc.getBendpoints().clear();
					
					Anchor targetAnchor = ic.getStart();
					/* Add bendpoints for making manhattan style */
					int x = ( anchor.getParent().getGraphicsAlgorithm().getX() + targetAnchor.getParent().getGraphicsAlgorithm().getX() ) / 2;
					x += anchor.getParent().getGraphicsAlgorithm().getWidth() / 2;
					int y1 = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( anchor ).getY();
					int y2 = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( targetAnchor ).getY();
					Point bendpoint = Graphiti.getCreateService().createPoint( x, y2 );
					ffc.getBendpoints().add( bendpoint );
					bendpoint = Graphiti.getCreateService().createPoint( x, y1 );
					ffc.getBendpoints().add( bendpoint );
				}
				
				/* Case of Output port */
				for ( Connection oc : anchor.getOutgoingConnections() ) {
					FreeFormConnection ffc = (FreeFormConnection) oc;
					ffc.getBendpoints().clear();
					
					Anchor targetAnchor = oc.getEnd();
					/* Add bendpoints for making manhattan style */
					int x = ( anchor.getParent().getGraphicsAlgorithm().getX() + targetAnchor.getParent().getGraphicsAlgorithm().getX() ) / 2;
					x += anchor.getParent().getGraphicsAlgorithm().getWidth() / 2;
					int y1 = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( anchor ).getY();
					int y2 = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( targetAnchor ).getY();
					Point bendpoint = Graphiti.getCreateService().createPoint( x, y1 );
					ffc.getBendpoints().add( bendpoint );
					bendpoint = Graphiti.getCreateService().createPoint( x, y2 );
					ffc.getBendpoints().add( bendpoint );
				}
			}
		}
	}
	
	
}
