package com.gmbsh.Entity;

public class PermissionEntity {
    private String PERMISSION_ID;
    private String MENU_CODE;
    private String MENU_NAME;
    private String PERMISSION_CODE;
    private String PERMISSION_NAME;
    private String REQUIRED_PERMISSION;

    public String getPERMISSION_ID() {
        return PERMISSION_ID;
    }

    public void setPERMISSION_ID(String PERMISSION_ID) {
        this.PERMISSION_ID = PERMISSION_ID;
    }

    public String getMENU_CODE() {
        return MENU_CODE;
    }

    public void setMENU_CODE(String MENU_CODE) {
        this.MENU_CODE = MENU_CODE;
    }

    public String getMENU_NAME() {
        return MENU_NAME;
    }

    public void setMENU_NAME(String MENU_NAME) {
        this.MENU_NAME = MENU_NAME;
    }

    public String getPERMISSION_CODE() {
        return PERMISSION_CODE;
    }

    public void setPERMISSION_CODE(String PERMISSION_CODE) {
        this.PERMISSION_CODE = PERMISSION_CODE;
    }

    public String getPERMISSION_NAME() {
        return PERMISSION_NAME;
    }

    public void setPERMISSION_NAME(String PERMISSION_NAME) {
        this.PERMISSION_NAME = PERMISSION_NAME;
    }

    public String getREQUIRED_PERMISSION() {
        return REQUIRED_PERMISSION;
    }

    public void setREQUIRED_PERMISSION(String REQUIRED_PERMISSION) {
        this.REQUIRED_PERMISSION = REQUIRED_PERMISSION;
    }

    @Override
    public String toString() {
        return "PermissionEntity{" +
                "PERMISSION_ID='" + PERMISSION_ID + '\'' +
                ", MENU_CODE='" + MENU_CODE + '\'' +
                ", MENU_NAME='" + MENU_NAME + '\'' +
                ", PERMISSION_CODE='" + PERMISSION_CODE + '\'' +
                ", PERMISSION_NAME='" + PERMISSION_NAME + '\'' +
                ", REQUIRED_PERMISSION='" + REQUIRED_PERMISSION + '\'' +
                '}';
    }
}
