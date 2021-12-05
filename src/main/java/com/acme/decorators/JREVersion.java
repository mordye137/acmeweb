package com.acme.decorators;

import com.acme.detailed.IDetails;
import com.acme.detailed.SystemDetails;
import com.acme.statusmgr.beans.ServerStatus;

public class JREVersion extends ServerStatusDecorator{

    protected static final String template = ", and the JRE version is %s";

    public JREVersion(ServerStatus serverStatus) { this.serverStatus = serverStatus; }

    public String getStatusDesc() { return serverStatus.getStatusDesc() + String.format(template, detailsGetter.getJreVersion()); }

    public long getId(){ return serverStatus.getId(); }

    public String getContentHeader(){ return serverStatus.getContentHeader(); }
}
