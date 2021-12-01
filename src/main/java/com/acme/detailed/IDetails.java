package com.acme.detailed;

public interface IDetails {

    int getAvailableProcessors ();

    long getFreeJVMMemory ();

    long getTotalJVMMemory ();

    String getJreVersion ();

    String getTempLocation ();
}
