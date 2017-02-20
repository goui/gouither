package fr.goui.gouither.map;

import com.google.android.gms.maps.model.LatLng;

import fr.goui.gouither.GouitherApplication;
import fr.goui.gouither.model.WeatherResult;
import fr.goui.gouither.network.NetworkService;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Presenter for the maps view. All the logic will be present here.
 */
class MapsPresenter implements IMapsPresenter {

    /**
     * Associated view.
     */
    private IMapsView mView;

    /**
     * RxJava subscription object
     */
    private Subscription mSubscription;

    /**
     * The weather forecast result.
     */
    private WeatherResult mWeatherResult;

    @Override
    public void attachView(IMapsView view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mView.clearMarkers();
        mView.addMarker(latLng);
        mView.moveCameraTo(latLng);
        loadForecast(latLng);
    }

    /**
     * Loads forecast from backend.
     *
     * @param latLng the forecast location
     */
    private void loadForecast(LatLng latLng) {
        mView.hidePreviewText();
        mView.showProgressBar();
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
        GouitherApplication application = GouitherApplication.get(mView.getContext());
        NetworkService service = application.getNetworkService();
        mSubscription = service.getForecast(String.valueOf(latLng.latitude), String.valueOf(latLng.longitude))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeatherResult>() {
                    @Override
                    public void onCompleted() {
                        showResult();
                        mView.hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showMessage(e.getMessage());
                        mView.hideProgressBar();
                    }

                    @Override
                    public void onNext(WeatherResult result) {
                        mWeatherResult = result;
                    }
                });
    }

    /**
     * Shows the forecast result in the view.
     */
    private void showResult() {
        mView.setTemperature((int) mWeatherResult.getCurrently().getTemperature());
        mView.setHumidity((int) (mWeatherResult.getCurrently().getHumidity() * 100));
        mView.setPrecipitationProbability((int) (mWeatherResult.getCurrently().getPrecipProbability() * 100));
        mView.setWindSpeed(mWeatherResult.getCurrently().getWindSpeed());
        mView.setCloudCover((int) (mWeatherResult.getCurrently().getCloudCover() * 100));
    }
}
