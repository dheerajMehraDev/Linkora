package com.dheeraj.user_service.Util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Method 1: Hash Password
    public static String hashPassword(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
        // 12 = strength (recommended 10–12)
    }

    // Method 2: Verify Password
    public static boolean verifyPassword(String rawPassword, String hashedPassword) {
        if (hashedPassword == null || hashedPassword.isEmpty()) {
            return false;
        }
        return BCrypt.checkpw(rawPassword, hashedPassword);
    }
}
