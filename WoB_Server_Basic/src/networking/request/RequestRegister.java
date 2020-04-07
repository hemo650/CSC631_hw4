/*
NEW REGISTER REQUEST
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code. May not 
be used in Infection created by Ibrahim.
 */

   
package networking.request;

import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseRegister;
import utility.DataReader;
import utility.Log;

import java.io.IOException;

public class RequestRegister extends GameRequest {

    private String user_id;
    private String password;
    private String version;

    private ResponseRegister responseRegister;

    public RequestRegister() {
        responses.add(responseRegister = new ResponseRegister());
    }

    @Override
    public void parse() throws IOException {
        version = DataReader.readString(dataInput).trim();
        user_id = DataReader.readString(dataInput).trim();
        password = DataReader.readString(dataInput).trim();
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("%Connecting to user '%s'", user_id);
        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) {
            Player player = null;
            if (!user_id.isEmpty()) {
                //Selects ID from database 
                //adds playable account to database
                player = new Player(100, user_id, password, (short) 1);
                player.setClient(client);
                GameServer.getInstance().setActivePlayer(player);
                client.setPlayer(player);
                responseRegister.setStatus((short) 0); // Login is a success
                responseRegister.setPlayer(player);
                Log.printf("User '%s' has successfully logged in.", player.getuser_id());
            } else {
                responseRegister.setStatus((short) 3);
                Log.printf("Please input a user_id. (v%s)", player.getuser_id(), version);
            }
        }

    }
}