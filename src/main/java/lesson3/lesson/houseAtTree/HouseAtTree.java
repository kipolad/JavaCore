/**
 * Created by Yulya Telysheva
 */
package lesson3.lesson.houseAtTree;

public class HouseAtTree<T extends Animal & Flyable> {
    private T master;

    public HouseAtTree(T master) {
        this.master = master;
    }

    public T getMaster() {
        return master;
    }

    public void setMaster(T master) {
        this.master = master;
    }

    @Override
    public String toString() {
        return "HouseAtTree{" +
                "master=" + master +
                '}';
    }

    public static void main(String[] args) {
        //HouseAtTree<Cat> catHouse = new HouseAtTree<>(new Cat()); Он не имплементирует Flyable
        //HouseAtTree<Plane> planeHouseAtTree; Он не наследуется от животных
        HouseAtTree<Birds> birdsHouseAtTree = new HouseAtTree<>(new Birds());
    }
}
