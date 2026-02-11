package com.dheeraj.post_service.Config;

import org.springframework.stereotype.Component;

@Component
public class UserContextHolder {

    private static ThreadLocal<Long> currentUser = new ThreadLocal<>();

    public static Long getCurrentUser(){
      return currentUser.get();
    }

    static void setCurrentUser(Long userId){
         currentUser.set(userId);
    }

    static void clearUserId(){
        currentUser.remove();
    }

}
