/*
NEW REGISTER RESPONSE
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code. May not 
be used in Infection created by Tony and Ibrahim.
 */
package networking.response;

import metadata.Constants;
import model.Player;
import utility.GamePacket;

public class ResponseRegister extends GameResponse {

    private short status;
    private Player player;

    public ResponseRegister() {
        responseCode = Constants.SMSG_AUTH;
    }

    @Override
    public byte[] constructResponseInBytes() {
        GamePacket packet = new GamePacket(responseCode);
        packet.addShort16(status);
        if (status == 0) {
            packet.addInt32(player.getID());
            packet.addString(player.getUsername());
            packet.addString(player.getPassword());

        }
        return packet.getBytes();
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
