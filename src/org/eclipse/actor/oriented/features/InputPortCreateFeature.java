package org.eclipse.actor.oriented.features;

import java.util.Collection;

import org.eclipse.actor.oriented.Component;
import org.eclipse.actor.oriented.OrientedFactory;
import org.eclipse.actor.oriented.Port;
import org.eclipse.actor.oriented.impl.ComponentImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class InputPortCreateFeature extends AbstractCustomFeature {
	
	public static final IColorConstant INPUT_PORT_BACKGROUND =
			new ColorConstant ( 0, 0, 0 );
	
	public InputPortCreateFeature ( IFeatureProvider fp ) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Create a input port";
	}
	
	@Override
	public String getDescription() {
		return "Create a input port";
	}

	@Override
	public boolean canExecute ( ICustomContext context ) {
		// allow rename if exactly one pictogram element
        // representing a EClass is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof Component || bo instanceof ComponentImpl) {
                ret = true;
            }
        }
        return ret;
	}
	
	@Override
	public void execute(ICustomContext context) {
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();		
		PictogramElement pe = context.getInnerPictogramElement();
		Component c = (Component) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( pe );

		if ( c.getInputCnt() == 7 ) return;

		ContainerShape selectedShape = null;
		Collection<Shape> shape = Graphiti.getPeService().getAllContainedShapes( getDiagram() );
		for ( Shape s : shape ) {
			selectedShape = s.getContainer();
			/*
			System.out.println ( "PE "+pe.getGraphicsAlgorithm() );
				System.out.println ( s.getGraphicsAlgorithm() );
			*/
			if ( s.getGraphicsAlgorithm().equals( pe.getGraphicsAlgorithm() ) ) break;
		}
		
		if ( selectedShape == null ) return;
		c.setInputCnt( c.getInputCnt() +1 );
		
		final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor( selectedShape );
		double relativeHeight = 1.0 / ( c.getInputCnt() +1 );
		double o_relativeHeight = relativeHeight;
		
		boxAnchor.setRelativeWidth ( 0.0 );
		for ( Anchor anchor : selectedShape.getAnchors() ) {
			if ( anchor instanceof BoxRelativeAnchor ) {
				if ( ((BoxRelativeAnchor) anchor).getRelativeWidth() == 0 ) {
					((BoxRelativeAnchor) anchor).setRelativeHeight( relativeHeight );
					relativeHeight += o_relativeHeight;
				}
			}
		}
		
		final Rectangle rectangle = gaService.createPlainRectangle(boxAnchor);
		rectangle.setForeground ( manageColor ( INPUT_PORT_BACKGROUND ) );
		rectangle.setBackground ( manageColor ( INPUT_PORT_BACKGROUND ) );
		rectangle.setLineWidth(2);
		gaService.setLocationAndSize(rectangle, 0, -6, 12, 12);
		
		Port p = OrientedFactory.eINSTANCE.createPort();
		p.setType( "INPUT" );
		c.getInputPortRefs().add( p );
		
		link ( boxAnchor, p );
		
		layoutPictogramElement ( pe );
	}
}
