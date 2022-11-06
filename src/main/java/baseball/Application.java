package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public List<Integer> setComputer() {
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNum)) {
                computer.add(randomNum);
            }
        }

        return computer;
    }
    public void checkUserHasException(List<Integer> user) throws Exception{
        Exception userException = new IllegalArgumentException();

        if((user.size() == 1) && (user.get(0) == 1) ) {}
        else if((user.size() == 1) && (user.get(0) == 2) ) {}
        else if(!(user.size() == 3)) { throw  userException; }

        for(Integer number : user) {
            if(number == 0) { throw userException; }
        }


        for(int userIndex = 1; userIndex < user.size(); userIndex++) {
            int zeroNum = user.get(0);
            int firstNum = user.get(1);

            if(zeroNum == user.get(userIndex)) { throw userException; }

            if(userIndex != 2) { continue; }

            if(firstNum == user.get(userIndex)) { throw userException; }

        }

    }

    public boolean countStrikeBall(List<Integer> user, List<Integer> computer) {
        int ball = 0;
        int strike = 0;
        for(int userIndex=0; userIndex<user.size(); userIndex++){
            strike += isStrike(computer, user.get(userIndex), userIndex);

            if(ball == 0 ) {
                ball += isBall(computer, user.get(userIndex));
            }
        }

        if(strike == 3) {
            System.out.println("3스트라이크");
            return true;
        } else if( (ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        } else if((ball != 0) && (strike == 0)){
            System.out.println(ball + "볼");
        } else if((ball == 0) && (strike != 0)) {
            System.out.println(strike + "스트라이크");
        } else if ((ball != 0) && (strike != 0)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        return false;
    }

    public int isStrike(List<Integer> computer, int userNum, int userIndex) {
        for(int computerIndex=0; computerIndex<computer.size(); computerIndex++) {
            if((userIndex == computerIndex) && (userNum == computer.get(computerIndex))) {
                return 1;
            }
        }

        return 0;
    }

    public int isBall(List<Integer> computer, int userNum) {
        for (Integer computerNum : computer) {
            if (userNum == computerNum) {
                return 1;
            }
        }

        return 0;
    }

    public boolean isValueToStopGame(int userInput) {
        return userInput == 1;
    }
}
