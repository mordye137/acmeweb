package com.acme.decorators;
import com.acme.statusmgr.beans.ServerStatus;


/**
 * Base decorator class to decorate a ServerStatus. Each
 * decorator overrides the getStatusDesc method and adds
 * details to the server status statusDesc.
 */
public abstract class ServerStatusDecorator extends ServerStatus {
    ServerStatus serverStatus;

    public abstract String getStatusDesc();

}
