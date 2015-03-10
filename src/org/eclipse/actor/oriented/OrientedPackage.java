/**
 */
package org.eclipse.actor.oriented;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.actor.oriented.OrientedFactory
 * @model kind="package"
 * @generated
 */
public interface OrientedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "oriented";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/actor/oriented.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.actor.oriented";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	OrientedPackage eINSTANCE = org.eclipse.actor.oriented.impl.OrientedPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.actor.oriented.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.actor.oriented.impl.ComponentImpl
	 * @see org.eclipse.actor.oriented.impl.OrientedPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Input Componet Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUT_COMPONET_REFS = 0;

	/**
	 * The feature id for the '<em><b>Output Componet Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUT_COMPONET_REFS = 1;

	/**
	 * The feature id for the '<em><b>Input Port Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUT_PORT_REFS = 2;

	/**
	 * The feature id for the '<em><b>Output Port Refs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUT_PORT_REFS = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__ID = 4;

	/**
	 * The feature id for the '<em><b>Input Cnt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__INPUT_CNT = 5;

	/**
	 * The feature id for the '<em><b>Output Cnt</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__OUTPUT_CNT = 6;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.actor.oriented.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.actor.oriented.impl.PortImpl
	 * @see org.eclipse.actor.oriented.impl.OrientedPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ID = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.actor.oriented.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see org.eclipse.actor.oriented.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.actor.oriented.Component#getInputComponetRefs <em>Input Componet Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Componet Refs</em>'.
	 * @see org.eclipse.actor.oriented.Component#getInputComponetRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_InputComponetRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.actor.oriented.Component#getOutputComponetRefs <em>Output Componet Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Componet Refs</em>'.
	 * @see org.eclipse.actor.oriented.Component#getOutputComponetRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_OutputComponetRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.actor.oriented.Component#getInputPortRefs <em>Input Port Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Port Refs</em>'.
	 * @see org.eclipse.actor.oriented.Component#getInputPortRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_InputPortRefs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.actor.oriented.Component#getOutputPortRefs <em>Output Port Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Port Refs</em>'.
	 * @see org.eclipse.actor.oriented.Component#getOutputPortRefs()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_OutputPortRefs();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.actor.oriented.Component#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.actor.oriented.Component#getId()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.actor.oriented.Component#getInputCnt <em>Input Cnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Cnt</em>'.
	 * @see org.eclipse.actor.oriented.Component#getInputCnt()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_InputCnt();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.actor.oriented.Component#getOutputCnt <em>Output Cnt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Cnt</em>'.
	 * @see org.eclipse.actor.oriented.Component#getOutputCnt()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_OutputCnt();

	/**
	 * Returns the meta object for class '{@link org.eclipse.actor.oriented.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.actor.oriented.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.actor.oriented.Port#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.actor.oriented.Port#getId()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.actor.oriented.Port#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.actor.oriented.Port#getType()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OrientedFactory getOrientedFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.actor.oriented.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.actor.oriented.impl.ComponentImpl
		 * @see org.eclipse.actor.oriented.impl.OrientedPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Input Componet Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INPUT_COMPONET_REFS = eINSTANCE.getComponent_InputComponetRefs();

		/**
		 * The meta object literal for the '<em><b>Output Componet Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTPUT_COMPONET_REFS = eINSTANCE.getComponent_OutputComponetRefs();

		/**
		 * The meta object literal for the '<em><b>Input Port Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__INPUT_PORT_REFS = eINSTANCE.getComponent_InputPortRefs();

		/**
		 * The meta object literal for the '<em><b>Output Port Refs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__OUTPUT_PORT_REFS = eINSTANCE.getComponent_OutputPortRefs();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__ID = eINSTANCE.getComponent_Id();

		/**
		 * The meta object literal for the '<em><b>Input Cnt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__INPUT_CNT = eINSTANCE.getComponent_InputCnt();

		/**
		 * The meta object literal for the '<em><b>Output Cnt</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__OUTPUT_CNT = eINSTANCE.getComponent_OutputCnt();

		/**
		 * The meta object literal for the '{@link org.eclipse.actor.oriented.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.actor.oriented.impl.PortImpl
		 * @see org.eclipse.actor.oriented.impl.OrientedPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__ID = eINSTANCE.getPort_Id();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TYPE = eINSTANCE.getPort_Type();

	}

} //OrientedPackage
