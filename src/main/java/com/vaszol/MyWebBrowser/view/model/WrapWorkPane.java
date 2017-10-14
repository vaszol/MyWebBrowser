package com.vaszol.MyWebBrowser.view.model;

import com.vaszol.MyWebBrowser.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * <h>Обертка рабочей панели</h>
 */
public class WrapWorkPane extends Pane {
    private Pane pane;
    private Controller control;

    public WrapWorkPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        pane = loader.load();
        control = loader.getController();
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Controller getControl() {
        return control;
    }

    public void setControl(Controller control) {
        this.control = control;
    }
}
