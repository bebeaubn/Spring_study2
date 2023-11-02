package commons;

public interface MobileValidator {
    default boolean checkMobile(String num){

        /**
         * 010 0000 0000
         * 011 000 0000
         * 016 000 0000
         *
         * 01000000000 / 010 0000 0000 /010-0000-0000/010.0000.0000
         */

        String mobile = num.replaceAll("\\D", "");
        String pattern ="^01[016]\\d{3,4}\\d{4}$";


        //숫자는 d 글자는 D 이걸로 정의해줘서 조건 만들어 두기
        return mobile.matches(pattern);


    }
}
