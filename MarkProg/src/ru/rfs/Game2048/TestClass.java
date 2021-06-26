package ru.rfs.Game2048;

public class TestClass {
    public static void main(String[] args){
//        Board<Key, Integer> board = new SquareBoard<Integer>(4);
//        Game game2048 = new Game2048();
//        System.out.println(game2048.canMove());

        try (Resource bis = new Resource("Resource 1")) {
            System.out.println("start try");
            throw new RuntimeException(" RE ");
        } catch (RuntimeException e) {
            System.err.println(e);
        } finally {
            System.out.println("handsome finally");
        }

    }
}

class Resource implements AutoCloseable {

    String name;

    public Resource(String name) {
        this.name = name;
        System.out.println("Open: [" + name+"]");
    }

    @Override
    public void close() {
        System.out.println("Close resource");
    }
}


