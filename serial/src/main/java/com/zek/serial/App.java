package com.zek.serial;

public class App {
    public static void main(String[] args) {
        ISerialzer iSerialzer = new JavaSerializer();

        User user = new User();
        user.setAge(18);
        user.setName("zek");
        user.setBody("kkk");
        user.setSex("男");
        user.setPassword("123456");


        byte[] bytes = iSerialzer.serializer(user);
        User.num = 10;

        User user1 = iSerialzer.deSerializer(bytes, User.class);

        System.out.println("nativejava：" + user1 + "->" + User.getNum() + "->" + user1.getSex());


        ISerialzer fastJsonSerializer = new FastJsonSerializer();
        byte[] bytes2 = fastJsonSerializer.serializer(user);

        User user2 = fastJsonSerializer.deSerializer(bytes2, User.class);
        System.out.println("fast：" + user2 + "->" + User.getNum() + "->" + user2.getSex());
    }

    /**
     * 序列化实现Serializable接口
     * serialVersionUID保证序列化以后，反序列化的类是不是一样的
     *
     * 序列化的类字段多，反序列化接收的类缺少的字段读取不到内容
     *
     * 静态变量不参与序列化
     * 这其实比较容易理解，序列化保存的是对象的状态，静态变量属于类的状态，因此 序列化并不保存静态变量。
     *
     * transient 修饰的变量不参与序列化(可以逃过进行序列化)
     * Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，
     * 在被反序列化后，transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null。
     *
     * 在序列化过程中，虚拟机会试图调用对象类里的 writeObject 和 readObject 方法，进行用户自定义的序列化和反序列化，
     * 如果没有这样的方法，则默认调用是 ObjectOutputStream 的 defaultWriteObject 方法以及 ObjectInputStream 的 defaultReadObject 方法。
     * 用户自定义的 writeObject 和 readObject 方法可以允许用户控制序列化的过程，比如可以在序列化的过程中动态改变序列化的数值。
     * 基于这个原理，可以在实际应用中得到使用，用于敏感字段的加密工作
     *
     * 父类没有实现Serializable接口，子类实现，父类中的变量不序列化
     * 父类实现，子类没有实现，可以正常序列化
     *
     * 序列化，对同一对象写两次，第二次多5个字节，
     * 当写入文件的为同一对象时，并不会再将对象的内容进行存储，而只是再次存储一份引用，
     * 上面增加的 5 字节的存储空间就是新增引用和一些控制信息的空间。
     * 反序列化时，恢复引用关系，使得t1 和 t2 指向唯一的对象，二者相等，输出 true
     *
     * 序列化实现深克隆
     */

    /**
     * protobuf
     * 1.独立语言，独立平台
     *
     * 2.自己的开发语言
     *
     * 1.下载编译器
     * 2.编写独立的proto文件
     * syntax = "proto2";
     *
     * package com.zek.serial
     *
     * option java_package = "com.zek.serial";
     * option java_outer_classname = "userProto";
     *
     * message
     *
     *
     * .\proto.exe java_out=./ ./pro
     *
     * 原理
     * varint做编码
     * T-L-V存储
     */
}
