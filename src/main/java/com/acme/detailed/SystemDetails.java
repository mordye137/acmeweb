package com.acme.detailed;

import com.acme.servermgr.ServerManager;

/**
 * Public class that implements IDetails
 * and methods return system info from Runtime
 */
public class SystemDetails implements IDetails{

    private static final SystemDetails instance;

    /**
     * Create private constructor so it cannot be accessed externally
     */
    private SystemDetails(){};

    static { instance = new SystemDetails(); }

    /**
     * @return an instance of SystemDetails
     */
    public static SystemDetails getInstance() {
        return instance;
    }

    /**
     * Get an instance of Runtime
     */
    private final Runtime runtime = Runtime.getRuntime();

    /**
     * @return available processors from runtime
     */
    @Override
    public int getAvailableProcessors() {
        return runtime.availableProcessors();
    }

    /**
     * @return free JVM memory from runtime
     */
    @Override
    public long getFreeJVMMemory() {
        return runtime.freeMemory();
    }

    /**
     * @return total JVM memory from runtime
     */
    @Override
    public long getTotalJVMMemory() {
        return runtime.totalMemory();
    }

    /**
     * @return jre version from System properties
     */
    @Override
    public String getJreVersion() {
        return System.getProperty("java.runtime.version");
    }

    /**
     * @return temp location from System
     */
    @Override
    public String getTempLocation() {
        return System.getenv("TEMP");
    }
}
