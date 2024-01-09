package org.scheduler.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Oauth2Resource {

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("token_type")
    String tokenType;

    @JsonProperty("refresh_token")
    String refreshToken;

    @JsonProperty("expires_in")
    String expiresIn;

    @JsonProperty("scope")
    String scope;

    @JsonProperty("katOneJwt")
    String katOneJwt;

    @JsonProperty("katOneUserId")
    Long katOneUserId;

    @JsonProperty("jti")
    String jti;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getKatOneJwt() {
        return katOneJwt;
    }

    public void setKatOneJwt(String katOneJwt) {
        this.katOneJwt = katOneJwt;
    }

    public Long getKatOneUserId() {
        return katOneUserId;
    }

    public void setKatOneUserId(Long katOneUserId) {
        this.katOneUserId = katOneUserId;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
