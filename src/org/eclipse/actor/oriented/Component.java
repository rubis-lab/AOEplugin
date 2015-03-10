/**
 */
package org.eclipse.actor.oriented;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.actor.oriented.Component#getInputComponetRefs <em>Input Componet Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.Component#getOutputComponetRefs <em>Output Componet Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.Component#getInputPortRefs <em>Input Port Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.Component#getOutputPortRefs <em>Output Port Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.Component#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.Component#getInputCnt <em>Input Cnt</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.Component#getOutputCnt <em>Output Cnt</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent()
 * @model extendedMetaData="name='Component' kind='elementOnly'"
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Componet Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.actor.oriented.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Componet Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Componet Refs</em>' containment reference list.
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_InputComponetRefs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='inputComponetRefs'"
	 * @generated
	 */
	EList<Component> getInputComponetRefs();

	/**
	 * Returns the value of the '<em><b>Output Componet Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.actor.oriented.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Componet Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Componet Refs</em>' containment reference list.
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_OutputComponetRefs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='outputComponetRefs'"
	 * @generated
	 */
	EList<Component> getOutputComponetRefs();

	/**
	 * Returns the value of the '<em><b>Input Port Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.actor.oriented.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Port Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Port Refs</em>' containment reference list.
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_InputPortRefs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='inputPortRefs'"
	 * @generated
	 */
	EList<Port> getInputPortRefs();

	/**
	 * Returns the value of the '<em><b>Output Port Refs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.actor.oriented.Port}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Port Refs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Port Refs</em>' containment reference list.
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_OutputPortRefs()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='outputPortRefs'"
	 * @generated
	 */
	EList<Port> getOutputPortRefs();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_Id()
	 * @model extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.actor.oriented.Component#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Input Cnt</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Cnt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Cnt</em>' attribute.
	 * @see #setInputCnt(int)
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_InputCnt()
	 * @model default="0"
	 *        extendedMetaData="kind='attribute' name='inputCnt'"
	 * @generated
	 */
	int getInputCnt();

	/**
	 * Sets the value of the '{@link org.eclipse.actor.oriented.Component#getInputCnt <em>Input Cnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Cnt</em>' attribute.
	 * @see #getInputCnt()
	 * @generated
	 */
	void setInputCnt(int value);

	/**
	 * Returns the value of the '<em><b>Output Cnt</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Cnt</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Cnt</em>' attribute.
	 * @see #setOutputCnt(int)
	 * @see org.eclipse.actor.oriented.OrientedPackage#getComponent_OutputCnt()
	 * @model default="0"
	 *        extendedMetaData="kind='attribute' name='outputCnt'"
	 * @generated
	 */
	int getOutputCnt();

	/**
	 * Sets the value of the '{@link org.eclipse.actor.oriented.Component#getOutputCnt <em>Output Cnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Cnt</em>' attribute.
	 * @see #getOutputCnt()
	 * @generated
	 */
	void setOutputCnt(int value);

} // Component
