package com.tenstech.todocore.auth;

import lombok.Getter;
import lombok.Setter;

public class AuthDTO {

    @Setter
    @Getter
    public static class LoginRequest {
        private String username;
        private String password;

        public LoginRequest() {
        }

        public LoginRequest(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    @Setter
    @Getter
    public static class Response {
        private String message;
        private String token;

        public Response() {
        }

        public Response(String message, String token) {
            this.message = message;
            this.token = token;
        }
    }
}