/**
 */
package org.eclipse.actor.oriented.impl;

import java.util.Collection;

import org.eclipse.actor.oriented.Component;
import org.eclipse.actor.oriented.OrientedPackage;
import org.eclipse.actor.oriented.Port;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getInputComponetRefs <em>Input Componet Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getOutputComponetRefs <em>Output Componet Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getInputPortRefs <em>Input Port Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getOutputPortRefs <em>Output Port Refs</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getInputCnt <em>Input Cnt</em>}</li>
 *   <li>{@link org.eclipse.actor.oriented.impl.ComponentImpl#getOutputCnt <em>Output Cnt</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentImpl extends EObjectImpl implements Component {
	/**
	 * The cached value of the '{@link #getInputComponetRefs() <em>Input Componet Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputComponetRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> inputComponetRefs;

	/**
	 * The cached value of the '{@link #getOutputComponetRefs() <em>Output Componet Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputComponetRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> outputComponetRefs;

	/**
	 * The cached value of the '{@link #getInputPortRefs() <em>Input Port Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputPortRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> inputPortRefs;

	/**
	 * The cached value of the '{@link #getOutputPortRefs() <em>Output Port Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputPortRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> outputPortRefs;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInputCnt() <em>Input Cnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputCnt()
	 * @generated
	 * @ordered
	 */
	protected static final int INPUT_CNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInputCnt() <em>Input Cnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputCnt()
	 * @generated
	 * @ordered
	 */
	protected int inputCnt = INPUT_CNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputCnt() <em>Output Cnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputCnt()
	 * @generated
	 * @ordered
	 */
	protected static final int OUTPUT_CNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOutputCnt() <em>Output Cnt</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputCnt()
	 * @generated
	 * @ordered
	 */
	protected int outputCnt = OUTPUT_CNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OrientedPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getInputComponetRefs() {
		if (inputComponetRefs == null) {
			inputComponetRefs = new EObjectContainmentEList<Component>(Component.class, this, OrientedPackage.COMPONENT__INPUT_COMPONET_REFS);
		}
		return inputComponetRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getOutputComponetRefs() {
		if (outputComponetRefs == null) {
			outputComponetRefs = new EObjectContainmentEList<Component>(Component.class, this, OrientedPackage.COMPONENT__OUTPUT_COMPONET_REFS);
		}
		return outputComponetRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getInputPortRefs() {
		if (inputPortRefs == null) {
			inputPortRefs = new EObjectContainmentEList<Port>(Port.class, this, OrientedPackage.COMPONENT__INPUT_PORT_REFS);
		}
		return inputPortRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getOutputPortRefs() {
		if (outputPortRefs == null) {
			outputPortRefs = new EObjectContainmentEList<Port>(Port.class, this, OrientedPackage.COMPONENT__OUTPUT_PORT_REFS);
		}
		return outputPortRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrientedPackage.COMPONENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInputCnt() {
		return inputCnt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputCnt(int newInputCnt) {
		int oldInputCnt = inputCnt;
		inputCnt = newInputCnt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrientedPackage.COMPONENT__INPUT_CNT, oldInputCnt, inputCnt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOutputCnt() {
		return outputCnt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputCnt(int newOutputCnt) {
		int oldOutputCnt = outputCnt;
		outputCnt = newOutputCnt;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OrientedPackage.COMPONENT__OUTPUT_CNT, oldOutputCnt, outputCnt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OrientedPackage.COMPONENT__INPUT_COMPONET_REFS:
				return ((InternalEList<?>)getInputComponetRefs()).basicRemove(otherEnd, msgs);
			case OrientedPackage.COMPONENT__OUTPUT_COMPONET_REFS:
				return ((InternalEList<?>)getOutputComponetRefs()).basicRemove(otherEnd, msgs);
			case OrientedPackage.COMPONENT__INPUT_PORT_REFS:
				return ((InternalEList<?>)getInputPortRefs()).basicRemove(otherEnd, msgs);
			case OrientedPackage.COMPONENT__OUTPUT_PORT_REFS:
				return ((InternalEList<?>)getOutputPortRefs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OrientedPackage.COMPONENT__INPUT_COMPONET_REFS:
				return getInputComponetRefs();
			case OrientedPackage.COMPONENT__OUTPUT_COMPONET_REFS:
				return getOutputComponetRefs();
			case OrientedPackage.COMPONENT__INPUT_PORT_REFS:
				return getInputPortRefs();
			case OrientedPackage.COMPONENT__OUTPUT_PORT_REFS:
				return getOutputPortRefs();
			case OrientedPackage.COMPONENT__ID:
				return getId();
			case OrientedPackage.COMPONENT__INPUT_CNT:
				return getInputCnt();
			case OrientedPackage.COMPONENT__OUTPUT_CNT:
				return getOutputCnt();
		}
		// return super.eGet(featureID, resolve, coreType);
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OrientedPackage.COMPONENT__INPUT_COMPONET_REFS:
				getInputComponetRefs().clear();
				getInputComponetRefs().addAll((Collection<? extends Component>)newValue);
				return;
			case OrientedPackage.COMPONENT__OUTPUT_COMPONET_REFS:
				getOutputComponetRefs().clear();
				getOutputComponetRefs().addAll((Collection<? extends Component>)newValue);
				return;
			case OrientedPackage.COMPONENT__INPUT_PORT_REFS:
				getInputPortRefs().clear();
				getInputPortRefs().addAll((Collection<? extends Port>)newValue);
				return;
			case OrientedPackage.COMPONENT__OUTPUT_PORT_REFS:
				getOutputPortRefs().clear();
				getOutputPortRefs().addAll((Collection<? extends Port>)newValue);
				return;
			case OrientedPackage.COMPONENT__ID:
				setId((String)newValue);
				return;
			case OrientedPackage.COMPONENT__INPUT_CNT:
				setInputCnt((Integer)newValue);
				return;
			case OrientedPackage.COMPONENT__OUTPUT_CNT:
				setOutputCnt((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OrientedPackage.COMPONENT__INPUT_COMPONET_REFS:
				getInputComponetRefs().clear();
				return;
			case OrientedPackage.COMPONENT__OUTPUT_COMPONET_REFS:
				getOutputComponetRefs().clear();
				return;
			case OrientedPackage.COMPONENT__INPUT_PORT_REFS:
				getInputPortRefs().clear();
				return;
			case OrientedPackage.COMPONENT__OUTPUT_PORT_REFS:
				getOutputPortRefs().clear();
				return;
			case OrientedPackage.COMPONENT__ID:
				setId(ID_EDEFAULT);
				return;
			case OrientedPackage.COMPONENT__INPUT_CNT:
				setInputCnt(INPUT_CNT_EDEFAULT);
				return;
			case OrientedPackage.COMPONENT__OUTPUT_CNT:
				setOutputCnt(OUTPUT_CNT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OrientedPackage.COMPONENT__INPUT_COMPONET_REFS:
				return inputComponetRefs != null && !inputComponetRefs.isEmpty();
			case OrientedPackage.COMPONENT__OUTPUT_COMPONET_REFS:
				return outputComponetRefs != null && !outputComponetRefs.isEmpty();
			case OrientedPackage.COMPONENT__INPUT_PORT_REFS:
				return inputPortRefs != null && !inputPortRefs.isEmpty();
			case OrientedPackage.COMPONENT__OUTPUT_PORT_REFS:
				return outputPortRefs != null && !outputPortRefs.isEmpty();
			case OrientedPackage.COMPONENT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case OrientedPackage.COMPONENT__INPUT_CNT:
				return inputCnt != INPUT_CNT_EDEFAULT;
			case OrientedPackage.COMPONENT__OUTPUT_CNT:
				return outputCnt != OUTPUT_CNT_EDEFAULT;
		}
		// return super.eIsSet(featureID);
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", inputCnt: ");
		result.append(inputCnt);
		result.append(", outputCnt: ");
		result.append(outputCnt);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
