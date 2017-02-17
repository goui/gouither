package fr.goui.gouither.network;

import fr.goui.gouither.model.WeatherResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Network interface containing all the endpoints signature.
 * The factory creates the retrofit object.
 */
public interface NetworkService {

    String BASE_URL = "https://api.darksky.net/forecast/";

    /**
     * You need an API key to use DarkSky web api.
     *
     * @see <a href="https://darksky.net/dev/">https://darksky.net/dev/</a>
     */
    String API_KEY = "";

    String URL = "https://api.darksky.net/forecast/" + API_KEY;

    @GET("/{latitude},{longitude}")
    Observable<WeatherResult> getForecast(@Path("latitude") String latitude, @Path("longitude") String longitude);

    class Factory {
        public static NetworkService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(NetworkService.class);
        }
    }
}
