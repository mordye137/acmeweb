package com.acme.decorators;

import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class JREVersion extends ServerStatusDecorator{

    protected static final String template = ", and the JRE version is %s";

    private SystemDetails systemDetails;

    public JREVersion(ServerStatus serverStatus) { this.serverStatus = serverStatus; }

    public String getStatusDesc() { return serverStatus.getStatusDesc() + String.format(template, systemDetails.getJreVersion()); }
}
