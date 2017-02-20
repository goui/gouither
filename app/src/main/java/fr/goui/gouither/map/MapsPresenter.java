package fr.goui.gouither.map;

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
    public void loadForecast(double latitude, double longitude) {
        mView.showProgressBar();
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
        GouitherApplication application = GouitherApplication.get(mView.getContext());
        NetworkService service = application.getNetworkService();
        mSubscription = service.getForecast(String.valueOf(latitude), String.valueOf(longitude))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<WeatherResult>() {
                    @Override
                    public void onCompleted() {
                        // TODO show result in forecast layout
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
}
