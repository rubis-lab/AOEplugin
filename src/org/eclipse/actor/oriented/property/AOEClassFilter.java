package org.eclipse.actor.oriented.property;

import org.eclipse.actor.oriented.Port;
import org.eclipse.actor.oriented.Component;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class AOEClassFilter extends AbstractPropertySectionFilter {

	@Override
	protected boolean accept(PictogramElement pe) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
	
		if ( bo instanceof Port ) {
			return true;
		}
		
		if ( bo instanceof Component ) {
			return true;
		}
		
		return false;
	}

}
