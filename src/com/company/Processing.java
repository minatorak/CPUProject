package com.company;

public class Processing extends Process {
    private double _cpu_time;
    private double _wait_time;
    private double _systime_time;

    public Processing(Process poc,Processing oldpoc) {
        super(poc);
        this._cpu_time = oldpoc._cpu_time + oldpoc._executeTime;
        this._wait_time = poc._arrival - this._cpu_time;
        this._systime_time = poc._executeTime + this._wait_time;
    }

    public double get_cpu_time() {
        return _cpu_time;
    }

    public double get_wait_time() {
        return _wait_time;
    }

    public double get_systime_time() {
        return _systime_time;
    }
}
