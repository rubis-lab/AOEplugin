package org.eclipse.actor.oriented.property;

import org.eclipse.actor.oriented.Component;
import org.eclipse.actor.oriented.Port;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

public class AOEClassSection extends GFPropertySection implements ITabbedPropertyConstants {
	
	private Composite parent, comComposite;
	private TabbedPropertySheetPage tabbedPropertySheetPage;
	
	private final String[] typeList = { "Input", "Output" };
	
	private Text idText;
	private CCombo typeCbx;
	private CLabel typeLbl;
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		this.parent = parent;
		this.tabbedPropertySheetPage = tabbedPropertySheetPage;
		
		parent.addKeyListener( new KeyListener() {
			public void keyReleased ( KeyEvent e ) {
				
			}
			
			public void keyPressed ( KeyEvent e ) {
				
			}
		});
	}

	@Override
	public void refresh() {
		super.refresh();
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object obj = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a EClass
			if (obj == null)
				return;
			
			createCOM ( parent, tabbedPropertySheetPage );
			if ( obj instanceof Port ) {
				typeCbx.setVisible( true );
				typeLbl.setVisible( true );
				Port port = (Port)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement( getSelectedPictogramElement() );
				typeCbx.setText ( port.getType() );
			}
			else if ( obj instanceof Component ) {
				typeCbx.setVisible( false );
				typeLbl.setVisible( false );
			}
		}
		
	}
	
	private final void createCOM( Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage ) {
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		if ( comComposite != null ) return;
		comComposite = factory.createFlatFormComposite( parent );
		Composite composite = comComposite;
		FormData data;

		/* ID */
		idText = factory.createText(composite, "");
		idText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(0, 300);
		data.top = new FormAttachment(0, VSPACE);
		idText.setLayoutData(data);
		
		CLabel valueLabel = factory.createCLabel(composite, "ID:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(idText, -HSPACE);
		data.top = new FormAttachment(idText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		
		/* Type */
		typeCbx = factory.createCCombo( composite, SWT.READ_ONLY );
		for ( String s : typeList ) typeCbx.add( s );
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(0, 300);
		data.top = new FormAttachment( idText, VSPACE);
		typeCbx.setLayoutData(data);
		typeCbx.setEditable( false );
		typeCbx.setEnabled( false );
		// typeCbx.addSelectionListener( virtualListener );
		
		typeLbl = factory.createCLabel(composite, "Type:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment( typeCbx, HSPACE);
		data.top = new FormAttachment( typeCbx, 0, SWT.CENTER);
		typeLbl.setLayoutData(data);
	}

}
