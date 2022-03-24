/**
 * Created by Yulya Telysheva
 */
package lesson2.lesson;

public class CalculateSquare {
    public static void main(String[] args) {
        int square = 0;
        try {
            square = calcRectangleSquare(-1, 3);
        } catch (OneOrMoreRectangleSideIsNegativeException e) {
            System.err.println(e);
        }

        System.out.println(square);
    }

    private static int calcRectangleSquare(int sideA, int sideB) throws OneOrMoreRectangleSideIsNegativeException {
        if (sideA <= 0 || sideB <= 0) {
            throw new OneOrMoreRectangleSideIsNegativeException(
                    "Одна или обе стороны прямоугольника отрицательные: сторона А = " + sideA +
                            " сторона В = " + sideB); // не имеет смысла выбрасывать и тутже оборачивать, лучше обернуть вызов метода в main
        }
        return sideA * sideB;
    }
}
