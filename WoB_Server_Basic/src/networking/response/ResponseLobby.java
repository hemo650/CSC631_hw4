/*
NEW LOBBY RESPONSE
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code. May not 
be used in Infection created by Tony and Ibrahim.
 */
package networking.response;

import metadata.Constants;
import model.Lobby;
import utility.GamePacket;

public class ResponseLobby extends GameResponse{
    private short status;
    private Lobby lobby;

    public ResponseLobby() {
        responseCode = Constants.SMSG_LOBBY;
    }

    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        if (status == 0) {
            for (int id : lobby.getPlayers()) {
                packet.addInt32(id);
            }
            packet.addInt32(lobby.getSize());
            packet.addString(lobby.getPassword());

        }
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}