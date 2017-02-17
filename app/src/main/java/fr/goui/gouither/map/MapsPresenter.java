package fr.goui.gouither.map;

/**
 * Presenter for the maps view. All the logic will be present here.
 */
class MapsPresenter implements IMapsPresenter {

    /**
     * Associated view.
     */
    private IMapsView mView;

    @Override
    public void attachView(IMapsView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
