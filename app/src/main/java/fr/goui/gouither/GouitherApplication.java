package fr.goui.gouither;

import android.app.Application;
import android.content.Context;

import fr.goui.gouither.network.NetworkService;

/**
 * Custom application storing the retrofit object instance.
 */
public class GouitherApplication extends Application {

    private NetworkService mNetworkService;

    public static GouitherApplication get(Context context) {
        return (GouitherApplication) context.getApplicationContext();
    }

    public NetworkService getNetworkService() {
        if (mNetworkService == null) {
            mNetworkService = NetworkService.Factory.create();
        }
        return mNetworkService;
    }
}
