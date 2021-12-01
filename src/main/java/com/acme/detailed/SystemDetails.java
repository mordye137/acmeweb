package com.acme.detailed;

public class SystemDetails implements IDetails{

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
