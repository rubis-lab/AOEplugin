package org.eclipse.actor.oriented.features;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.actor.oriented.Component;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.features.AbstractDrillDownFeature;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class DrillDownComFeature extends AbstractDrillDownFeature {
	IDoubleClickContext context;

	public DrillDownComFeature ( IFeatureProvider fp ) {
		super ( fp );
	}

	@Override
	public String getName() {
		// return "Open associated diagram";
		return "Open the Editor";
	}

	@Override
	protected Collection<Diagram> getDiagrams() {
		Collection<Diagram> result = Collections.emptyList();
		Resource resource = getDiagram().eResource();
		URI uri = resource.getURI();
		URI uriTrimmed = uri.trimFragment();
		if (uriTrimmed.isPlatformResource()){
			String platformString = uriTrimmed.toPlatformString(true);
			IResource fileResource = ResourcesPlugin.getWorkspace()
					.getRoot().findMember(platformString);
			if (fileResource != null){
				IProject project = fileResource.getProject();
				result = OrientedUtil.getDiagrams(project);
			}
		}
		return result;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		String name;
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		EObject eobj = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( context.getInnerPictogramElement() );
		if ( eobj instanceof Component ) {
			String s = ( (Component) eobj ).getId();
			name = s == null ? "anonymous" : s; 
		} else return;
		IFile ifile = root.getProjects()[0].getFile( name + ".c" );
		
        /* If non-exists */
        if ( !ifile.exists() ) {
			String contents = initURIDiagram();
			try {
				InputStream source = new ByteArrayInputStream(contents.getBytes());
				ifile.create(source, false, null);
			} catch ( Exception e ) {
				e.printStackTrace();
			}
		}

        /* Open the diagram */
        URI diagramURI = URI.createFileURI( ifile.toString() );
        
        if ( diagramURI != null ) {
        	IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        	        	
        	try {
        		/*
	            page.openEditor(new DiagramEditorInput ( diagramURI, getDiagramEditor().getDiagramTypeProvider().getProviderId() ),
	            		"org.eclipse.graphiti.ui.editor.DiagramEditor");
	            */
        		page.openEditor(new FileEditorInput ( ifile ),
						"org.eclipse.cdt.ui.editor.CEditor");
        	} catch ( Exception e ) {
        		e.printStackTrace();
        	}
        }
	}
	
	private String initURIDiagram() {
		return "";
	}
}
