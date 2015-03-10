package org.eclipse.actor.oriented.features;

import org.eclipse.actor.oriented.Component;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.BoxRelativeAnchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

public class CreateComponentConnectionFeature extends AbstractCreateConnectionFeature
		implements ICreateConnectionFeature {

	public CreateComponentConnectionFeature(IFeatureProvider fp) {
		super(fp, "ComponentObjectConnection", "Creates a new ComponentObjectConnection between two Components");
	}

	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {
		if ( context.getSourceAnchor() instanceof BoxRelativeAnchor ) {
			BoxRelativeAnchor bra = (BoxRelativeAnchor) context.getSourceAnchor();
			if ( bra.getRelativeWidth() == 1.0 ) return true;
		}
		
		return false;
	}

	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		boolean ret = true;

		if ( ! (context.getSourceAnchor() instanceof BoxRelativeAnchor) ) return false;
		if ( ! (context.getTargetAnchor() instanceof BoxRelativeAnchor) ) return false;
		if ( context.getSourceAnchor().equals( context.getTargetAnchor() ) ) ret = false;
		if ( context.getTargetAnchor() != null ) {
			if ( context.getSourceAnchor().getParent().equals( context.getTargetAnchor().getParent() ) ) ret = false;

			BoxRelativeAnchor bra = (BoxRelativeAnchor) context.getTargetAnchor();
			if ( bra.getRelativeWidth() == 1.0 ) ret = false;
		}
		
		return ret;
	}

	@Override
	public Connection create(ICreateConnectionContext context) {
		Connection newConnection = null;

		// get EClasses which should be connected
		AnchorContainer sourceParent = context.getSourceAnchor().getParent();
		AnchorContainer targetParent = context.getTargetAnchor().getParent();
		EReference eReference = null;
		if ( getBusinessObjectForPictogramElement( sourceParent ) instanceof Component ) {
			Component sourceObj = (Component) getBusinessObjectForPictogramElement( sourceParent );
			Component targetObj = (Component) getBusinessObjectForPictogramElement( targetParent );
			eReference = createEReference ( sourceObj, targetObj );
		}
		
		AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
		addContext.setNewObject( eReference );
		newConnection = (Connection) getFeatureProvider().addIfPossible(addContext);

		return newConnection;
	}
	
	/*
	private EObject getEObject ( Anchor anchor ) {
		if ( anchor != null ) {
			Object obj = getBusinessObjectForPictogramElement( anchor.getParent() );
			if ( obj instanceof EObject ) return (EObject) obj;
		}
		return null;
	}
	*/
	
	private EReference createEReference ( EObject source, EObject target) {
		EReference eReference = EcoreFactory.eINSTANCE.createEReference();
		eReference.setName("new Reference");
		eReference.setEType( source.eClass() );
		eReference.setLowerBound(0);
		eReference.setUpperBound(1);
		source.eClass().getEStructuralFeatures().add(eReference);
		return eReference;
	}
}