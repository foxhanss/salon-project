package com.okesalon.util;

public class SessionManager {
    private static SessionManager instance;
    private Integer userId;
    private String username;
    private String namaLengkap;
    private String role;
    private boolean isLoggedIn;
    
    private SessionManager() {
        this.isLoggedIn = false;
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }
    
    public void login(Integer userId, String username, String namaLengkap, String role) {
        this.userId = userId;
        this.username = username;
        this.namaLengkap = namaLengkap;
        this.role = role;
        this.isLoggedIn = true;
        
        System.out.println("=== SESSION LOGIN ===");
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Nama: " + namaLengkap);
        System.out.println("Role: " + role);
        System.out.println("====================");
    }

    public void logout() {
        this.userId = null;
        this.username = null;
        this.namaLengkap = null;
        this.role = null;
        this.isLoggedIn = false;
        
        System.out.println("=== SESSION LOGOUT ===");
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public boolean isAdmin() {
        return "Admin".equals(role);
    }

    public boolean isKasir() {
        return "Kasir".equals(role);
    }

    public Integer getUserId() {
        return userId;
    }
    
    public String getUsername() {
        return username != null ? username : "";
    }
    
    public String getNamaLengkap() {
        return namaLengkap != null ? namaLengkap : "";
    }
    
    public String getRole() {
        return role != null ? role : "";
    }

    public String getDisplayName() {
        if (namaLengkap != null && role != null) {
            return namaLengkap + " (" + role + ")";
        }
        return "Guest";
    }
    
    public String getNamaLengkapOnly() {
        return namaLengkap != null ? namaLengkap : "Guest";
    }
}