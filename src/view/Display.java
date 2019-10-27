package view;

public class Display implements ResponseViewer {
    private static final Display display = new Display();

    public Display getDisplay() {
        return display;
    }

    @Override
    public void displayResponse(String response) {
        System.out.println(response);
    }
}
