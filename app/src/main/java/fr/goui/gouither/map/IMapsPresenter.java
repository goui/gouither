package fr.goui.gouither.map;

import com.google.android.gms.maps.model.LatLng;

import fr.goui.gouither.IPresenter;

/**
 * Presenter interface for the map.
 */
interface IMapsPresenter extends IPresenter<IMapsView> {

    /**
     * When map is clicked.
     *
     * @param latLng the click location
     */
    void onMapClick(LatLng latLng);
}
