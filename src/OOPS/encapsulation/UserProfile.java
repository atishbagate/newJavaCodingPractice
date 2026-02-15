package OOPS.encapsulation;

import java.util.Date;

    public final class UserProfile {
        private final String name;
        private final Date joiningDate;

        public UserProfile(String name, Date joiningDate) {
            this.name = name;
            this.joiningDate = new Date(joiningDate.getTime());
        }

        public Date getJoiningDate() {
            return joiningDate;
        }

        public String getName() {
            return name;
        }

        public static void main(String[] args){
            Date today = new Date();

            UserProfile user = new UserProfile("admin",today);

            System.out.println("original date "+user.getJoiningDate());
            today.setTime(0);

            System.out.println("after change "+user.getJoiningDate());
        }


    }


