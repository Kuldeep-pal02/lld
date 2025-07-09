package creational;

import java.io.*;

public class PrototypePattern implements Cloneable {

    // when creating a object is expensive(external calls, file IO, or ), and if we can cone an existing object instead of building from
    //scratch. use-cases in game engines, UI frameworks,
    //Java has build in support using the Cloneable interface

    @Override
    public PrototypePattern clone() {
        try {
            return (PrototypePattern) super.clone(); //clone is a native method in java. probably using memcpy or some faster version of copy. Just FYI
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    //above will give shallow clone.
    // for deep clone we can use few things 1) Manually clone every field in the clone method, 2) use Serialization like below
    // But this needs all the object graph as serializable. ie Make sure your class + all fields implement Serializable
    public static <T> T deepClone(T obj) {
        try (
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos)
        ) {
            oos.writeObject(obj);
            try (
                    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                    ObjectInputStream ois = new ObjectInputStream(bais)
            ) {
                return (T) ois.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Deep clone failed", e);
        }
    }


}
