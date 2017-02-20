package fr.goui.gouither.map;

import fr.goui.gouither.IPresenter;

/**
 * Presenter interface for the map.
 */
interface IMapsPresenter extends IPresenter<IMapsView> {

    /**
     * Gets forecast information from web api.
     *
     * @param latitude  lat
     * @param longitude lng
     */
    void loadForecast(double latitude, double longitude);
}
