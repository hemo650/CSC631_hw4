/*
MODIFIED LOGIN REQUEST
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code. May not 
be used in Infection created by Tony and Ibrahim.
 */
package networking.request;

// Java Imports
import java.io.IOException;

// Other Imports
import core.GameClient;
import core.GameServer;
import metadata.Constants;
import model.Player;
import networking.response.ResponseLogin;
import utility.DataReader;
import utility.Log;

/**
 * The RequestLogin class authenticates the user information to log in. Other
 * tasks as part of the login process lies here as well.
 */

public class RequestLogin extends GameRequest {

    // Data
    private String version;
    private String user_id;
    private String password;
    // Responses
    private ResponseLogin responseLogin;

    public RequestLogin() {
        responses.add(responseLogin = new ResponseLogin());
    }

    @Override
    public void parse() throws IOException {
        version = DataReader.readString(dataInput).trim();
        user_id = DataReader.readString(dataInput).trim();
        password = DataReader.readString(dataInput).trim();
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("%Connecting to user '%s'",  user_id);
        Player player = null;
        if (version.compareTo(Constants.CLIENT_VERSION) >= 0) {
            if (! user_id.isEmpty()) {
                if ( user_id.equalsIgnoreCase("test") && password.equals("test")) {
                    player = new Player(100, "test", "test", (short) 1);
                } else {
                    player = null;
                }
                if (player == null) {
                    responseLogin.setStatus((short) 1);
                    Log.printf("User: '%s' has incorrect credentials");
                } else {
                    player.setClient(client);
                    //TODO: Refactor playerID as user_id
                    if (client.getPlayer() == null || !player.get user_id().equals(client.getPlayer().get user_id())) {
                        GameClient thread = GameServer.getInstance().getThreadByPlayerID(player.getID());
                        if (thread != null) {
                            responseLogin.setStatus((short) 2); // Account is in use
                            thread.removePlayerData();
                            thread.newSession();
                            Log.printf(" User '%s's account is already in use.",  user_id);
                        } else {
                            GameServer.getInstance().setActivePlayer(player);
                            player.setClient(client);
                            client.setPlayer(player);
                            responseLogin.setStatus((short) 0); // Login is a success
                            responseLogin.setPlayer(player);
                            Log.printf("User '%s' has successfully logged in.", player.get user_id());
                        }
                    }
                }
            }
            } else {
                responseLogin.setStatus((short) 3); // Client version not compatible
                Log.printf("User '%s' has failed to log in. (v%s)", player.get user_id(), version);
            }

    }

}