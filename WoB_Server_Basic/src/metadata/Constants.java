/*
MODIFIED CONSTANTS CLASS 
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code.
Incorporated and defined new protocols
May not be used in Infection modified by Tony
 */

package metadata;

/**
 * The Constants class stores important variables as constants for later use.
 */
public class Constants {

    // Request (1xx) + Response (2xx)
    public final static short CMSG_AUTH = 101;
    public final static short SMSG_AUTH = 201;
    public final static short CMSG_HEARTBEAT = 102;
    public final static short SMSG_HEARTBEAT = 202;
    public final static short CMSG_PLAYERS = 103;
    public final static short SMSG_PLAYERS = 203;
    public static final short CMSG_TEST = 104;
    public static final short SMSG_TEST = 204;
    public static final short SMSG_LOBBY = 105;
    public static final short CMSG_LOBBY = 205;
    public final static short CMSG_REG = 206;
    public final static short SMSG_REG = 206;
    public final static short CMSG_STATUS = 207;
    public final static short SMSG_STATUS = 207;


    // Other
    public static final String CLIENT_VERSION = "1.00";
    public static final int TIMEOUT_SECONDS = 90;
    public static final String CSV_SAVE_PATH = "src/log/";

}
