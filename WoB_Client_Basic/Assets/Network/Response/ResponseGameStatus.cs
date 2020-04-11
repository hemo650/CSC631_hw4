/*
ADDED GAMESTATUS CLASS 
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code.
Incorporated and defined new protocols
May not be used in Infection modified by Tony and Ibrahim
 */
using UnityEngine;
using System;

public class ResponseGameStatusEventArgs : ExtendedEventArgs {

	public short status { get; set; }
	public string name { get; set; }
	public float time { get; set; }
    public bool win { get; set; }

	public ResponseGameStatusEventArgs() {
		event_id = Constants.SMSG_GM_STATUS;
	}
}

public class ResponseGameStatus : NetworkResponse {

	private short status;
	private string name;
	private float time;
	private bool win;
	public ResponseGameStatus() {
	}

	public override void parse() {
		status = DataReader.ReadShort(dataStream);
		if (status == 0) {
			name = DataReader.ReadString(dataStream);
			time = DataReader.ReadFloat(dataStream);
			win = DataReader.ReadBool(dataStream);
		}
	}

	public override ExtendedEventArgs process() {
		ResponseGameStatusEventArgs args = null;
		if (status == 0) {
			args = new ResponseGameStatusEventArgs();
			args.status = status;
			args.name = name;
			args.time = time;
			args.win = win;
		}
		return args;
	}

}