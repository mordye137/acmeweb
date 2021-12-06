package com.acme.statusmgr.beans;

import com.acme.decorators.*;
import com.acme.detailed.IDetails;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.exceptions.ForbiddenDetailsException;
import org.springframework.http.HttpStatus;

import javax.xml.transform.sax.SAXResult;
import java.util.List;

/**
 * A POJO that represents Server Status and can be returned as the result of a request.
 */
public class ServerStatus {

    private long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     * This class must return a pretty, english-like representation of the server status.
     *
     * @param id            a numeric identifier/counter of which request this is
     * @param contentHeader info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc = "Server is " + ServerManager.getCurrentServerStatus();
    }

    public ServerStatus() {

    }

    /**
     * get the id of this request
     *
     * @return a numeric id that increases during life of server for each request .
     */
    public long getId() {
        return id;
    }

    /**
     * Get the content header that was specified by the request
     *
     * @return some string
     */
    public String getContentHeader() {
        return contentHeader;
    }

    /**
     * Get an english-like description of the server's status
     *
     * @return A string describing status
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * @param serverStatus the server status that needs to be decorated
     * @param details the list of details that will be used to decorate the server status
     * @return a decorated server status
     */
    public static ServerStatus decorateStatus(ServerStatus serverStatus, List<String> details) throws ForbiddenDetailsException {

        for (String detail : details ) {

            switch (detail) {

                case "availableProcessors": serverStatus = new AvailableProcessors(serverStatus); break;

                case "freeJVMMemory": serverStatus = new FreeJVMMemory(serverStatus); break;

                case "totalJVMMemory": serverStatus = new TotalJVMMemory(serverStatus); break;

                case "jreVersion": serverStatus = new JREVersion(serverStatus); break;

                case "tempLocation": serverStatus = new TempLocation(serverStatus); break;

                default: throw new ForbiddenDetailsException("Invalid details option: " + detail);
            }
        }
        return serverStatus;
    }

}
