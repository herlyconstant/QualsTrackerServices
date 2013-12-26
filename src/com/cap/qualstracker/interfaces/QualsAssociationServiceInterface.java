package com.cap.qualstracker.interfaces;

import javax.ws.rs.core.Response;

import com.cap.qualstracker.enums.AssociationLevel;
import com.cap.qualstracker.transferobjects.UserSearch;

public interface QualsAssociationServiceInterface {

	public Response addOrUpdateUserSearch(String qualId, String associatedQualId,
			AssociationLevel associationLevel);
	public void associateQualification(String qualId, String associatedQualId);
	public double calcAndUpdateSearchPercentage(String qualId, String associatedQualId);
}
