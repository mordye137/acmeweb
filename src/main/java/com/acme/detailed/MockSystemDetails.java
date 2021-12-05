package com.acme.detailed;

/**
 * Public class that implements the IDetails interface
 * and methods return fake system details
 */
public class MockSystemDetails implements IDetails{

    /**
     * @return mock available processors
     */
    @Override
    public int getAvailableProcessors() {
        return 4;
    }

    /**
     * @return mock free JVM memory
     */
    @Override
    public long getFreeJVMMemory() {
        return 127268272;
    }

    /**
     * @return mock total JVM memory
     */
    @Override
    public long getTotalJVMMemory() {
        return 159383552;
    }

    /**
     * @return mock jre version
     */
    @Override
    public String getJreVersion() {
        return "15.0.2+7-27";
    }

    /**
     * @return mock temp location
     */
    @Override
    public String getTempLocation() {
        return "M:\\\\AppData\\\\Local\\\\Temp";
    }
}
