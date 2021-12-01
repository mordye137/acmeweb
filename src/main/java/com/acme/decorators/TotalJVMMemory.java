package com.acme.decorators;

import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class TotalJVMMemory extends ServerStatusDecorator{

    protected static final String template = ", and there is a total of  %s bytes of JVM memory";

    private SystemDetails systemDetails;

    public TotalJVMMemory(ServerStatus serverStatus) { this.serverStatus = serverStatus; }

    public String getStatusDesc() { return serverStatus.getStatusDesc() + String.format(template, systemDetails.getTotalJVMMemory());}
}
