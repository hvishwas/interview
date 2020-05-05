package designpatterns.singleton;

public class Singleton {

    private Singleton() {
    }

    public Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }


    /**
     * 8. Serialization and Singleton
     * Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that we can store its state in the file system and retrieve it at a
     * later point of time. Here is a small singleton class that implements Serializable interface also.
     * <p>
     * <p>
     * package com.journaldev.singleton;
     * <p>
     * import java.io.Serializable;
     * <p>
     * public class SerializedSingleton implements Serializable{
     * <p>
     * private static final long serialVersionUID = -7604766932017737115L;
     * <p>
     * private SerializedSingleton(){}
     * <p>
     * private static class SingletonHelper{
     * private static final SerializedSingleton instance = new SerializedSingleton();
     * }
     * <p>
     * public static SerializedSingleton getInstance(){
     * return SingletonHelper.instance;
     * }
     * <p>
     * }
     * The problem with serialized singleton class is that whenever we deserialize it, it will create a new instance of the class. Let’s see it with a simple program.
     * <p>
     * <p>
     * package com.journaldev.singleton;
     * <p>
     * import java.io.FileInputStream;
     * import java.io.FileNotFoundException;
     * import java.io.FileOutputStream;
     * import java.io.IOException;
     * import java.io.ObjectInput;
     * import java.io.ObjectInputStream;
     * import java.io.ObjectOutput;
     * import java.io.ObjectOutputStream;
     * <p>
     * public class SingletonSerializedTest {
     * <p>
     * public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
     * SerializedSingleton instanceOne = SerializedSingleton.getInstance();
     * ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
     * "filename.ser"));
     * out.writeObject(instanceOne);
     * out.close();
     * <p>
     * //deserailize from file to object
     * ObjectInput in = new ObjectInputStream(new FileInputStream(
     * "filename.ser"));
     * SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
     * in.close();
     * <p>
     * System.out.println("instanceOne hashCode="+instanceOne.hashCode());
     * System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());
     * <p>
     * }
     * <p>
     * }
     * The output of the above program is;
     * <p>
     * instanceOne hashCode=2011117821
     * instanceTwo hashCode=109647522
     * <p>
     * So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() method.
     */
    protected Object readResolve() {
        return getInstance();
    }
}

