package com.acme.detailed;


/**
 * This interface is made to return information about the System,
 * through 2 implementations, real system details or fake.
 */

public interface IDetails {

    /**
     * @return available processors
     */
    int getAvailableProcessors ();

    /**
     * @return free JVM memory
     */
    long getFreeJVMMemory ();

    /**
     * @return total JVM memory
     */
    long getTotalJVMMemory ();

    /**
     * @return jre version
     */
    String getJreVersion ();

    /**
     * @return temp location
     */
    String getTempLocation ();
}
