package com.cap.qualstracker.interfaces;

import com.cap.qualstracker.enums.AssociationLevel;

public interface QualsAssociationServiceInterface {

	public abstract void addOrUpdateUserSearch(String qualId, String associatedQualId,
			AssociationLevel associationLevel);
	public abstract void associateQualification(String qualId, String associatedQualId);
	public abstract double calcAndUpdateSearchPercentage(String qualId, String associatedQualId);
}
