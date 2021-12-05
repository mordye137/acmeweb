package com.acme.decorators;

import com.acme.detailed.IDetails;
import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

import java.util.IdentityHashMap;

public class AvailableProcessors extends ServerStatusDecorator{

    protected static final String template = ", and there are %s processors available";

    public AvailableProcessors(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    };

    public String getStatusDesc() {
        return serverStatus.getStatusDesc() + String.format(template, detailsGetter.getAvailableProcessors());
    }

    public long getId(){
        return serverStatus.getId();
    }

    public String getContentHeader(){
        return serverStatus.getContentHeader();
    }
}
