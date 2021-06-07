package br.edu.class07;

public class ViewReverterController {
    private ViewReverter view;

    public ViewReverterController(ViewReverter view) {
        this.view = view;
    }

    public void reverse() {
        StringBuilder sb = new StringBuilder(view.getInput());
        view.setText("Reverse: " + sb.reverse());
    }
}
