package org.eclipse.actor.oriented.features;

import org.eclipse.actor.oriented.StyleUtil;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.GraphicsAlgorithmContainer;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;

public class AddComponentConnectionFeature extends AbstractAddFeature implements
		IAddFeature {

	public AddComponentConnectionFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return context instanceof IAddConnectionContext && context.getNewObject() instanceof EReference;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		IAddConnectionContext addConContext = (IAddConnectionContext) context;
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();
		
		// Connection connection = peCreateService.createManhattanConnection(getDiagram());
		FreeFormConnection connection = peCreateService.createFreeFormConnection(getDiagram());
		Anchor sourceAnchor = addConContext.getSourceAnchor();
		Anchor targetAnchor = addConContext.getTargetAnchor();
		connection.setStart( sourceAnchor );
		connection.setEnd( targetAnchor );
		
		// Add bendpoints for making manhattan style
		int x = ( sourceAnchor.getParent().getGraphicsAlgorithm().getX() + targetAnchor.getParent().getGraphicsAlgorithm().getX() ) / 2;
		x += sourceAnchor.getParent().getGraphicsAlgorithm().getWidth() / 2;
		int y1 = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( sourceAnchor ).getY();
		int y2 = Graphiti.getPeLayoutService().getLocationRelativeToDiagram( targetAnchor ).getY();
		Point bendpoint = Graphiti.getCreateService().createPoint( x, y1 );
		connection.getBendpoints().add( bendpoint );
		bendpoint = Graphiti.getCreateService().createPoint( x, y2 );
		connection.getBendpoints().add( bendpoint );

		Polyline polyline = gaService.createPlainPolyline ( connection );
		polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));

		// Add static graphical decorators (composition and navigable)
		ConnectionDecorator cd;
		cd = peCreateService.createConnectionDecorator(connection, false, 1.0, true);
		createArrow(cd);
		return connection;
	}

	private Polyline createArrow(GraphicsAlgorithmContainer gaContainer) {
		Polyline polyline = Graphiti.getGaCreateService().createPlainPolyline(gaContainer,
				new int[] { -10, 5, 0, 0, -10, -5 });
		polyline.setStyle(StyleUtil.getStyleForEClass(getDiagram()));
		return polyline;
	}
}
