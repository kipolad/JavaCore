/**
 * Created by Yulya Telysheva
 */
package lesson9.lambda;

public class CheckIsJumper implements CheckAble{

    public boolean test(Animal animal) {
        return animal.isCanJump();
    }
}
