/*
ADDED REQUESTLOBBY CLASS 
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code.
Incorporated and defined new gamestatus protocols
May not be used in Infection modified by Tony and Ibrahim
 */
using UnityEngine;

using System;

public class RequestLobby : NetworkRequest {

	public RequestLobby() {
		request_id = Constants.CMSG_LOBBY;
	}
	
	public void send(int user_id, int size, string password) {
	    packet = new GamePacket(request_id);
		packet.addInt32(user_id);
		packet.addInt32(size);
		packet.addString(password);
	}
}