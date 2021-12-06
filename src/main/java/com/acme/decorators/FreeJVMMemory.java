package com.acme.decorators;

import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class FreeJVMMemory extends ServerStatusDecorator{

    protected static final String template = ", and there are %s bytes of JVM memory free";

    public FreeJVMMemory(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getStatusDesc() {
        return serverStatus.getStatusDesc() + String.format(template, detailsGetter.getFreeJVMMemory());
    }

    public long getId(){
        return serverStatus.getId();
    }

    public String getContentHeader(){
        return serverStatus.getContentHeader();
    }
}

