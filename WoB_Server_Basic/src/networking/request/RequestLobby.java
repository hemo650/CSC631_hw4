/*
NEW LOBBY REQUEST
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code. May not 
be used in Infection created by Tony.
 */

package networking.request;

import networking.response.ResponseLobby;
import utility.Log;

import java.io.IOException;

public class RequestLobby extends GameRequest{

    private String host;
    private ResponseLobby responseLobby;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public void parse() throws IOException {
        responses.add(responseLobby = new ResponseLobby());
    }

    @Override
    public void doBusiness() throws Exception {
        Log.printf("Lobby request recieved");
    }
}