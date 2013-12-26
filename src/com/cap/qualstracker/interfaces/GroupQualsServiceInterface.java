package com.cap.qualstracker.interfaces;

import com.cap.qualstracker.transferobjects.GroupQualification;
import com.cap.qualstracker.transferobjects.GroupQualificationAssociation;

public interface GroupQualsServiceInterface {

	public String retrieveQualificationsForGroup(String groupdIds);
	public String retrieveForGroupWithUser(String groupId);
	public void addQualsAssociation(String qualAssociationId, String groupId);
	public GroupQualificationAssociation retrievePendingGroupQualAssocitaions(String userId);
	public GroupQualification retrievePendingGroupQual(String userId);
}
