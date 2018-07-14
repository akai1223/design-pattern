package pattern.proxy.staticed;

public class Father implements Person{
    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("根据你的要求物色");
        this.person.findLove();
        System.out.println("双方父母是不是同意");

    }

    @Override
    public void zufangzi() {

    }

    @Override
    public void buy() {

    }

    @Override
    public void findJob() {

    }

}
