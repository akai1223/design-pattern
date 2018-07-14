package pattern.prototype.simple;

public class CloneTest {
    public static void main(String[] args) {
        CloneTarget p = new CloneTarget();
        p.name = "Tom";

        p.target = new CloneTarget();
        System.out.println(p.target);

        try {
            //浅拷贝，引用类型指向相同的对象
            CloneTarget obj = (CloneTarget) p.clone();

            System.out.println(obj.target);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
