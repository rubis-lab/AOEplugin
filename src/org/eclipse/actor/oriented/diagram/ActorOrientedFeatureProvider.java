package org.eclipse.actor.oriented.diagram;

import org.eclipse.actor.oriented.features.AddComBendpointFeature;
import org.eclipse.actor.oriented.features.AddComponentConnectionFeature;
import org.eclipse.actor.oriented.features.AddComponentObjectFeature;
import org.eclipse.actor.oriented.features.CreateComponentConnectionFeature;
import org.eclipse.actor.oriented.features.CreateComponentObjectFeature;
import org.eclipse.actor.oriented.features.DrillDownComFeature;
import org.eclipse.actor.oriented.features.InputPortCreateFeature;
import org.eclipse.actor.oriented.features.LayoutComponentObjectFeature;
import org.eclipse.actor.oriented.features.MoveComAnchorFeature;
import org.eclipse.actor.oriented.features.MoveComBendpointFeature;
import org.eclipse.actor.oriented.features.MoveComShapeFeature;
import org.eclipse.actor.oriented.features.OutputPortCreateFeature;
import org.eclipse.actor.oriented.features.RemoveComBendpointFeature;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddBendpointFeature;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveAnchorFeature;
import org.eclipse.graphiti.features.IMoveBendpointFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IRemoveBendpointFeature;
import org.eclipse.graphiti.features.context.IAddBendpointContext;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.context.IMoveBendpointContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IRemoveBendpointContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;


public class ActorOrientedFeatureProvider extends DefaultFeatureProvider {
	public ActorOrientedFeatureProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}
	
	@Override
	public IRemoveBendpointFeature getRemoveBendpointFeature(
			IRemoveBendpointContext context) {
		return new RemoveComBendpointFeature(this);
	}

	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) {
		return new MoveComShapeFeature(this);
	}

	@Override
	public IAddBendpointFeature getAddBendpointFeature(
			IAddBendpointContext context) {
		return new AddComBendpointFeature(this);
	}

	@Override
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		return new MoveComAnchorFeature(this);
	}

	@Override
	public IMoveBendpointFeature getMoveBendpointFeature(
			IMoveBendpointContext context) {
		return new MoveComBendpointFeature(this);
	}

	@Override
	public ICreateFeature[] getCreateFeatures() {
		return new ICreateFeature[] {new CreateComponentObjectFeature(this)};
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() {
		return new ICreateConnectionFeature[] {new CreateComponentConnectionFeature(this)};
	}
	
	@Override
	public ICustomFeature[] getCustomFeatures(ICustomContext context) {
		return new ICustomFeature[] {
				new InputPortCreateFeature ( this ),
				new OutputPortCreateFeature ( this ),
				new DrillDownComFeature ( this )
		};
	}

	@Override
	public IAddFeature getAddFeature(IAddContext context) {
		Object newObject = context.getNewObject();
		if ( context instanceof IAddConnectionContext ) {
			return new AddComponentConnectionFeature(this);
		} else if ( newObject instanceof EObject ) {
			return new AddComponentObjectFeature(this);
		}

		return super.getAddFeature(context);
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {
		if ( context.getPictogramElement() instanceof ContainerShape ) {
			return  new LayoutComponentObjectFeature(this);
		}
	
		return super.getLayoutFeature(context);
	}
}
