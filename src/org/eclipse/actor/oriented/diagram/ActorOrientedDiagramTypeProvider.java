package org.eclipse.actor.oriented.diagram;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

public class ActorOrientedDiagramTypeProvider extends AbstractDiagramTypeProvider {
	private IToolBehaviorProvider[] toolBehaviorProviders;
	
	public ActorOrientedDiagramTypeProvider() {
		super();
		setFeatureProvider(new ActorOrientedFeatureProvider(this));
		/*
		MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Information",
				"The 'Collapse Feature' is intentionally not implemented yet.");
		*/
	}

	@Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {
        if (toolBehaviorProviders == null) {
            toolBehaviorProviders =
                new IToolBehaviorProvider[] { new ActorOrientedBehaviorProvider(
                    this) };
        }
        return toolBehaviorProviders;
    }
}
