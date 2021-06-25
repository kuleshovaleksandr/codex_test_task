package com.codex.test_task.model;

public enum Permission {
    ITEM_READ("item:read"),
    ITEM_WRITE("item:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
