public class ClassA {
    private String name;

    public ClassA(String name) {
        this.name = name;
    }

    public boolean compare(ClassA other) {
        if (this.name.equals(other.name)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ClassA a1 = new ClassA("Johny");
        ClassA a2 = new ClassA("Johny");
        System.out.println(a1.compare(a2));
    }
}
