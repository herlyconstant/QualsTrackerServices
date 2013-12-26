package com.cap.qualstracker.services;

import javax.ws.rs.Path;

import com.cap.qualstracker.interfaces.GroupQualsServiceInterface;
import com.cap.qualstracker.transferobjects.GroupQualification;
import com.cap.qualstracker.transferobjects.GroupQualificationAssociation;

@Path("/groupqualsservice")
public class GroupQualsService extends BaseService implements GroupQualsServiceInterface{

	
	public String retrieveQualificationsForGroup(String groupdIds) {
		
		return null;
	}

	
	public String retrieveForGroupWithUser(String groupId) {
		
		return null;
	}

	
	public void addQualsAssociation(String qualAssociationId, String groupId) {
		
		
	}

	@Override
	public GroupQualificationAssociation retrievePendingGroupQualAssocitaions(
			String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupQualification retrievePendingGroupQual(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
