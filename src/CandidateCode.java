import java.util.HashMap;
// If some people are siting on round table and passing ball to each other and
// if somebody gets more than certain number of balls that person wins the game
// And To win rules are if number of balls count you have is even you have to pass clockwise otherwise Anticlockwise.
// Game starts from person siting on 1st position.
// And Number of person should be b/w 2 - 1000
// and also number of balls to win should be more than 2



public class CandidateCode {
    public static int passCount(int numberOFPeopleSittingOnRoundTable, int numberOfBallCountNeededForwin, int movePositionBythisPosition) {
        if (isInputValid(numberOFPeopleSittingOnRoundTable, numberOfBallCountNeededForwin)) {
            HashMap<String, Integer> personAndBallCount = new HashMap<>();
            personAndBallCount.put(Integer.toString(1), 1);
            int sum = 0;
            int personPlace = 1;
            String personLocation = Integer.toString(personPlace);

            for (int i = 1; i <= numberOFPeopleSittingOnRoundTable * numberOfBallCountNeededForwin; i++) {
                Integer updatedNumberOfBalls;

                if (IsEven(personAndBallCount, personLocation)) {
                    int position = personPlace + movePositionBythisPosition;
                    personPlace = position > numberOFPeopleSittingOnRoundTable ? position - numberOFPeopleSittingOnRoundTable : position;
                } else {
                    int position = personPlace - movePositionBythisPosition;
                    personPlace = position <= 0 ? numberOFPeopleSittingOnRoundTable + position : position;
                }

                personLocation = Integer.toString(personPlace);

                Integer noOfTimesBallCameToPerson = personAndBallCount.get(personLocation);
                updatedNumberOfBalls = noOfTimesBallCameToPerson == null ? 1 : noOfTimesBallCameToPerson + 1;

                personAndBallCount.put(personLocation, updatedNumberOfBalls);

                sum = sum + 1;

                if (personAndBallCount.get(personLocation) >= numberOfBallCountNeededForwin) {
                    return sum;
                }
            }
        }
        return -1;
    }

    private static boolean isInputValid(int input1, int input2) {
        if (input1 < 3 || input1 > 1000 || input2 < 3 || input2 > 1000) {
            return false;
        }
        return true;
    }

    private static boolean IsEven(HashMap<String, Integer> personAndBallCount, String personLocation) {
        return personAndBallCount.get(personLocation) % 2 == 0;
    }
}
