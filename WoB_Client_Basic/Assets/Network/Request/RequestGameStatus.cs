/*
ADDED GAMESTATUS CLASS 
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code.
Incorporated and defined new gamestatus protocols
May not be used in Infection modified by Tony and Ibrahim
 */
   
using UnityEngine;
using System;

public class RequestGameStatus : NetworkRequest {

	public RequestGameStatus() {
		request_id = Constants.CMSG_GM_STATUS;
	}
	
	public void send(string name, float time, bool win) {
	    packet = new GamePacket(request_id);
		packet.addString(name);
		packet.addFloat32(time);
		packet.addBool(win);
	}
}