package com.sillysally.kyst4backend.authorities;

public enum UserPermissions {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_POST("user:post"),
    USER_DELETE_ACCOUNT("user:delete_account"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    ADMIN_DELETE_POST("admin:delete_post");

    // Variable
    private final String userPermission;

    // Constructor
    UserPermissions(String userPermission) {
        this.userPermission = userPermission;
    }

    // Getter
    public String getUserPermission() {
        return userPermission;
    }
}
