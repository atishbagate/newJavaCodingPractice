package OOPS.abstraction.UsingInterfaces;

interface Pen {
    void write();
}

class PenNote implements Pen {
    @Override
    public void write() {
        System.out.println("writing a note");
    }
}

class Signature implements Pen {
    @Override
    public void write() {
        System.out.println("taking a signature");
    }
}

class Drawing implements Pen {
    @Override
    public void write() {
        System.out.println("drawing on a paper");
    }
}

public class PenWorking {
    public static void main(String[] args) {
        PenNote penNote = new PenNote();
        Signature signature = new Signature();
        Drawing drawing = new Drawing();
        drawing.write();
        penNote.write();
        signature.write();
    }
}
