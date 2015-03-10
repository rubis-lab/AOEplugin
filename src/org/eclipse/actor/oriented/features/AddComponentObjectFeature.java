package org.eclipse.actor.oriented.features;

import org.eclipse.actor.oriented.Component;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;


public class AddComponentObjectFeature extends AbstractAddFeature implements
		IAddFeature {
	
	private static final IColorConstant COMPONENT_FOREGROUND =
			new ColorConstant ( 255, 255, 255 );
	private static final IColorConstant TEXT_FOREGROUND =
			new ColorConstant ( 0, 0, 0 );

	public AddComponentObjectFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canAdd(IAddContext context) {		
		return context.getNewObject() instanceof Component;
	}

	@Override
	public PictogramElement add(IAddContext context) {

		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		Component component = (Component) context.getNewObject();
		
		int width = context.getWidth();
		int height = context.getHeight();
		width = width < 100 ? 100 : width;
		height = height < 100 ? 100 : height;
		ContainerShape containerShape = peCreateService.createContainerShape(targetDiagram, true);
		RoundedRectangle roundedRectangle = gaService.createRoundedRectangle(containerShape, 5, 5);
		roundedRectangle.setForeground( manageColor ( TEXT_FOREGROUND ) );
		roundedRectangle.setBackground( manageColor ( COMPONENT_FOREGROUND ) );
		gaService.setLocationAndSize(roundedRectangle, context.getX(), context.getY(), width, height );
		
		/* Text */
		Shape shape = peCreateService.createShape(containerShape, false);
		Text text = gaService.createText(shape, "Component");
		text.setForeground( manageColor ( TEXT_FOREGROUND ) );
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		gaService.setLocationAndSize(text, 0, 0, width, height );
		
		peCreateService.createChopboxAnchor(containerShape);

		link ( shape, component );
		link ( containerShape, component );
			      
		// call the layout feature
		layoutPictogramElement(containerShape);

		return containerShape;
	}
}
