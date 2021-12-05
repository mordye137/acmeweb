package com.acme.decorators;

import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class TempLocation extends ServerStatusDecorator{

    protected final String template = ", and the server's temp file location is %s";

    private SystemDetails systemDetails = SystemDetails.getInstance();

    public TempLocation(ServerStatus serverStatus) { this.serverStatus = serverStatus; }

    public String getStatusDesc() { return serverStatus.getStatusDesc() + String.format(template, systemDetails.getTempLocation()); }

    public long getId(){ return serverStatus.getId(); }

    public String getContentHeader(){ return serverStatus.getContentHeader(); }
}
