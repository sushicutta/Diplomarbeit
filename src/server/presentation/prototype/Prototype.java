package server.presentation.prototype;

import server.layout.GridLayoutExample;

import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class Prototype extends com.vaadin.Application {

    /**
     * Init is invoked on application load (when a user accesses the application
     * for the first time).
     */
    @Override
    public void init() {

        // Main window is the primary browser window
        final Window main = new Window("Hello window");
        setMainWindow(main);

        // "Hello world" text is added to window as a Label component
        main.addComponent(new GridLayoutExample());
//        main.addComponent(new Label("Jo das isch es"));
    }

}
