package najah; 

public class User {
        private String name;
        private String email;
        private String password;
        private String role;
        private boolean isActive;

        public User(String name, String email, String password, String role) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.role = role;
            this.isActive = true;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        @Override
        public String toString() {
            return "User{name='" + name + "', email='" + email + "', role='" + role + "', active=" + isActive + '}';
        }
    
}