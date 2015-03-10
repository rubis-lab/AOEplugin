package org.eclipse.actor.oriented.features;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.impl.DefaultMoveBendpointFeature;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.services.Graphiti;

public class MoveComBendpointFeature extends DefaultMoveBendpointFeature {
	int previous_x;
	int previous_y;
	
	public MoveComBendpointFeature ( IFeatureProvider fp ) {
		super ( fp );
	}

	@Override
	public boolean moveBendpoint(IMoveBendpointContext context) {
		boolean ret = super.moveBendpoint(context);
		
		// Maintain orthogonal
		if ( previous_x != context.getX() ) {
			for ( Point bp : context.getConnection().getBendpoints() ) {
				if ( bp.getX() == previous_x ) bp.setX( context.getX() ); 
			}
		}
		if ( previous_y != context.getY() ) {
			for ( Point bp : context.getConnection().getBendpoints() ) {
				if ( bp.getY() == previous_y ) bp.setY( context.getY() ); 
			}
		}
		
		Anchor leftAnchor = context.getConnection().getStart();
		int lX = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( leftAnchor ).getX();
		int lY = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( leftAnchor ).getY();
		Anchor rightAnchor = context.getConnection().getEnd();
		int rX = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( rightAnchor ).getX();
		int rY = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( rightAnchor ).getY();
		
		if ( lX > rX ) {
			swap ( leftAnchor, rightAnchor );
			swap ( lX, rX );
			swap ( lY, rY );
		}
		
		if ( previous_y != context.getY() && context.getConnection().getBendpoints().size() < 3 ) {
			if ( context.getBendpointIndex() == 0 ) {
				Point bendpoint = Graphiti.getCreateService().createPoint( lX + 10, context.getY() );
				context.getConnection().getBendpoints().add( 0, bendpoint );
				bendpoint = Graphiti.getCreateService().createPoint( lX + 10, lY );
				context.getConnection().getBendpoints().add( 0, bendpoint );
			} else {
				Point bendpoint = Graphiti.getCreateService().createPoint( rX - 20, context.getY() );
				context.getConnection().getBendpoints().add( bendpoint );
				bendpoint = Graphiti.getCreateService().createPoint( rX - 20, rY );
				context.getConnection().getBendpoints().add( bendpoint );
			}
		} else if ( context.getConnection().getBendpoints().size() > 3 ) {
			if (Math.abs(context.getY() - lY) <= 10 && context.getBendpointIndex() == 2) {
				context.getConnection().getBendpoints().remove(1);
				context.getConnection().getBendpoints().remove(0);
				context.getConnection().getBendpoints().get(0).setY(lY);
			} else if (Math.abs(context.getY() - rY) <= 10 && context.getBendpointIndex() == 1 ) {
				context.getConnection().getBendpoints().remove(3);
				context.getConnection().getBendpoints().remove(2);
				context.getConnection().getBendpoints().get(1).setY(rY);
			}
		}
		
		return ret;
	}

	@Override
	public boolean canMoveBendpoint(IMoveBendpointContext context) {
		previous_x = context.getBendpoint().getX();
		previous_y = context.getBendpoint().getY();
		return super.canMoveBendpoint(context);
	}

	private void swap ( Object a, Object b ) {
		Object tmp;
		tmp = a;
		a = b;
		b = tmp;
	}
}
