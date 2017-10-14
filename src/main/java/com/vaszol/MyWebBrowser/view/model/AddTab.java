package com.vaszol.MyWebBrowser.view.model;

import javafx.scene.control.Tab;

/**
 * <h>Это закладка в виде кнопки добавления закладок</h>
 */
public class AddTab extends Tab {
    public AddTab() {
        textProperty().set(" + ");
        setClosable(false);
    }
}
