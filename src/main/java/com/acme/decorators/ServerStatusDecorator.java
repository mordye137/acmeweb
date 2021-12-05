package com.acme.decorators;
import com.acme.detailed.IDetails;
import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;


/**
 * Base decorator class to decorate a ServerStatus. Each
 * decorator overrides the getStatusDesc method and adds
 * details to the server status statusDesc. Also has a setter
 * method to change the source of details.
 */
public abstract class ServerStatusDecorator extends ServerStatus {
    ServerStatus serverStatus;
    static IDetails detailsGetter = SystemDetails.getInstance();

    public abstract String getStatusDesc();

    void detailsSetter(IDetails details){
        this.detailsGetter = details;
    }
}
