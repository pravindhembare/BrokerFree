package com.example.BrokerFree.Model;

public class JwtResponse {
    private String jwtToken;
    private String username;
    private String usertype;
   

	private JwtResponse(String jwtToken, String username ,String usertype) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.usertype = usertype;
    }

    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public String getUsername() {
        return username;
    }
    
    public String getUsertype() {
		return usertype;
	}	

    public static class JwtResponseBuilder {
        private String jwtToken;
        private String username;
        private String usertype;

        public JwtResponseBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JwtResponseBuilder username(String username) {
            this.username = username;
            return this;
        }
        
        public JwtResponseBuilder usertype(String usertype) {
            this.usertype = usertype;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, username,usertype);
        }
    }
}
