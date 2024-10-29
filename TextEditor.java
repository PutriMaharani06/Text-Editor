import java.util.Scanner;
import java.util.Stack;

public class TextEditor {
    private StringBuilder text;
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
}

    public void show() {
        System.out.println("Teks saat ini: " + text.toString());
    }

    public void write(String newText) {
        undoStack.push(text.toString());
        redoStack.clear();
        text.append(newText);
        System.out.println("Teks ditambahkan: " + newText);
    }
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pop());
            System.out.println("Undo dilakukan.");
        } else {
            System.out.println("Tidak ada tindakan yang dapat di-undo.");
        }
    }


        public void redo () {
            if (!redoStack.isEmpty()) {
                undoStack.push(text.toString());
                text = new StringBuilder(redoStack.pop());
                System.out.println("Redo dilakukan.");
            } else {
                System.out.println("Tidak ada tindakan yang dapat di-redo.");
            }
        }

        public static void main(String[]args){
            Scanner scanner = new Scanner(System.in);
            TextEditor editor = new TextEditor();
            String command;

            System.out.println("Simulasi Text Editor");
            System.out.println("Perintah: show, write <teks>, undo, redo, exit");

            while (true) {
                System.out.println("Masukkan perintah: ");
                command = scanner.nextLine();

                if (command.equalsIgnoreCase("exit")) {
                    break;
                } else if (command.equalsIgnoreCase("show")) {
                    editor.show();
                } else if (command.startsWith("write ")) {
                    String newText = command.substring(6);
                    editor.write(newText);
                } else if (command.equalsIgnoreCase("undo")) {
                    editor.undo();
                } else if (command.equalsIgnoreCase("redo")) {
                    editor.redo();
                } else {
                    System.out.println("Perintah tidak dikenali. Silahkan coba lagi.");
                }
            }
            scanner.close();
            System.out.println("Program selesai");
        }
    }





