/*
MODIFIED CONSTANTS CLASS 
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code.
Incorporated and defined new protocols
May not be used in Infection modified by Ibrahim
 */
public class Constants {
	
	// Constants
	public static readonly string CLIENT_VERSION = "1.00";
	public static readonly string REMOTE_HOST = "localhost";
	public static readonly int REMOTE_PORT = 9252;
	
	// Request (1xx) + Response (2xx)
	public static readonly short CMSG_AUTH = 101;
	public static readonly short SMSG_AUTH = 201;
    public static readonly short CMSG_HEARTBEAT = 102;
    public static readonly short SMSG_HEARTBEAT = 202;
	public static readonly short CMSG_PLAYERS = 103;
	public static readonly short SMSG_PLAYERS = 203;
	public static readonly short CMSG_TEST = 104;
	public static readonly short SMSG_TEST = 204;
	public static readonly short CMSG_LOBBY = 105;
	public static readonly short SMSG_LOBBY = 205;
	public static readonly short CMSG_REGISTER = 106;
	public static readonly short SMSG_REGISTER = 206;
	public static readonly short CMSG_GM_STATUS = 107;
	public static readonly short SMSG_GM_STATUS = 207;
	
	
	// Other
	public static readonly string IMAGE_RESOURCES_PATH = "Images/";
	public static readonly string PREFAB_RESOURCES_PATH = "Prefabs/";
	public static readonly string TEXTURE_RESOURCES_PATH = "Textures/";
	
	// GUI Window IDs
	public enum GUI_ID {
		Login
	};

	public static int USER_ID = -1;
}