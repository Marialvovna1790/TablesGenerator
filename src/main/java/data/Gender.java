package data;

public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "МУЖ";
        }
    },


    FEMALE {
        @Override
        public String toString() {
            return "ЖЕН";
        }
    }
}
