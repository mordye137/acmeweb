package com.acme.decorators;

import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class TotalJVMMemory extends ServerStatusDecorator {

    protected static final String template = ", and there is a total of  %s bytes of JVM memory";

    public TotalJVMMemory(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }

    public String getStatusDesc() {
        return serverStatus.getStatusDesc() + String.format(template, detailsGetter.getTotalJVMMemory());
    }

    public long getId() {
        return serverStatus.getId();
    }

    public String getContentHeader() {
        return serverStatus.getContentHeader();
    }
}
