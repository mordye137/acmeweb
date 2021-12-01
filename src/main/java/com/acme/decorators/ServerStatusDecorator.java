package com.acme.decorators;

import com.acme.statusmgr.beans.ServerStatus;

public abstract class ServerStatusDecorator extends ServerStatus {
    ServerStatus serverStatus;


    public abstract String getStatusDesc();
}
