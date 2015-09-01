package screen;

/**
 *
 * The manager class that switches between different screens
 *
 */
public class ScreenManager {

    private static Screen currentScreen;
    /**
     * Sets the screen to the
     * @param screen Object of type Screen
     */
    public static void setScreen(Screen screen) {
        if (currentScreen != null)
            currentScreen.dispose();
        currentScreen = screen;
        currentScreen.create();
    }
    /**
     * @return The current screen being displayed.
     */
    public static Screen getCurrentScreen() {
        return currentScreen;
    }

}
