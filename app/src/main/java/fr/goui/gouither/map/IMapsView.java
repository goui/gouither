package fr.goui.gouither.map;

import fr.goui.gouither.IView;
import fr.goui.gouither.model.WeatherResult;

/**
 * View interface for the map.
 */
interface IMapsView extends IView {

    /**
     * Shows the weather forecast result.
     *
     * @param result weather forecast result
     */
    void showResult(WeatherResult result);
}
