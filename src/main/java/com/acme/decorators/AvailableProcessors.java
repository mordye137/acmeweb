package com.acme.decorators;

import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class AvailableProcessors extends ServerStatusDecorator{

    protected static final String template = ", and there are %s processors available";

    private SystemDetails systemDetails;

    public AvailableProcessors(ServerStatus serverStatus) { this.serverStatus = serverStatus; };

    public String getStatusDesc() {
        return serverStatus.getStatusDesc() + String.format(template, systemDetails.getAvailableProcessors());
    }
}
