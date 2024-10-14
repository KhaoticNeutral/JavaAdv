package examples.ThreadPoolExample.client;

import java.util.Objects;

public class RequestResponse {

    public String host; //request
    public int port; //request
    public String response; //response

    public RequestResponse(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RequestResponse) {
            RequestResponse lookup = (RequestResponse) obj;
            if (host.equals(lookup.host) && port == lookup.port) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.host);
        hash = 97 * hash + this.port;
        return hash;
    }
}

//the RequestResponse class provides a convenient way to represent a network request and its corresponding response.
// The equals() and hashCode() methods ensure that two RequestResponse objects with the same host and port are considered equal,
// which is crucial for using them as keys in maps.