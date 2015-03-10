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

public class OutputPortCreateFeature extends AbstractCustomFeature {
	
	public static final IColorConstant OUTPUT_PORT_BACKGROUND =
			new ColorConstant ( 0, 0, 0 );
	
	public OutputPortCreateFeature ( IFeatureProvider fp ) {
		super(fp);
	}
	
	@Override
	public String getName() {
		return "Create a output port";
	}
	
	@Override
	public String getDescription() {
		return "Create a output port";
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
		
		if ( c.getOutputCnt() == 7 ) return;

		ContainerShape selectedShape = null;
		Collection<Shape> shape = Graphiti.getPeService().getAllContainedShapes( getDiagram() );
		for ( Shape s : shape ) {
			selectedShape = s.getContainer();
			if ( s.getGraphicsAlgorithm().equals( pe.getGraphicsAlgorithm() ) ) break;
		}
		
		if ( selectedShape == null ) return;
		c.setOutputCnt( c.getOutputCnt() +1 );
		
		final BoxRelativeAnchor boxAnchor = peCreateService.createBoxRelativeAnchor( selectedShape );
		double relativeHeight = 1.0 / ( c.getOutputCnt() +1 );
		double o_relativeHeight = relativeHeight;
		
		boxAnchor.setRelativeWidth ( 1.0 );
		for ( Anchor anchor : selectedShape.getAnchors() ) {
			if ( anchor instanceof BoxRelativeAnchor ) {
				if ( ((BoxRelativeAnchor) anchor).getRelativeWidth() == 1.0 ) {
					((BoxRelativeAnchor) anchor).setRelativeHeight( relativeHeight );
					relativeHeight += o_relativeHeight;
				}
			}
		}
		
		final Rectangle rectangle = gaService.createPlainRectangle(boxAnchor);
		rectangle.setForeground ( manageColor ( OUTPUT_PORT_BACKGROUND ) );
		rectangle.setBackground ( manageColor ( OUTPUT_PORT_BACKGROUND ) );
		rectangle.setLineWidth(2);
		gaService.setLocationAndSize(rectangle, -12, -6, 12, 12);
		
		Port p = OrientedFactory.eINSTANCE.createPort();
		p.setType( "OUTPUT" );
		c.getInputPortRefs().add( p );
		
		link ( boxAnchor, p );
		
		layoutPictogramElement ( pe );
	}
}
