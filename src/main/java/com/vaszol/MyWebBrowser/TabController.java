package com.vaszol.MyWebBrowser;

import com.vaszol.MyWebBrowser.view.model.AddTab;
import com.vaszol.MyWebBrowser.view.model.WrapWorkPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TabController implements Initializable {
    @FXML
    private TabPane tabPane;
    private AddTab addTab = new AddTab();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);
        addTab.setOnSelectionChanged(event -> {
            if (addTab.isSelected()) {
                addTab();
            }
        });
        tabPane.getTabs().add(addTab);
        addTab();
    }

    private void addTab() {
        int i = tabPane.getTabs().indexOf(addTab);
        System.out.println("size" + tabPane.getTabs().size());
//        if(tabPane.getTabs().size() == 1) return;
        tabPane.getTabs().remove(addTab);
        try {
            Tab tab = new Tab("www.google.com");
            WrapWorkPane workPane = new WrapWorkPane();
            workPane.getControl().setTab(tab);

            tab.setContent(workPane.getPane());
            tab.setOnCloseRequest(event -> {
                if (tabPane.getTabs().size() == 2) event.consume();
            });
            tab.setOnClosed(event -> {
                onTabClose(tab, workPane);

            });

            tabPane.getTabs().add(tab);
            SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
            selectionModel.select(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
        tabPane.getTabs().add(addTab);
    }

    private void onTabClose(Tab tab, WrapWorkPane wrapWorkPane) {
        wrapWorkPane.getControl().setOnClosed();
    }


}
