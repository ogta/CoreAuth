package com.otapp.coreauth.common.constant;

public enum RecordStatus {
	
	ACTIVE(1), PASSIVE(0);
	
    private final int code;

    private RecordStatus(int code) {
        this.code = code;
    }

    public int Code() {
        return code;
    }

    public String toString() {
        return String.valueOf(code);
    }
}
